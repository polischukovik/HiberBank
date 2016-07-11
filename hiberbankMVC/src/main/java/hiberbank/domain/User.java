package hiberbank.domain;

import javax.persistence.*;

@Entity
@Table(name="Users")
@NamedQueries({
	@NamedQuery(name="Users.getUserByName", query="SELECT u FROM User u WHERE CONCAT(FIRST_NAME, LAST_NAME, FAMILY_NAME) LIKE '%:P1%'")
})
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false, unique=true)
	private int id;

	private String login;
	private String password;
	private int associatedCustomer;
	
	@Override
	public String toString() {
		return "User [login=" + login + "]";
	}
}