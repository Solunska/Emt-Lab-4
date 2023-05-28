package mk.ukim.finki.emt.concertticketcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domen.financial.Money;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ConcertTicketForm {
    private String concertName;
    private String artist;
    private String venue;
    private String ticketType;
    private int seatNumber;
    private LocalDate date;
    private Money price;
    private int sales;


}
