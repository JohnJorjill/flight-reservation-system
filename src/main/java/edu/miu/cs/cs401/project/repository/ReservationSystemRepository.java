package edu.miu.cs.cs401.project.repository;

import java.util.Collection;
import java.util.List;

import edu.miu.cs.cs401.project.domain.Agent;
import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Reservation;

public interface ReservationSystemRepository {
	
	// changed Collections to List
	List<Airport> findAllAirports();
	
	Airport findAirportByAirportCode(String airportCode);
	
	List<Airport> findAirportsByCity(String city); // Airport(s) of a city, e.g. Chicago has two major airports
	
	List<Airline> findAirlinesByAirportCode(String airportCode);
	
	List<Flight> findFlightsFromTo(String departure, String arrival);
	
	List<Reservation> findReservationsByPassengerId(Integer passengerId);
	
	List<Passenger> findPassengersByAgentCode(String agentCode);
	
	Passenger findPassengerById(int id); // added by Orgil
	
	Agent findAgentById(int id); // added by Orgil
	
	String getSampleCity(); // added by Orgil
	
}
