package mk.ukim.finki.emt.sharedkernel.infra;

import mk.ukim.finki.emt.sharedkernel.domen.events.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
