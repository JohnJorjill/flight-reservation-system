package edu.miu.cs.cs401.project.domain;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

public class Ticket {
	private String id;
	private String number;
	private FlightInstance flightInstance;
	private String reservationCode;
	
	public Ticket(String reservationCode, FlightInstance flightInstance) {
		this.id = UUID.randomUUID().toString();
		this.reservationCode = reservationCode;
		this.flightInstance = flightInstance;
		this.number = generateNumber();
	}
	
	
	
    public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public FlightInstance getFlightInstance() {
		return flightInstance;
	}



	public void setFlightInstance(FlightInstance flightInstance) {
		this.flightInstance = flightInstance;
	}



	public String getReservationCode() {
		return reservationCode;
	}



	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}



	@Override
    public String toString() {
        return "Ticket{" +
                "reservationCode='" + reservationCode + '\'' +
                ", number='" + number + '\'' +
                ", flight=" + flightInstance +
                '}';
    }
	
    private String generateNumber() {
        int length = 20;
        boolean useLetters = false;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString.toUpperCase();
    }
}
