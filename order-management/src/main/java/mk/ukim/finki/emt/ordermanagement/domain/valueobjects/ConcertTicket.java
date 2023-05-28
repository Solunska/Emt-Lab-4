package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domen.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domen.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domen.financial.Money;

import java.time.LocalDate;

@Getter
public class ConcertTicket implements ValueObject {

    private final ConcertTicketId id;
    private final String name;
    private final String artist;
    private final String venue;
    private final String ticketType;
    private final int seatNumber;
    private final LocalDate date;
    private final Money price;
    private final int sales;

    private ConcertTicket() {
        this.id = ConcertTicketId.randomId(ConcertTicketId.class);
        this.name = "";
        this.artist = "";
        this.venue = "";
        this.ticketType = "";
        this.seatNumber = 0;
        this.date = LocalDate.now();
        this.price = Money.valueOf(Currency.MKD, 0);
        this.sales = 0;
    }


    @JsonCreator
    public ConcertTicket(@JsonProperty("id") ConcertTicketId id,
                         @JsonProperty("concertName") String name,
                         @JsonProperty("price") Money price,
                         @JsonProperty("artist") String artist,
                         @JsonProperty("venue") String venue,
                         @JsonProperty("ticketType") String ticketType,
                         @JsonProperty("seatNumber") int seatNumber,
                         @JsonProperty("date") LocalDate date,
                         @JsonProperty("sales") int sales) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.artist = artist;
        this.venue = venue;
        this.ticketType = ticketType;
        this.seatNumber = seatNumber;
        this.date = date;
    }

}
