package edu.miu.cs.cs401.project.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import edu.miu.cs.cs401.project.domain.Agent;
import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.domain.FlightInstance;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Reservation;

public interface ReservationSystemService {
	
//	Collection<Airport> findAllAirports();
//	
//	Airport findAirportByAirportCode(String airportCode);
//	
//	Collection<Airport> findAirportsByCity(String city); // Airport(s) of a city, e.g. Chicago has two major airports
//	
//	Collection<Airline> findAirlinesByAirportCode(String airportCode);
//	
//	List<Flight> findFlightsFromTo(String departure, String arrival, LocalDate flightDate);
//	
//	Collection<Reservation> findReservationsByPassengerId(Integer passengerId);
//	
//	List<Passenger> findPassengersByAgentCode(String agentCode);
//	
//	Reservation createReservation(Passenger passenger, Collection<Flight> flights); // Passenger reserves
//	
//	Reservation createReservation(Agent agent, Passenger passenger, Collection<Flight> flights); // Agent reserves
//	
//	void confirmReservation(String reservationCode);
//	
//	void confirmReservation(String reservationCode, String agentCode);
//	
//	void cancelReservation(String reservationCode);
	
List<Airport> findAllAirports();
	
	Airport findAirportByAirportCode(String airportCode);
	
	List<Airport> findAirportsByCity(String city); // Airport(s) of a city, e.g. Chicago has two major airports
	
	List<Airline> findAirlinesByAirportCode(String airportCode);
	
	List<FlightInstance> findFlightsFromTo(String departure, String arrival, LocalDate date);
	
	List<Reservation> findReservationsByPassengerId(String passengerId);

	HashMap<Passenger, List<Reservation>> findReservationsByAgentCode(String agentCode) throws Exception;
	
	Reservation createReservation(Passenger passenger, List<FlightInstance> flights); // Passenger reserves
	
	Reservation createReservation(Agent agent, Passenger passenger, List<FlightInstance> flights); // Agent reserves

	void viewReservationDetails(String agentCode, String reservationCode) throws Exception;
	
	void confirmReservation(Passenger passenger, String reservationCode) throws Exception;
	
	void cancelReservation(Passenger passenger, String reservationCode) throws Exception;

	void confirmReservation(Agent agent, String reservationCode) throws Exception;
	
	void cancelReservation(Agent agent, String reservationCode) throws Exception;
	
}
