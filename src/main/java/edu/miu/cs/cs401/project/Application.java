package edu.miu.cs.cs401.project;

import edu.miu.cs.cs401.project.service.ReservationSystemService;
import edu.miu.cs.cs401.project.service.ServiceFactory;

public class Application {
//hello

	public static void main(String[] args) {
		System.out.println("Airline Reservation System");

		ReservationSystemService service = ServiceFactory.getReservationSystemService();
		System.out.println(service.findAllAirports());
		
		System.out.println(service.findAirportByAirportCode("CID"));
		// orgil
	}

}
