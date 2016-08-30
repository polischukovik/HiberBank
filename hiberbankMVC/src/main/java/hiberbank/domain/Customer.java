package hiberbank.domain;

import java.io.Serializable;

import javax.persistence.*;

import hiberbank.domain.enums.CustomerStatus;
import hiberbank.domain.enums.CustomerType;

@Entity
@Table(name = "Customers", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"IPN"}) })
//@NamedQueries({
//	@NamedQuery(name="Customer.getCustomerByName", query="SELECT c FROM Customer c WHERE CONCAT(FIRST_NAME, LAST_NAME, FAMILY_NAME) LIKE \"%:P1%\"")
//})
public class Customer implements Serializable{	
	
	@Id
	@SequenceGenerator(name="SEQ_ID_CUSTOMERS", sequenceName="SEQ_ID_CUSTOMERS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_CUSTOMERS")
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
    @Enumerated(EnumType.ORDINAL)
	private CustomerStatus status;
	
    @Column(name="TYPE")
    @Enumerated(EnumType.ORDINAL)
	private CustomerType type;	
    
    @Column(name="CREATED_BY")
    private int createdBy;
	
    @Column(name="MODIFIED_BY")
    private int modifiedBy;
	
	@Column(name="CREATED_TS", nullable=false)
	private long createdTs;
	
	@Column(name="MODIFIED_TS", nullable=false)
	private long modifiedTs;
		
	public Customer(){
		
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", familyName="
				+ familyName + ", ipn=" + ipn + "]";
	}

	public Customer(int id, String firstName, String lastName, String familyName, String ipn, CustomerStatus status,
			CustomerType type, int createdBy, int modifiedBy, long createdTs, long modifiedTs) {
		super();
		this.id = id;
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

	public void setIpn(String ipn) {
		this.ipn = ipn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public CustomerStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerStatus status) {
		this.status = status;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public long getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(long createdTs) {
		this.createdTs = createdTs;
	}

	public long getModifiedTs() {
		return modifiedTs;
	}

	public void setModifiedTs(long modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	public String getIpn() {
		return ipn;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
