package edu.miu.cs.cs401.project.domain;

import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;

public class Reservation {
	
	public static final int CONFIRMED_PURCHASED = 2;
    public static final int CREATED = 1;
    public static final int CANCEL = 0;
	
	private String id;
	private String agentId;
	private String reservationCode;
	private List<Ticket> ticketList;
	private List<FlightInstance> flightInstance;
	private int status;
	
	 public Reservation(List<FlightInstance> flightInstance) {
			this.id = UUID.randomUUID().toString();
	        this.agentId = "0";
	        this.ticketList = new ArrayList<>();
	        this.setReservationCode(generateCode());
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
	
	
	public String getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusDetail() {
		if(status == CANCEL) {
			return "CANCELED";
		}
		else if(status == CREATED) {
			return "CREATED";
		}
		else {
			return "CONFIRMED_AND_PURCHASED";
		}
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
	
	private String generateCode() {
		int length = 6;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length,useLetters,useNumbers);
		
		return generatedString.toUpperCase();
	}
	
	private void confirmAndPurchase() throws Exception {
		if(status == CANCEL) {
			throw new Exception("The reservation is already canceled");
		}
		else if(status == CONFIRMED_PURCHASED) {
			throw new Exception("The reservation is already confirmed and purchased");
		}
		Ticket ticket;
		for(FlightInstance f:flightInstance) {
			ticket = new Ticket(getReservationCode(),f);
			ticketList.add(ticket);
		}
		status = CONFIRMED_PURCHASED;
	}
}
