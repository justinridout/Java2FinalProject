package stash.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Acorn {
	private String name;
	private BigDecimal replacementCost;
	private Date purchaseDate;
	private int lifeCycle;
		
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
	
	
	
	

}
