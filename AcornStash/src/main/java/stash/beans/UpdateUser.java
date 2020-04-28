package stash.beans;

import java.math.BigDecimal;

public class UpdateUser {

	
	private String firstName;
	private String lastName; 
	private BigDecimal cashBalance;
	
	public UpdateUser() {
		
	}
	
	public UpdateUser(String firstname, String lastName, BigDecimal cashBalance) {
		this.firstName = firstname;
		this.lastName = lastName;
		this.cashBalance = cashBalance;
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

	public BigDecimal getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(BigDecimal cashBalance) {
		this.cashBalance = cashBalance;
	}
	
}
