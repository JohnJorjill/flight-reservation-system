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

	//add a flight to the list of flights
	public void addFlightNumber(Flight fn)throws Exception {
		validationFlightNumber(fn);
		this.flightNumberList.add(fn);
	}

	public void validationFlightNumber(Flight fn) throws Exception {
		//if departure airport is equal to arrival airport
		if (fn.getDepartureAirport().getCode().equals(fn.getArrivalAirport().getCode())) {
			throw new Exception("Invalid Flight Number. Not allowed to depart and arrive and the same airport");
		}
		
		//check whether a flight is allowed to departure from that airport
		if (!fn.getDepartureAirport().isAirlineAllowedToDepart(this)) {
			throw new Exception("Invalid Flight Number. Not allowed to depart from the airport "
					+ fn.getDepartureAirport().getCode());
		}

		//check whether a flight is allowed to arrive at that airport
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
