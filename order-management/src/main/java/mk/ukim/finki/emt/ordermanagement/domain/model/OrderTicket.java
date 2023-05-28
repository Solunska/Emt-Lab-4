package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.ConcertTicketId;
import mk.ukim.finki.emt.sharedkernel.domen.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domen.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domen.financial.Money;

@Entity
@Table(name = "order_ticket")
@Getter
public class OrderTicket extends AbstractEntity<OrderTicketId> {
    private Money ticketPrice;
    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id", column = @Column(name = "concert_ticket_id", nullable = false))
    private ConcertTicketId concertTicketId;

    public OrderTicket(){
        super(DomainObjectId.randomId(OrderTicketId.class));
    }

    public OrderTicket(@NonNull ConcertTicketId concertTicketId, @NonNull Money ticketPrice, int quantity) {
        this.concertTicketId = concertTicketId;
        this.ticketPrice = ticketPrice;
        this.quantity = quantity;
    }

    public Money subtotal() {
        return ticketPrice.multiply(quantity);
    }
}
