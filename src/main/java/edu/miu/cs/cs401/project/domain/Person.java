package edu.miu.cs.cs401.project.domain;
import java.time.LocalDate;
import java.util.UUID;


public class Person {
	private final String id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String email;
	private Address address;

	public Person(Address address, String firstName, String lastName, LocalDate birthday, String email) {
		this.setAddress(address);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthday(birthday);
		this.setEmail(email);
		this.id = UUID.randomUUID().toString();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}	
}
