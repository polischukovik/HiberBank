package ua.kyiv.polischukovik.HiberBank;

public class User {
	private int id;
	private String login;
	private String password;
	private int associatedCustomer;
	
	@Override
	public String toString() {
		return "User [login=" + login + "]";
	}
}
