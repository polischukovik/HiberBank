package hiberbank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import hiberbank.domain.enums.AccountStatus;

@Entity
@Table(name = "Accounts", uniqueConstraints = {
		@UniqueConstraint(columnNames={"ACC_CLASS", "ACC_KEY", "ACC_SUBACC"})})
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="ACC_CLASS", nullable=false)
	private String accClass;
	@Column(name="ACC_KEY", nullable=false)
	private String accKey;
	@Column(name="ACC_SUBACC", nullable=false)
	private String accSubacc;
	@Column(name="CUSTOMER", nullable=false)
	private int customer;
	@Column(name="STATUS", nullable=false)
    @Enumerated(EnumType.ORDINAL)
	private AccountStatus status;
	@Column(name="AMOUNT", nullable=false)
	private double amount;
	@Column(name="AMOUNT_DYN", nullable=false)
	private double amountDyn;
	@Column(name="CCY", nullable=false)
	private int ccy;
	@Column(name="CREATED_BY", nullable=false)
	private int createdBy;
	@Column(name="MODIFIED_BY", nullable=false)
	private int modifiedBy;
	@Column(name="CREATED_TS", nullable=false)
	private long createdTs;
	@Column(name="MODIFIED_TS", nullable=false)
	private long modifiedTs;	
		
	public Account(String accClass, String accKey, String accSubacc, int customer, AccountStatus status, double amount,
			double amountDyn, int ccy, int createdBy, int modifiedBy, long createdTs, long modifiedTs) {
		super();
		this.accClass = accClass;
		this.accKey = accKey;
		this.accSubacc = accSubacc;
		this.customer = customer;
		this.status = status;
		this.amount = amount;
		this.amountDyn = amountDyn;
		this.ccy = ccy;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdTs = createdTs;
		this.modifiedTs = modifiedTs;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccClass() {
		return accClass;
	}
	public void setAccClass(String accClass) {
		this.accClass = accClass;
	}
	public String getAccKey() {
		return accKey;
	}
	public void setAccKey(String accKey) {
		this.accKey = accKey;
	}
	public String getAccSubacc() {
		return accSubacc;
	}
	public void setAccSubacc(String accSubacc) {
		this.accSubacc = accSubacc;
	}
	public int getCustomer() {
		return customer;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmountDyn() {
		return amountDyn;
	}
	public void setAmountDyn(double amountDyn) {
		this.amountDyn = amountDyn;
	}
	public int getCcy() {
		return ccy;
	}
	public void setCcy(int ccy) {
		this.ccy = ccy;
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
}
