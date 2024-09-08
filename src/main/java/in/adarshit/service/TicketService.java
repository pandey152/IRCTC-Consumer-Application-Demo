package in.adarshit.service;

import in.adarshit.request.Passenger;
import in.adarshit.response.Ticket;

public interface TicketService {

	public Ticket bookTicket(Passenger passenger);

	public Ticket getTicket(Integer ticketNumber);

}
