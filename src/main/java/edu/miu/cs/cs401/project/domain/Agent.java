package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agent extends Person{
	
	private List<Passenger> passengerList;

	public Agent(Address address, String firstName, String lastName, LocalDate birthday, String email) {
		super(address, firstName, lastName, birthday, email);
		 passengerList = new ArrayList<>();
	}

	public void addPassenger(Passenger passenger) {
		this.passengerList.add(passenger);
	}
	
	
	public List<Passenger> getPassengerList(){
		return this.passengerList;
	}
	
	//passenger can cancel reservation based on the reservation code
	public void cancelReservation(String reservationCode) throws Exception {
		Passenger passenger = getPassengerFromReservationCode(reservationCode);
		if(passenger == null) {
			throw new Exception("Resrvation code: " + reservationCode + " not found");
		}
		passenger.cancelReservation(reservationCode);
	}
	
	
	public void confirmReservation(String reservationCode) throws Exception{
		Passenger passenger = getPassengerFromReservationCode(reservationCode);
		if(passenger == null) {
			throw new Exception("Reservation code: " + reservationCode + " not found");
		}
		passenger.confirmReservation(reservationCode);
	}
	
	//find passenger based on the reservation code
	public Passenger getPassengerFromReservationCode(String reservationCode) {
		Passenger passenger = null;
		for(Passenger p:passengerList) {
			if(p.findReservationByCode(reservationCode)!=null) {
				passenger = p;
				break;
			}
		}
		return passenger;
	}
}
