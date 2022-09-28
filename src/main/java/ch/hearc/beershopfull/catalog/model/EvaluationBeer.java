package ch.hearc.beershopfull.catalog.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EvaluationBeer {
	
	@ManyToOne
    @JoinColumn(name="beer_id", nullable=false)
	private Beer beer;
	private Integer note;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	
	
	public EvaluationBeer() {
		super();
	}



	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(beer, id, note);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluationBeer other = (EvaluationBeer) obj;
		return Objects.equals(beer, other.beer) && Objects.equals(id, other.id) && Objects.equals(note, other.note);
	}

	public Beer getBeer() {
		return beer;
	}

	public void setBeer(Beer beer) {
		this.beer = beer;
	}

	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	
	public EvaluationBeer(Integer note) {
		this.note = note;
	}
	

}
