package ch.hearc.beershopfull.catalog.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Model of a beer
 * @author Seb
 *
 */
public class Beer {


	private String name;
	private BigDecimal price;
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		return Objects.equals(id, other.id);
	}

	private Integer stock;
	private Integer id;


	public Integer getId() {
		return id;
	}

	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

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

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
