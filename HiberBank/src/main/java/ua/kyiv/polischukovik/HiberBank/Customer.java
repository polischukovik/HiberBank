package ua.kyiv.polischukovik.HiberBank;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Customers", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"INN"}) })
public class Customer {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cust_id_sq")
	@SequenceGenerator(name = "cust_id_sq", sequenceName = "SQ_CUST_ID")
	@Column(name="ID")
	private int id;
	@Column(name="NAME", nullable=false)
	private String name;
	@Column(name="INN", nullable=false)
	private String inn;
	private int segment;
	private int status;
	@Column(name="CREATED_BY")
	private int createdBy;
	@Column(name="MODIFIED_BY")
	private int modifiedBy;
	@Column(name="CREATED_TS")
	private long createdTs;
	@Column(name="MODIFIED_TS")
	private long modifiedTs;
	
//	@ManyToMany(mappedBy="Customer", cascade = CascadeType.ALL)
//	List<Customer> customers = new ArrayList<>();
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", inn=" + inn + "]";
	}
	
	public Customer(){
		
	}

	public Customer(String name, String inn, int segment, int status, int createdBy, int modifiedBy,
			long createdTs, long modifiedTs) {
		super();
		this.id = id;
		this.name = name;
		this.inn = inn;
		this.segment = segment;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdTs = createdTs;
		this.modifiedTs = modifiedTs;
	}
	
	public static void addCustomer(Customer cust){
		Logging.log.info("Writting new customer to db: " + cust);
		DBTools.writeObject(cust);
	}

	public int getId() {
		return id;
	}
	
	
	
}
