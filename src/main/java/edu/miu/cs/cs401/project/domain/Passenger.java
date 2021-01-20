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
	
	
	
	

}
