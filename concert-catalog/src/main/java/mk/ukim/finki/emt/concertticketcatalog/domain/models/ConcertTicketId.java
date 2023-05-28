package mk.ukim.finki.emt.concertticketcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domen.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class ConcertTicketId extends DomainObjectId {

    private ConcertTicketId() {
        super(ConcertTicketId.randomId(ConcertTicketId.class).getId());
    }

    public ConcertTicketId(@NonNull String uuid) {
        super(uuid);
    }

    public static ConcertTicketId of(String uuid) {
        ConcertTicketId ct = new ConcertTicketId(uuid);
        return ct;
    }


}
