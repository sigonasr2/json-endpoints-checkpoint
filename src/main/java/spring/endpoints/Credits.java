package spring.endpoints;

import java.lang.reflect.Field;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@RequestMapping
public class Credits{
	Person person;
	@JsonCreator
	Credits(@JsonProperty("person") Person person) {
		this.person = person;
	}
	@JsonProperty("Person")
	public Person getPerson() {
		return person;
	}
	@JsonProperty("Person")
	public void setPerson(Person person) {
		this.person = person;
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
