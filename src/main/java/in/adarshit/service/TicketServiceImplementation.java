package in.adarshit.service;

import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import in.adarshit.request.Passenger;
import in.adarshit.response.Ticket;

@Service
public class TicketServiceImplementation implements TicketService {

	public String BOOK_TICKET_URL = "http://localhost:9095/book";

	public String GET_TICKET_URL = "http://localhost:9095/get-ticket/{ticketNumber}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.post().uri(BOOK_TICKET_URL)
		                 .bodyValue(passenger)
		                 .retrieve()
		                 .bodyToMono(Ticket.class)
		                 .block();
		return ticket;

	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {

		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.get().uri(GET_TICKET_URL, ticketNumber)
						.retrieve()
						.bodyToMono(Ticket.class)
						.block();
		return ticket;
	}

}
