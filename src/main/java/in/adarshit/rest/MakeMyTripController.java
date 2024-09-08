package in.adarshit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.adarshit.request.Passenger;
import in.adarshit.response.Ticket;
import in.adarshit.service.TicketService;

@Controller
public class MakeMyTripController {
	@Autowired
	private TicketService service;

	@GetMapping("/")
	public String loadIndexPage(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";
	}

	@PostMapping("/book")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger, Model model) {
		Ticket bookTicket = service.bookTicket(passenger);
		model.addAttribute("msg", "Ticket Booked with ticket Number : " + bookTicket.getTicketNumber());

		return "index";
	}

	@GetMapping("/load-get-ticket")
	public String loadGetTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "get-ticket";
	}

	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam("ticketNum") Integer ticketNumber, Model model) {
		Ticket ticket = service.getTicket(ticketNumber);
		model.addAttribute("ticket", ticket);
		return "get-ticket";
	}

}
