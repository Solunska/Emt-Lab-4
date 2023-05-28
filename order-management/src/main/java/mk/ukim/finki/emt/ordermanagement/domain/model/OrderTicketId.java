package mk.ukim.finki.emt.ordermanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domen.base.DomainObjectId;

public class OrderTicketId extends DomainObjectId {

    private OrderTicketId() {
        super(OrderTicketId.randomId(OrderTicketId.class).getId());
    }

    public OrderTicketId(String uuid) {
        super(uuid);
    }
}
