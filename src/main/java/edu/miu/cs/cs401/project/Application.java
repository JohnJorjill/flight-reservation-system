package edu.miu.cs.cs401.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import edu.miu.cs.cs401.project.domain.Address;
import edu.miu.cs.cs401.project.domain.Agent;
import edu.miu.cs.cs401.project.domain.Airline;
import edu.miu.cs.cs401.project.domain.Airport;
import edu.miu.cs.cs401.project.domain.FlightInstance;
import edu.miu.cs.cs401.project.domain.Passenger;
import edu.miu.cs.cs401.project.domain.Reservation;
import edu.miu.cs.cs401.project.domain.Ticket;
import edu.miu.cs.cs401.project.repository.RepositoryFactory;
import edu.miu.cs.cs401.project.repository.ReservationSystemRepository;
import edu.miu.cs.cs401.project.service.ReservationSystemServiceImpl;



public class Application {

	
	private static ReservationSystemRepository reservationSystemRepository;
	private static ReservationSystemServiceImpl reservationSystem;

	static {
		try {
			reservationSystemRepository = RepositoryFactory.getReservationSystemRepository();
			reservationSystem = new ReservationSystemServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Application() throws Exception {
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Airline Reservation System");
		
		actorGetAllAirport();
		actorGetAirportByCode();
		actorFindAirportByCity();
		actorFindAirlinesDepartingFromAirport();

		passengerConfirm_andCancel_Reservation();

		agentConfirm_andCancel_Reservation();

		agentGetPassengerAndReservation();
		agentFindPassengerAndReservation();
		findReservationsByPassengerId();
		searchForFlights();
	}

	private static void actorGetAllAirport() throws Exception {
		// get a list of all Airports
		System.out.println("-------------------- get a list of all Airports -------------------------------");
		List <Airport> allAirports = reservationSystem.findAllAirports();
		String sampleCity = "";
		for (Airport a: allAirports) {
			if(sampleCity.isEmpty()) {
				sampleCity = a.getAddress().getCity();
			}
			System.out.println(a.toString());
		}

	}

	private static void actorGetAirportByCode() throws Exception {
		// find an Airport by AirportCode
		System.out.println("-------------------- find an Airport by AirportCode ----------------------------");
		Airport codeAirports = reservationSystem.findAirportByAirportCode("CLT");
		System.out.println(codeAirports.toString());

	}

	private static void actorFindAirportByCity() throws Exception {
		// find all Airports by a city
		System.out.println("-------------------- find all Airports by a city -------------------------------");
		String sampleCity = reservationSystemRepository.getSampleCity();
		System.out.println("Sample city:" + sampleCity);
		List <Airport> cityAirports = reservationSystem.findAirportsByCity(sampleCity);
		for (Airport a: cityAirports) {
			System.out.println(a.toString());
		}
	}

	private static void actorFindAirlinesDepartingFromAirport() throws Exception {
		// find all Airlines departing from the Airport by AirportCode
		System.out.println("-------- find all Airlines departing from the Airport by AirportCode -----------");
		List <Airline> departingAirlines = reservationSystem.findAirlinesByAirportCode("CLT");
		for (Airline a: departingAirlines) {
			System.out.println(a.toString());
		}

	}

	private static void passengerConfirm_andCancel_Reservation() throws Exception {
		List<FlightInstance> flightsFromCIDToCLTToday = reservationSystem.findFlightsFromTo("CID", "CLT", LocalDate.now());
		System.out.println("Total flights from CID to CLT today: " + flightsFromCIDToCLTToday.size());

		// create two reservations
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");

		ReservationSystemServiceImpl reservationSystem = new ReservationSystemServiceImpl();
		Reservation reservation1 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		Reservation reservation2 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);

		// confirm reservation1
		System.out.println("-------------------- passenger confirm reservation1 -------------------------------");
		System.out.println("Before the Passenger confirm reservation1. Status: " + reservation1.getStatusDetail());
		reservationSystem.confirmReservation(p, reservation1.getReservationCode());
		System.out.println("After the Passenger confirm the reservation1. Status: " + reservation1.getStatusDetail());
		System.out.println("---- list tickets of the reservation1: ");
		for(Ticket t : reservation1.getTicketList()) {
			System.out.println("	" + t);
		}

		// cancel reservation2
		System.out.println("-------------------- passenger cancel reservation2 -------------------------------");
		System.out.println("Before the Passenger cancel reservation2. Status: " + reservation2.getStatusDetail());
		reservationSystem.cancelReservation(p, reservation2.getReservationCode());
		System.out.println("After the Passenger cancel reservation2. Status: " + reservation2.getStatusDetail());
	}

	private static void agentConfirm_andCancel_Reservation() throws Exception {
		List<FlightInstance> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		System.out.println("Total flights from CID to CLT today: " + flightsFromCIDToCLTToday.size());

		// create two reservations
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Agent agent = new Agent(new Address(), "","",LocalDate.of(1989,2, 3),"");

		Reservation reservation3 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);
		Reservation reservation4 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);

