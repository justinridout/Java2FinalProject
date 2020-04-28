package stash.beans;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
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
	private int ageInMonths;
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
	
	//Helper Functions
	
	public int convertToAgeInMonths(Date dateToConvert) {
	    
	LocalDate date = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	
	Period p = date.until(LocalDate.now());		
	int years = p.getYears();
	int months = p.getMonths();
	int totalMonths = years*12 + months;
	
	return totalMonths;
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
		
		return this.purchaseDate;
	}
	
	public String formatDate() {

		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		c.setTime(purchaseDate);
		
		c.add(Calendar.DATE, 1);
		
		this.purchaseDate = c.getTime();
		
		return formatter.format(this.purchaseDate);  
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
		return convertToAgeInMonths(this.purchaseDate);
	}

	public int getRemainingLifePercentage() {
		
		this.remainingLifePercentage = (int) (100 - (((double)ageInMonths/lifeCycle)* 100));
		return remainingLifePercentage;
	}

	public BigDecimal getActualCashValue() {
		System.out.println("Replacement cost: " + replacementCost);
		System.out.println("Age In Months: " + ageInMonths);
		System.out.println("REPLACEMENT COST" + replacementCost.subtract(replacementCost.multiply(new BigDecimal((double)ageInMonths/lifeCycle))));			
		BigDecimal returnValue = replacementCost.subtract(replacementCost.multiply(new BigDecimal((double)ageInMonths/lifeCycle))).setScale(2, RoundingMode.HALF_UP);
		
		return returnValue;

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
