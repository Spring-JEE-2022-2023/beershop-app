package ch.hearc.beershopfull.catalog.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.boot.test.context.SpringBootTest;

@Testable
public class BeerTest {

	@Test
	public void testPopulariteWithDefaultInstance() {
		
		Beer beer = new Beer();
		assertThat(beer.getPopularite()).isEqualTo("0");
	}
	
	@Test
	public void testPopulariteWithOneNote() {
		
		List<EvaluationBeer> evals = new ArrayList<>();
		
		EvaluationBeer evaluationBeer = new EvaluationBeer();
		evaluationBeer.setNote(3);
		evals.add(evaluationBeer);
		
		Beer beer = new Beer();
		beer.setEvaluations(evals);;
		assertThat(beer.getPopularite()).isEqualTo("60,00");
	}
}
