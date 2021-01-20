package edu.miu.cs.cs401.project.repository;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	private List<Airport> airports = new ArrayList<>();
	private Map<Integer, Passenger> passengers = new HashMap<>();
	private Map<String, Airline> airlines = new HashMap<>();
	private List<FlightInstance> allFlight = new ArrayList<>();

	private Map<Integer, Pilot> pilots = new HashMap<>();
	private Map<Integer, Crew> crews = new HashMap<>();
	private Map<Integer, Agent> agents = new HashMap<>();
	


	// added constructor by Orgil
	// setupAirports() setupPassengers() setupAgents() will work on
	// instantiation of ReservationSystemRepositoryImpl class
	public ReservationSystemRepositoryImpl() {
		super();
		setupAirports();
		// setupPassengers();
		// setupAgents();
	}

	private void setupAirports() {
		Airport airport1;
		Airport airport2;
		Airport airport3;
		Airport airport4;
		Airport airport5;

		airport1 = new Airport("CID", "Eastern Iowa Airport", new Address());		
		airport2 = new Airport("ORD", "Chicago O'Hare International Airport", new Address());
		airport3 = new Airport("CLT", "Charlotte Douglas International Airport", new Address());
		airport4 = new Airport("APT4", "Airport 4", new Address());
		airport5 = new Airport("APT5", "Airport 5", new Address());
		
		
		//getId => getCode
		Airline airline;
		airline = new Airline("AL", "Airline1", "The best airline since 1940");
		airlines.put(airline.getCode(), airline);
		
		airline = new Airline("AI", "Airline2", "The nicest airline since 1965");
		airlines.put(airline.getCode(), airline);
		
		airline = new Airline("AN", "Airline3", "The coolest airline since 1998");
		airlines.put(airline.getCode(), airline);

	}

	@Override
	public List<Airport> findAllAirports() {
		return airports;

	}

	@Override
	public Airport findAirportByAirportCode(String airportCode) {
		for (Airport airport : findAllAirports()) {
			if (airport.getCode().equalsIgnoreCase(airportCode)) {
				return airport;
			}
		}
		return null;
	}

	@Override
	public List<Airport> findAirportsByCity(String city) {
		// TODO Auto-generated method stub
		return airports
				.stream()
				.filter( a->
					a.getAddress().getCity().equalsIgnoreCase(city)
				)
				.collect(Collectors.toList());
	}

	@Override
	public List<Airline> findAirlinesByAirportCode(String airportCode) {
		// TODO Auto-generated method stub
		return findAirportByAirportCode(airportCode).getdepartureAirlines();
	}

	@Override
	public List<Flight> findFlightsFromTo(String departure, String arrival) {
		return null;
	}

	@Override
	public List<Reservation> findReservationsByPassengerId(Integer passengerId) {
		// TODO Auto-generated method stub
		return passengers.get(passengerId).getReservationList();
	}

	@Override
	public List<Passenger> findPassengersByAgentCode(String agentCode) {
		// TODO Auto-generated method stub
		return agents.get(agentCode).getPassengerList();
	}

	@Override
	public Passenger findPassengerById(int id) {
		// TODO Auto-generated method stub
		return passengers.get(id);
	}

	@Override
	public Agent findAgentById(int id) {
		// TODO Auto-generated method stub
		return agents.get(id);
	}

	@Override
	public String getSampleCity() {
		// TODO Auto-generated method 
		return airports.get(0).getAddress().getCity();
	}

}
