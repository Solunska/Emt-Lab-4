package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domen.base.DomainObjectId;

@Embeddable
public class ConcertTicketId extends DomainObjectId {

    public ConcertTicketId() {
        super(ConcertTicketId.randomId(ConcertTicketId.class).getId());
    }

    public ConcertTicketId(String uuid) {
        super(uuid);
    }

}
