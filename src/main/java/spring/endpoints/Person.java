package spring.endpoints;

import java.lang.reflect.Field;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@RequestMapping
public class Person {
	String role;
	String firstname;
	String lastname;
	@JsonCreator
	Person(@JsonProperty("role") String role,@JsonProperty("firstname") String firstname,@JsonProperty("lastname") String lastname) {
		this.role=role;
		this.firstname=firstname;
		this.lastname=lastname;
	}

	@JsonProperty("Role")
	public String getRole() {
		return role;
	}

	@JsonProperty("Role")
	public void setRole(String role) {
		this.role = role;
	}

	@JsonProperty("FirstName")
	public String getFirstname() {
		return firstname;
	}

	@JsonProperty("FirstName")
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@JsonProperty("LastName")
	public String getLastname() {
		return lastname;
	}

	@JsonProperty("LastName")
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