		// agent confirm reservation3
		System.out.println("-------------------- agent confirm reservation3 -------------------------------");
		System.out.println("agentId: " + agent);
		System.out.println("Before the Agent confirm reservation3. Status: " + reservation3.getStatusDetail());
		reservationSystem.confirmReservation(agent, reservation3.getReservationCode());
		System.out.println("After the Agent confirm the reservation3. Status: " + reservation3.getStatusDetail());
		System.out.println("---- list tickets of the reservation3: ");
		for(Ticket t : reservation3.getTicketList()) {
			System.out.println("	" + t);
		}

		// agent cancel reservation4
		System.out.println("-------------------- agent cancel reservation4 -------------------------------");
		System.out.println("agentId: " + agent);
		System.out.println("Before the Agent cancel reservation4. Status: " + reservation4.getStatusDetail());
		reservationSystem.cancelReservation(agent, reservation4.getReservationCode());
		System.out.println("After the Agent cancel reservation4. Status: " + reservation4.getStatusDetail());
	}

	private static void agentGetPassengerAndReservation() throws Exception {

		System.out.println("-------------------- agent views reservation -------------------------------");
		List<FlightInstance> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		Passenger p = new Passenger(new Address(), "John", "Dan", LocalDate.of(1990, 12, 1) , "JohnDan@gmail.com");
		Passenger p2 = reservationSystemRepository.findPassengerById("a1790c85-8c90-4360-a3c5-c2577ad904d7");
		Agent agent = reservationSystemRepository.findAgentById("a1790c85-8c90-4360-a3c5-c2577ad904d7");
		
		System.out.println("agent: "+agent.toString());

		Reservation reservation3 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);
		Reservation reservation4 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);

		reservationSystem.viewReservationDetails("a1790c85-8c90-4360-a3c5-c2577ad904d7", reservation3.getReservationCode());
		reservationSystem.viewReservationDetails("a1790c85-8c90-4360-a3c5-c2577ad904d7", reservation4.getReservationCode());
	}

	
	private static void searchForFlights() {
		String departure = "CID";
		String arrival = "CLT";
		LocalDate date = LocalDate.of(2021, 01, 20);
		System.out.println("-------------------- Search for flights  -------------------------------");
		System.out.println("from '"+departure+"' to '"+arrival+"'");
		System.out.println("Date '"+date.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))+"'");

		
		System.out.println(reservationSystem.findFlightsFromTo(departure, arrival, date).toString());
	}
	
	private static void findReservationsByPassengerId() {
		System.out.println("-------------------- find Reservations By PassengerId -------------------------------");
		Integer passengerId = 4;
		Passenger p = reservationSystemRepository.findPassengerById("a1790c85-8c90-4360-a3c5-c2577ad904d7");
		List<FlightInstance> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());

		Reservation reservation3 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		Reservation reservation4 = reservationSystem.createReservation(p, flightsFromCIDToCLTToday);
		List<Reservation> reservationList = reservationSystem.findReservationsByPassengerId(p.getId());
		System.out.println("---- list reservations of the person with id: "+passengerId);
		for(Reservation r : reservationList) {
			System.out.println("	" + r);
		}
		
		findReservationsDetails(reservationList.get(0).getReservationCode(), reservationList);
		
	}

	private static void findReservationsDetails(String code, List<Reservation> reservations) {
		System.out.println("-------------------- find Reservation '"+code+"' Details -------------------------------");
		Reservation reservation = reservations.stream()
				.filter(r-> r.getReservationCode().equalsIgnoreCase(code))
				.findFirst().get();
		System.out.println(reservation.toString());
	}
	
	private static void agentFindPassengerAndReservation() throws Exception {

		System.out.println("----------------agent views passengers and reservations---------------------------");
		List<FlightInstance> flightsFromCIDToCLTToday = reservationSystemRepository.findFlightsFromTo("CID", "CLT", LocalDate.now());
		Passenger p = reservationSystemRepository.findPassengerById("a1790c85-8c90-4360-a3c5-c2577ad904d7");
		Passenger p2 = reservationSystemRepository.findPassengerById("a1790c85-8c90-4360-a3c5-c2577ad904d7");
		Agent agent = reservationSystemRepository.findAgentById("a1790c85-8c90-4360-a3c5-c2577ad904d7");

		Reservation reservation3 = reservationSystem.createReservation(agent, p, flightsFromCIDToCLTToday);
		Reservation reservation4 = reservationSystem.createReservation(agent, p2, flightsFromCIDToCLTToday);

		HashMap<Passenger, List<Reservation>> hash = reservationSystem.findReservationsByAgentCode("a1790c85-8c90-4360-a3c5-c2577ad904d7");
		for (Passenger pass : hash.keySet()){
			System.out.println(pass.getId());
			List<Reservation> rList = hash.get(pass);
			String s = "";
			for (int i = 0; i < rList.size(); i++){
				s+= rList.get(i).getReservationCode()+ ", ";
			}
			System.out.println(s);
		}

		//reservationSystem.viewReservationDetails(11, reservation4.getReservationCode());
	}

	
	
	

}