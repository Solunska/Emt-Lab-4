package mk.ukim.finki.emt.sharedkernel.domen.events.orders;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domen.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domen.events.DomainEvent;

@Getter
public class OrderTicketCreated extends DomainEvent {

    private String concertTicketId;
    private int quantity;

    public OrderTicketCreated(String topic) {
        super(TopicHolder.TOPIC_ORDER_TICKET_CREATED);
    }

    public OrderTicketCreated(String concertTicketId, int quantity) {
        super(TopicHolder.TOPIC_ORDER_TICKET_CREATED);
        this.concertTicketId = concertTicketId;
        this.quantity = quantity;
    }
}

