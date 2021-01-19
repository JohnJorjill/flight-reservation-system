package edu.miu.cs.cs401.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Airline {

	private final String id;

	private String code;

	private String name;

	private String history;

	private List<Flight> flightNumberList;

	public Airline(String code, String name, String history) {
		super();
		this.code = code;
		this.name = name;
		this.history = history;
		this.flightNumberList = new ArrayList<Flight>();
		this.id = UUID.randomUUID().toString();
	}

	public void addFlightNumber() {
		// TO DO
	}

	public void validationFlightNumber(Flight fn) throws Exception {
		if (fn.getDepartureAirport().getCode().equals(fn.getArrivalAirport().getCode())) {
			throw new Exception("Invalid Flight Number. Not allowed to depart and arrive and the same airport");
		}
		if (!fn.getDepartureAirport().isAirlineAllowedToDepart(this)) {
			throw new Exception("Invalid Flight Number. Not allowed to depart from the airport "
					+ fn.getDepartureAirport().getCode());
		}

		if (!fn.getArrivalAirport().isAirlineAllowedToArrival(this)) {
			throw new Exception(
					"Invalid Flight Number. Not Allowed to arrive at the airport " + fn.getArrivalAirport().getCode());
		}
	}

	public List<Flight> getFlightNumberList() {
		return flightNumberList;
	}

	public void setFlightNumberList(List<Flight> flightNumberList) {
		this.flightNumberList = flightNumberList;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Airline{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", history='" + history + '\'' + '}';
	}
}
