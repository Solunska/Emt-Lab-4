package mk.ukim.finki.emt.concertticketcatalog.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.concertticketcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domen.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domen.financial.Money;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "concert_ticket")
@Getter
public class ConcertTicket extends AbstractEntity<ConcertTicketId> {
    private String concertName;
    private int sales = 0;
    private String artist;
    private String venue;
    private String ticketType;
    private int seatNumber;
    private LocalDate date;
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency")),
    })
    private Money price;

    public ConcertTicket() {
        super(ConcertTicketId.randomId(ConcertTicketId.class));
    }

    public static ConcertTicket build(String concertName,
                                      String artist,
                                      String venue,
                                      String ticketType,
                                      int seatNumber,
                                      LocalDate date,
                                      Money price,
                                      int sales) {
        ConcertTicket c = new ConcertTicket();
        c.price = price;
        c.concertName = concertName;
        c.sales = sales;
        c.artist = artist;
        c.venue = venue;
        c.ticketType = ticketType;
        c.seatNumber = seatNumber;
        c.date = date;
        return c;
    }

    public void addSales(int quantity) {
        this.sales = this.sales - quantity;
    }

    public void removeSales(int quantity) {
        this.sales -= quantity;
    }
}
