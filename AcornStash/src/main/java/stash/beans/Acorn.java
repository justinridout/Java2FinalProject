package stash.beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class Acorn {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private BigDecimal replacementCost;
	private String category;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date purchaseDate;
	private int lifeCycle;
	private int ageInMonths = 3;
	private int remainingLifePercentage;
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
		this.ageInMonths = 3;
		this.remainingLifePercentage = 0;
		this.actualCashValue = new BigDecimal(0);
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

	public int getRemainingLifePercentage() {
		
		this.remainingLifePercentage = (int) (100 - (((double)ageInMonths/lifeCycle)* 100));
		return remainingLifePercentage;
	}

	public BigDecimal getActualCashValue() {
		System.out.println("Replacement cost: " + replacementCost);
		System.out.println("Age In Months: " + ageInMonths);
		System.out.println("REPLACEMENT COST" + replacementCost.subtract(replacementCost.multiply(new BigDecimal((double)ageInMonths/lifeCycle))));
		return replacementCost.subtract(replacementCost.multiply(new BigDecimal((double)ageInMonths/lifeCycle))).setScale(2);
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
