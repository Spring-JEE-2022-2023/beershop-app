package ch.hearc.beershopfull.catalog.model;

import java.util.Objects;

public class EvaluationBeer {
	
	private Integer id;
	private Integer beerId;
	private Integer note;
	
	public Integer getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(beerId, id);
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
		return Objects.equals(beerId, other.beerId) && Objects.equals(id, other.id);
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBeerId() {
		return beerId;
	}
	public void setBeerId(Integer beerId) {
		this.beerId = beerId;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	
	

}
