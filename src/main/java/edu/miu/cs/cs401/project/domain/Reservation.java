package edu.miu.cs.cs401.project.domain;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Reservation {
	private String id;
	private String agentId;
	private List<Ticket> ticketList;
	private List<FlightInstance> flightInstance;
	
	 public Reservation(List<FlightInstance> flightInstance) {
			this.id = UUID.randomUUID().toString();
	        this.agentId = "";
	        this.ticketList = new ArrayList<>();
	        this.flightInstance = flightInstance;
	    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public List<FlightInstance> getFlightInstance() {
		return flightInstance;
	}

	public void setFlightInstance(List<FlightInstance> flightInstance) {
		this.flightInstance = flightInstance;
	}
	
	@Override
	public String toString(){

        String result ="";
        
        for (int i = 0; i < this.flightInstance.size(); i++){
            String flightCount = Integer.toString(i+1);
            result+= flightCount+ "- ";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            String departureDate = this.flightInstance.get(i).getDepartureDate().format(formatter);
            String arrivalDate = this.flightInstance.get(i).getArrivalDate().format(formatter);
            result+= "Departure date- "+ departureDate+ " Arrival date- "+ arrivalDate;

            String flightNumber = this.flightInstance.get(i).getFlightNumber().getNumber();
            result+= ", Flight number- "+ flightNumber;
            result+= "\n";
        }

        return result;

    }
}
