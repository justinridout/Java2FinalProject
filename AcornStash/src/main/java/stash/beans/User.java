package stash.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
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

	public User(String firstName, String lastName, BigDecimal cashBalance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cashBalance = cashBalance;
	}
	
	public User(String firstName, String lastName, BigDecimal cashBalance, BigDecimal savingsNeed, List<Acorn> a) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cashBalance = cashBalance;
		this.savingsNeed = savingsNeed;
		this.acornList = a;
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
	
	public BigDecimal calcSavingsNeed() {
		BigDecimal needs = new BigDecimal(0);
			for (Acorn a : this.acornList) {
				needs = needs.add((a.getReplacementCost().subtract(a.getActualCashValue())));
			}
		
		return needs;
	}

	public BigDecimal getSavingsNeed() {
		this.savingsNeed = new BigDecimal(0);
		/*
		}*/
		
		System.out.println("USING GETTERS: " + this.savingsNeed);
		return this.savingsNeed;
	}

	public void setSavingsNeed(BigDecimal savingsNeed) {

		this.savingsNeed = savingsNeed;
	}

	public List<Acorn> getAcornList() {
		
		if(this.acornList == null) {
			this.acornList = new ArrayList<Acorn>();
		}
		return acornList;
	}

	public void setAcornList(List<Acorn> acornList) {
		this.acornList = acornList;
	}

	public void addAcorn(Acorn a) {
		if(this.acornList == null) {
			this.acornList = new ArrayList<Acorn>();
		}
		this.acornList.add(a);
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", cashBalance=" + cashBalance
				+ ", savingsNeed=" + savingsNeed + ", acornList=" + acornList + "]";
	}
}
