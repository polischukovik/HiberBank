package ua.kyiv.polischukovik.HiberBank;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Customers", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"INN"}) })
@NamedQueries({
	@NamedQuery(name="Customers.getCustomersByName", query="SELECT c FROM Customer c WHERE CONCAT(FIRST_NAME, LAST_NAME, FAMILY_NAME) LIKE '%:P1%'")
})
public class Customer {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	@Column(name="FAMILY_NAME", nullable=false)
	private String familyName;
	@Column(name="IPN", nullable=false, unique=true)
	private String ipn;
	@Column(name="STATUS", nullable=false)
	private int status;
	@Column(name="TYPE")
	private int type;	
	@Column(name="CREATED_BY", nullable=false)
	private int createdBy;
	@Column(name="MODIFIED_BY", nullable=false)
	private int modifiedBy;
	@Column(name="CREATED_TS", nullable=false)
	private long createdTs;
	@Column(name="MODIFIED_TS", nullable=false)
	private long modifiedTs;
	
//	@ManyToMany(mappedBy="Customer", cascade = CascadeType.ALL)
//	List<Customer> customers = new ArrayList<>();
	


	
	public Customer(){
		
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", familyName="
				+ familyName + ", ipn=" + ipn + "]";
	}



	public Customer(String firstName, String lastName, String familyName, String ipn, int status, int type,
			int createdBy, int modifiedBy, long createdTs, long modifiedTs) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.familyName = familyName;
		this.ipn = ipn;
		this.status = status;
		this.type = type;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdTs = createdTs;
		this.modifiedTs = modifiedTs;
	}

	public int getId() {
		return id;
	}
	
	
	
}
