package edu.miu.cs.cs401.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Airport {

	private final String id;

	private String code;
	private String name;
	private Address address;
	private List<Airline> arrivalAirlines;
	private List<Airline> departureAirlines;

	public Airport(String code, String name, Address address) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.id = UUID.randomUUID().toString();
		arrivalAirlines = new ArrayList<>();
		departureAirlines = new ArrayList<>();
	}

	public void addArrivalAirline(Airline airline) {
		arrivalAirlines.add(airline);
	}

	public void addDepartureAirline(Airline airline) {
		departureAirlines.add(airline);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



	public String getCode() {
		return code;
	}

	public List<Airline> getdepartureAirlines() {
		return departureAirlines;
	}

	public boolean isAirlineAllowedToDepart(Airline airline) {
		for (Airline al : this.departureAirlines) {
			if (airline.getCode().equals(al.getCode())) {
				return true;
			}
		}
		return false;
	}

	public boolean isAirlineAllowedToArrival(Airline airline) {
		for (Airline al : this.arrivalAirlines) {
			if (airline.getCode().equals(al.getCode())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Airport{" + "code='" + code + '\'' + ", name='" + name + '\'' + '}';
	}

}
