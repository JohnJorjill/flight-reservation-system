package edu.miu.cs.cs401.project.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
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

	private List <Airport> airports = new ArrayList<>();
	private Map<String, Passenger> passengers = new HashMap<>();
	private Map<String, Airline> airlines= new HashMap<>();
    private List <FlightInstance> allFlight = new ArrayList<>();

    private Map<Integer, Pilot> pilots= new HashMap<>();
	private Map<Integer, Crew> crews= new HashMap<>();
	private Map<String, Agent> agents= new HashMap<>();

	public ReservationSystemRepositoryImpl() throws Exception {
		super();
		setupAirports();
        setupPassengers();
        setupAgents();
    }
    
    private void setupAgents(){

        Address agent1 = new Address();
        Address agent2 = new Address();
        Address agent3 = new Address();

        Agent a1 = new Agent(agent1, "Agent", "One", LocalDate.of(1990, 12, 2) , "Agentone@gmail.com");
        Agent a2 = new Agent(agent2, "Agent", "Two", LocalDate.of(1990, 12, 6) , "Agenttwo@gmail.com");
        Agent a3 = new Agent(agent3, "Agent", "Three", LocalDate.of(1990, 12, 9) , "Agentthree@gmail.com");

        this.agents.put(a1.getId(), a1);
        this.agents.put(a2.getId(), a2);
        this.agents.put(a3.getId(), a3);

    }
	

	private void setupPassengers() {
		Address personAdd1 = new Address();
        Address personAdd2 = new Address();
        Address personAdd3 = new Address();
        Address personAdd4 = new Address();
        Address personAdd5 = new Address();
        Address personAdd6 = new Address();

        Passenger p1 = new Passenger(personAdd1, "John", "Dan", LocalDate.of(1991, 12, 1) , "JohnDan@gmail.com");
        Passenger p2 = new Passenger(personAdd1, "George", "Dan", LocalDate.of(1992, 12, 1) , "GeorgeDan@gmail.com");
        Passenger p3 = new Passenger(personAdd1, "Bya", "Dan", LocalDate.of(1993, 12, 1) , "ByaDan@gmail.com");
        Passenger p4 = new Passenger(personAdd2, "Dell", "Neil", LocalDate.of(1994, 12, 1) , "DellNeil@gmail.com");
        Passenger p5 = new Passenger(personAdd2, "Apply", "Neil", LocalDate.of(1995, 12, 1) , "ApplyNeil@gmail.com");
        Passenger p6 = new Passenger(personAdd2, "Grek", "Neil", LocalDate.of(1993, 12, 2) , "GrekNeil@gmail.com");
        Passenger p7 = new Passenger(personAdd3, "Nate", "Kris", LocalDate.of(1995, 11, 1) , "NateKris@gmail.com");
        Passenger p8 = new Passenger(personAdd4, "Nas", "Chris", LocalDate.of(1990, 10, 1) , "NasChris@gmail.com");
        Passenger p9 = new Passenger(personAdd5, "Haryy", "Potter", LocalDate.of(1995, 9, 1) , "HaryyPotter@gmail.com");
        Passenger p10 = new Passenger(personAdd6, "Tom", "Cruise", LocalDate.of(1990, 2, 1) , "TomCruise@gmail.com");

		this.passengers.put(p1.getId(), p1);
		this.passengers.put(p2.getId(), p2);
		this.passengers.put(p3.getId(), p3);
		this.passengers.put(p4.getId(), p4);
		this.passengers.put(p5.getId(), p5);
		this.passengers.put(p6.getId(), p6);
		this.passengers.put(p7.getId(), p7);
		this.passengers.put(p8.getId(), p8);
		this.passengers.put(p9.getId(), p9);
		this.passengers.put(p10.getId(), p10);
		
	}

	private void setupAirports() throws Exception {
		
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
		

		Airline al1 = new Airline("AL", "Airline1", "The best airline since 1940");
        Airline al2 = new Airline("AI", "Airline2", "The nicest airline since 1965");
        Airline al3 = new Airline("AN", "Airline3", "The coolest airline since 1998");

		airlines.put(al1.getCode(), al1);
		airlines.put(al2.getCode(), al2);
		airlines.put(al3.getCode(), al3);

		airport1.addArrivalAirline(al1);
		airport1.addArrivalAirline(al2);
        airport1.addArrivalAirline(al3);
        airport1.addDepartureAirline(al1);
		airport1.addDepartureAirline(al2);
        airport1.addDepartureAirline(al3);
        
        airport2.addArrivalAirline(al1);
		airport2.addArrivalAirline(al2);
        airport2.addArrivalAirline(al3);
        airport2.addDepartureAirline(al1);
		airport2.addDepartureAirline(al2);
        airport2.addDepartureAirline(al3);
        
        airport3.addArrivalAirline(al1);
		airport3.addArrivalAirline(al2);
        airport3.addArrivalAirline(al3);
        airport3.addDepartureAirline(al1);
		airport3.addDepartureAirline(al2);
        airport3.addDepartureAirline(al3);
		
		airports.add(airport1);
		airports.add(airport2);
		airports.add(airport3);
		airports.add(airport4);
		airports.add(airport5);

		// airports.put(airport1.getCode(), airport1);
		// airportsByCity.put(airport1.getAddress().getCity(), airport1);

		// airports.put(airport2.getCode(), airport2);
		// airportsByCity.put(airport2.getAddress().getCity(), airport2);

		// airports.put(airport3.getCode(), airport3);
		// airportsByCity.put(airport3.getAddress().getCity(), airport3);


		// setup flights
		Flight fn1 = new Flight("fn1", 100, LocalTime.of(7, 20), LocalTime.of(8, 25), airport1, airport3);
		Flight fn2 = new Flight("fn2", 80, LocalTime.of(9, 45), LocalTime.of(12, 15), airport2, airport3);
		Flight fn3 = new Flight("fn3", 120, LocalTime.of(17, 10), LocalTime.of(22, 10), airport3, airport1);
		
		Flight fn4 = new Flight("fn4", 40, LocalTime.of(11, 30), LocalTime.of(13, 30), airport1, airport3);
		Flight fn5 = new Flight("fn5", 60, LocalTime.of(7, 50), LocalTime.of(11, 25), airport2, airport3);
		Flight fn6 = new Flight("fn6", 200, LocalTime.of(6, 15), LocalTime.of(9, 15), airport3, airport1);
		Flight fn7 = new Flight("fn7", 60, LocalTime.of(20, 25), LocalTime.of(23, 25), airport3, airport2);
		Flight fn8 = new Flight("fn8", 90, LocalTime.of(15, 15), LocalTime.of(18, 30), airport2, airport1);
		al1.addFlightNumber(fn1);
		al1.addFlightNumber(fn2);
		al1.addFlightNumber(fn3);

		al2.addFlightNumber(fn4);
		al2.addFlightNumber(fn5);
		
		al3.addFlightNumber(fn6);
		al3.addFlightNumber(fn7);
		al3.addFlightNumber(fn8);


        // create data for flights on specific date: 2020 Dec 02
		Pilot[] pilots = {
				new Pilot(new Address(), "John", "Al", LocalDate.of(1989, 3, 24), "john@gmail.com"),
				new Pilot(new Address(), "Dang", "Nguyen", LocalDate.of(1988, 8, 3), "dang@gmail.com")};
		Crew[] crews = {
				new Crew(new Address(), "Diana", "Al", LocalDate.of(1989, 3, 24), "john@gmail.com"),
				new Crew(new Address(), "Maria", "Nguyen", LocalDate.of(1988, 8, 3), "dang@gmail.com")};
        allFlight.add(new FlightInstance(fn1,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn2,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn3,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn4,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn5,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn6,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn7,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn8,LocalDate.of(2020, 12, 02), LocalDate.of(2020, 12, 02), Arrays.asList(crews), Arrays.asList(pilots)));

        // create data for flights for today
        allFlight.add(new FlightInstance(fn1,LocalDate.now(), LocalDate.now(), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn2,LocalDate.now(), LocalDate.now(), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn3,LocalDate.now(), LocalDate.now(), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn4,LocalDate.now(), LocalDate.now(), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn5,LocalDate.now(), LocalDate.now(), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn6,LocalDate.now(), LocalDate.now(), Arrays.asList(crews), Arrays.asList(pilots)));
        allFlight.add(new FlightInstance(fn7,LocalDate.now(), LocalDate.now(), Arrays.asList(crews), Arrays.asList(pilots)));

	}

	@Override
	public List<Airport> findAllAirports() {
		return this.airports;
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

	public String getSampleCity() {
		return airports.get(0).getAddress().getCity();
	}

	@Override
	public List<Airport> findAirportsByCity(String city) {
		return airports
				.stream()
				.filter( a->
					a.getAddress().getCity().equalsIgnoreCase(city)
				)
				.collect(Collectors.toList());
	}

	@Override
	public List<Airline> findAirlinesByAirportCode(String airportCode) {
		return findAirportByAirportCode(airportCode).getdepartureAirlines();
	}

	@Override
	public List<FlightInstance> findFlightsFromTo(String departure, String arrival, LocalDate date) {
		return  allFlight
				.stream()
				.filter( f->
					f.getFlightNumber().getDepartureAirport().getCode().equalsIgnoreCase(departure)
					&&
					f.getFlightNumber().getArrivalAirport().getCode().equalsIgnoreCase(arrival)
					&&
					f.getDepartureDate().equals(date)
				)
				.collect(Collectors.toList());
	}

	@Override
	public List<Reservation> findReservationsByPassengerId(String passengerId) {
		return  passengers.get(passengerId).getReservationList();
	}

	@Override
	public List<Passenger> findPassengersByAgentCode(int agentCode) {
		return agents.get(agentCode).getPassengerList();
	}

    @Override
    public Passenger findPassengerById(String id) {
        return passengers.get(id);
    }

	@Override
	public Agent findAgentById(String id) {
		return agents.get(id);
	}
}
