package edu.miu.cs.cs401.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlightInstance {

	private final String id;

	private Flight flightNumber;
	private LocalDate departureDate;
	private LocalDate arrivalDate;
	private List<Passenger> passengerList;
	private List<Crew> crewList;
	private List<Pilot> pilotList;

	public FlightInstance(Flight flightNumber, LocalDate departureDate, LocalDate arrivalDate, List<Crew> crewList,
			List<Pilot> pilots) {

		this.id = UUID.randomUUID().toString();
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.passengerList = new ArrayList<>();
		this.crewList = crewList;
		this.pilotList = pilotList;
	}

	public Flight getFlightNumber() {
		return flightNumber;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public List<Crew> getCrewList() {
		return crewList;
	}

	public List<Pilot> getPilotList() {
		return pilotList;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void addPassenger(Passenger passenger) throws Exception {
		int totalPassengers = passengerList.size() + crewList.size() + pilotList.size();
		if (totalPassengers > flightNumber.getCapacity()) {
			throw new Exception("There is no free set on this flight");
		}
		passengerList.add(passenger);
	}

	public void removePassenger(Passenger passenger) {
		if (passenger != null) {
			for (Passenger p : passengerList) {
				if (p.getId() == passenger.getId()) {
					passengerList.remove(p);
					break;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Flight{" + "flightNumber=" + flightNumber + ", departureDate=" + departureDate + ", arrivalDate="
				+ arrivalDate + '}';
	}

}
