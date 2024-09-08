package in.adarshit.response;

import lombok.Data;

@Data
public class Ticket {

	private String name;
	private String from;
	private String to;
	private String doj;
	private String trainNumber;
	private Integer ticketNumber;
	private String status;
	private Double cost;
}
