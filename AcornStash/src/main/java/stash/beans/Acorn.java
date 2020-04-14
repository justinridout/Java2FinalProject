package stash.beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Acorn {
	private String name;
	private BigDecimal replacementCost;
	private String category;
	private Date purchaseDate;
	private int lifeCycle;
	private int ageInMonths;
	private double remainingLifePercentage;
	private BigDecimal actualCashValue;	
		
	public Acorn() {
		super();
	}
	
	public Acorn(String name, BigDecimal replacementCost, Date purchaseDate, int lifeCycle) {
		super();
		this.name = name;
		this.replacementCost = replacementCost;
		this.purchaseDate = purchaseDate;
		this.lifeCycle = lifeCycle;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getLifeCycle() {
		return lifeCycle;
	}

	public void setLifeCycle(int lifeCycle) {
		this.lifeCycle = lifeCycle;
	}

	public int getAgeInMonths() {
		return ageInMonths;
	}

	public double getRemainingLifePercentage() {
		return remainingLifePercentage;
	}

	public BigDecimal getActualCashValue() {
		return actualCashValue;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Acorn [name=" + name + ", replacementCost=" + replacementCost + ", category=" + category
				+ ", purchaseDate=" + purchaseDate + ", lifeCycle=" + lifeCycle + ", ageInMonths=" + ageInMonths
				+ ", remainingLifePercentage=" + remainingLifePercentage + ", actualCashValue=" + actualCashValue + "]";
	}

	
}
