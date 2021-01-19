package edu.miu.cs.cs401.project.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.miu.cs.cs401.project.domain.Address;
import edu.miu.cs.cs401.project.domain.Agent;
import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Crew;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.domain.FlightInstance;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Pilot;
import edu.miu.cs.cs401.project.domain.Reservation;

public class ReservationSystemRepositoryImpl implements ReservationSystemRepository {
	
	// Added class variables by Orgil
	private List <Airport> airports = new ArrayList<>();
	private Map<Integer, Passenger> passengers = new HashMap<>();
	private Map<String, Airline> airlines= new HashMap<>();
    private List <FlightInstance> allFlight = new ArrayList<>();

    private Map<Integer, Pilot> pilots= new HashMap<>();
	private Map<Integer, Crew> crews= new HashMap<>();
	private Map<Integer, Agent> agents= new HashMap<>();
	//
	
	ReservationSystemRepositoryImpl() {
		super();
		setupAirports();
	}
	
	private void setupAirports() {
		
		Airport airport;
		
		airport = new Airport("CID", "Eastern Iowa Airport", new Address());
		airports.put(airport.getId(), airport);
		
		airport = new Airport("ORD", "Chicago O'Hare International Airport", new Address());
		airports.put(airport.getId(), airport);
		
		airport = new Airport("CLT", "Charlotte Douglas International Airport", new Address());
		airports.put(airport.getId(), airport);
		
	}

	@Override
	public List<Airport> findAllAirports() {
		return airports.values();
	}

	@Override
	public Airport findAirportByAirportCode(String airportCode) {
		for(Airport airport : findAllAirports()) {
			if(airport.getCode().equalsIgnoreCase(airportCode)) {
				return airport;
			}
		}
		return null;
	}

	@Override
	public Collection<Airport> findAirportsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Airline> findAirlinesByAirportCode(String airportCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Flight> findFlightsFromTo(String departure, String arrival) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Reservation> findReservationsByPassengerId(Integer passengerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Passenger> findPassengersByAgentCode(String agentCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
