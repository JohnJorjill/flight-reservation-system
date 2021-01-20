package edu.miu.cs.cs401.project.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import edu.miu.cs.cs401.project.domain.Agent;
import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.Flight;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Reservation;
import edu.miu.cs.cs401.project.repository.ReservationSystemRepository;

public class ReservationSystemServiceImpl implements ReservationSystemService {
	
	private ReservationSystemRepository repository;
	
	public ReservationSystemServiceImpl(ReservationSystemRepository repository) throws Exception{
		super();
		this.repository = repository;
	}

	@Override
	public Collection<Airport> findAllAirports() {
		return repository.findAllAirports();
	}

	@Override
	public Airport findAirportByAirportCode(String airportCode) {
		return repository.findAirportByAirportCode(airportCode);
	}

	@Override
	public Collection<Airport> findAirportsByCity(String city) {
		// TODO Auto-generated method stub
		return repository.findAirportsByCity(city);
	}

	@Override
	public Collection<Airline> findAirlinesByAirportCode(String airportCode) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Reservation> findReservationsByPassengerId(Integer passengerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> findPassengersByAgentCode(String agentCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation createReservation(Passenger passenger, Collection<Flight> flights) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation createReservation(Agent agent, Passenger passenger, Collection<Flight> flights) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmReservation(String reservationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelReservation(String reservationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Flight> findFlightsFromTo(String departure, String arrival, LocalDate flightDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmReservation(String reservationCode, String agentCode) {
		// TODO Auto-generated method stub
		
	}

}
