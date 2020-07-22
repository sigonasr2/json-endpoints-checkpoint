package spring.endpoints;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@RequestMapping
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {
	String title;
	int minutes;
	String genre;
	float rating;
	int metascore;
	String description;
	int votes;
	float gross;
	String year;
	List<Credits> credits;
	

	@JsonCreator
	Movie(@JsonProperty("title") String title,
			@JsonProperty("minutes") int minutes,
			@JsonProperty("genre") String genre,
			@JsonProperty("rating") float rating,
			@JsonProperty("metascore") int metascore,
			@JsonProperty("description") String description,
			@JsonProperty("votes") int votes,
			@JsonProperty("gross") float gross,
			@JsonProperty("year") String year,
			@JsonProperty("credits") List<Credits> credits) {
		this.title=title;
		this.minutes=minutes;
		this.genre=genre;
		this.rating=rating;
		this.metascore=metascore;
		this.description=description;
		this.votes=votes;
		this.gross=gross;
		this.year=year;
		this.credits=credits;
	}
	
	@JsonProperty("Title")
	public String getTitle() {
		return title;
	}
	@JsonProperty("Title")
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonProperty("Minutes")
	public int getMinutes() {
		return minutes;
	}
	@JsonProperty("Minutes")
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	@JsonProperty("Genre")
	public String getGenre() {
		return genre;
	}
	@JsonProperty("Genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@JsonProperty("Rating")
	public float getRating() {
		return rating;
	}
	@JsonProperty("Rating")
	public void setRating(float rating) {
		this.rating = rating;
	}
	@JsonProperty("Metascore")
	public int getMetascore() {
		return metascore;
	}
	@JsonProperty("Metascore")
	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}
	@JsonProperty("Description")
	public String getDescription() {
		return description;
	}
	@JsonProperty("Description")
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonProperty("Votes")
	public int getVotes() {
		return votes;
	}
	@JsonProperty("Votes")
	public void setVotes(int votes) {
		this.votes = votes;
	}
	@JsonProperty("Gross")
	public float getGross() {
		return gross;
	}
	@JsonProperty("Gross")
	public void setGross(float gross) {
		this.gross = gross;
	}
	@JsonProperty("Year")
	public String getYear() {
		return year;
	}
	@JsonProperty("Year")
	public void setYear(String year) {
		this.year = year;
	}
	@JsonProperty("Credits")
	public List<Credits> getCredits() {
		return credits;
	}
	@JsonProperty("Credits")
	public void setCredits(List<Credits> credits) {
		this.credits = credits;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName()+"(");
		boolean first=true;
		for (Field f : this.getClass().getDeclaredFields()) {
			if (!first) {
				sb.append(",");
			}
			try {
				sb.append(f.getName()+"="+f.get(this));
				first=false;
			} catch (IllegalArgumentException|IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		sb.append(")");
		return sb.toString();
	}
}
