package mk.ukim.finki.emt.concertticketcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.concertticketcatalog.domain.models.ConcertTicketId;
import mk.ukim.finki.emt.concertticketcatalog.services.ConcertTicketService;
import mk.ukim.finki.emt.sharedkernel.domen.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domen.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domen.events.orders.OrderTicketCreated;
import mk.ukim.finki.emt.sharedkernel.domen.events.orders.OrderTicketRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConcertTicketEventListener {
    private final ConcertTicketService concertTicketService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_TICKET_CREATED, groupId = "concertCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderTicketCreated event = DomainEvent.fromJson(jsonMessage, OrderTicketCreated.class);
            concertTicketService.orderTicketCreated(ConcertTicketId.of(event.getConcertTicketId()), event.getQuantity());
        } catch (Exception e) {

        }

    }

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_TICKET_REMOVED, groupId = "concertCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            OrderTicketRemoved event = DomainEvent.fromJson(jsonMessage, OrderTicketRemoved.class);
            concertTicketService.orderTicketRemoved(ConcertTicketId.of(event.getConcertTicketId()), event.getQuantity());
        } catch (Exception e) {

        }
    }

}
