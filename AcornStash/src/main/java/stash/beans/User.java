package stash.beans;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	private String firstName;
	private String lastName;
	private BigDecimal cashBalance;
	private BigDecimal savingsNeed;
	@ElementCollection
	private List<Acorn> acornList;
	
	
	
	
	
	
	public User() {
		super();
	}






	public User(String firstName, String lastName, BigDecimal cashBalance, BigDecimal savingsNeed,
			List<Acorn> acornList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cashBalance = cashBalance;
		this.savingsNeed = savingsNeed;
		this.acornList = acornList;
	}






	public long getID() {
		return ID;
	}






	public void setID(long iD) {
		ID = iD;
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






	public BigDecimal getSavingsNeed() {
		return savingsNeed;
	}






	public void setSavingsNeed(BigDecimal savingsNeed) {
		this.savingsNeed = savingsNeed;
	}






	public List<Acorn> getAcornList() {
		return acornList;
	}






	public void setAcornList(List<Acorn> acornList) {
		this.acornList = acornList;
	}






	@Override
	public String toString() {
		return "User [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", cashBalance=" + cashBalance
				+ ", savingsNeed=" + savingsNeed + ", acornList=" + acornList + "]";
	}
}
