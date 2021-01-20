package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Passenger extends Person{
	private List<Reservation> reservationList;

	public Passenger(Address address, String firstName, String lastName, LocalDate birthday, String email) {
		super(address, firstName, lastName, birthday, email);
		this.reservationList = new ArrayList<Reservation>();
	}
	
	//find one specific reservation by it's code
	public Reservation findReservationByCode(String reservationCode) {
        Reservation reservation = null;
        for(Reservation res : reservationList) {
            if(res.getReservationCode().equals(reservationCode)) {
                reservation = res;
                break;
            }
        }
        return reservation;
    }
	
	public void cancelReservation(String reservationCode) throws Exception {
        Reservation reservation = findReservationByCode(reservationCode);
        if(reservation == null) {
            throw new Exception("Reservation code: " + reservationCode + " not found");
        }
        if(reservation.getStatus() == Reservation.CANCELED) {
            throw new Exception("The reservation already canceled");
        } else if (reservation.getStatus() == Reservation.CONFIRMED) {
            throw new Exception("Cannot cancel the reservation. The reservation already confirmed and purchased");
        }
        for(FlightInstance flight : reservation.getFlightInstance()) {
            flight.removePassenger(this);
        }
        reservation.setStatus(Reservation.CANCELED);
    }

    public void confirmReservation(String reservationCode) throws Exception {
        Reservation reservation = findReservationByCode(reservationCode);
        if(reservation == null) {
            throw new Exception("Reservation code: " + reservationCode + " not found");
        }
        for(FlightInstance flight : reservation.getFlightInstance()) {
            flight.addPassenger(this);
        }
        reservation.confirmAndPurchase();
    }
}
