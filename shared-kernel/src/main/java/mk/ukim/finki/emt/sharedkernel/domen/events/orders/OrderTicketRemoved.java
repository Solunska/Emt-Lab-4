package mk.ukim.finki.emt.sharedkernel.domen.events.orders;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domen.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domen.events.DomainEvent;

@Getter
public class OrderTicketRemoved extends DomainEvent {

    private String concertTicketId;
    private int quantity;

    public OrderTicketRemoved(String topic) {
        super(TopicHolder.TOPIC_ORDER_TICKET_REMOVED);
    }

    public OrderTicketRemoved(String topic, String concertTicketId, int quantity) {
        super(TopicHolder.TOPIC_ORDER_TICKET_REMOVED);
        this.concertTicketId = concertTicketId;
        this.quantity = quantity;
    }
}

