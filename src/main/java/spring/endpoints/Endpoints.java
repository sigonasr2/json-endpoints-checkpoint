package spring.endpoints;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class Endpoints {
	@GetMapping("/movies/movie")
	public Movie _1() {
		Movie movie = new Movie("The Godfather",
				175,
				"Crime, Drama",
				9.2f,
				100,
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				1561591,
				134.97f,
				"1972",
				Arrays.asList(new Credits(new Person("Director","Francis Ford","Copolla")),new Credits(new Person("Star","Marlon","Brando")),new Credits(new Person("Star","Al","Pacino")),new Credits(new Person("Star","James","Caan")),new Credits(new Person("Star","Diane","Keaton"))));

		return movie;
	}
	
	@PostMapping("/movies/gross/total")
	public Result _2(@RequestBody List<Movie> movies) {
		float sum = 0;
		System.out.println(movies);
		for (Movie m : movies) {
			sum+=m.gross;
		}
		return new Result(sum);
	}
	
	@RequestMapping
	static class Result{
		float result;
		
		Result(float result) {
			this.result=result;
		}

		public float getResult() {
			return result;
		}

		public void setResult(float result) {
			this.result = result;
		}
		
	}
}
