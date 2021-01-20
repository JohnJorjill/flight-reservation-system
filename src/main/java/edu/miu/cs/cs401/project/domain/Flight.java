package edu.miu.cs.cs401.project.domain;

import java.time.LocalTime;
import java.util.UUID;

public class Flight {

	private final String id;

	private String number;

	private int capacity;

	private LocalTime departureTime;

	private LocalTime arrivalTime;

	private Airport departureAirport;

	private Airport arrivalAirport;

	public Flight(String number, int capacity, LocalTime departureTime, LocalTime arrivalTime, Airport departureAirport,
			Airport arrivalAirport) {

		this.number = number;
		this.capacity = capacity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.id = UUID.randomUUID().toString();
	}

	
	
	public String getId() {
		return id;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	@Override
	public String toString() {
		return "FlightNumber{" + "number='" + number + '\'' + ", capacity=" + capacity + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", departureAirport=" + departureAirport
				+ ", arrivalAirport=" + arrivalAirport + '}';
	}

}
