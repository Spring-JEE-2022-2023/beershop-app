package ch.hearc.beershopfull.catalog.model;

import java.math.BigDecimal;

/**
 * Model of a beer
 * @author Seb
 *
 */
public class Beer {


	public String name;
	public BigDecimal price;


	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	

	public void setPrice(BigDecimal price) {

		this.price = price;
	}
	
	
}
