package ch.hearc.beershopfull.catalog.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Model of a beer
 * @author Seb
 *
 */
public class Beer {


	public List<EvaluationBeer> getEvaluations() {
		return evaluations;
	}

	private String name;
	private BigDecimal price;
	
	private List<EvaluationBeer> evaluations = new ArrayList<EvaluationBeer>();
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public void setEvaluations(List<EvaluationBeer> evaluations){
		this.evaluations = evaluations;
	}
	
	public String getPopularite() {
		df.setRoundingMode(RoundingMode.UP);
		int nbEval = evaluations.size();
		
		if(nbEval == 0) {
			return "0";
		}
		
		int somme = evaluations.stream()
				.map(evaluation -> evaluation.getNote())
				.reduce(0, (a, b) -> a + b); 
		
		return df.format((double)somme/(double)nbEval*20.0d);
		
	}
	
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
