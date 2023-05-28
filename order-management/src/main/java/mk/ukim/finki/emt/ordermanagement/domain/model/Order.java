package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.ConcertTicket;
import mk.ukim.finki.emt.sharedkernel.domen.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domen.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domen.financial.Money;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {
    private Instant orderedOn;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_currency")
    private Currency currency;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderTicket> orderTicketList = new HashSet<>();

    public Order(){
        super(OrderId.randomId(OrderId.class));
    }
    public Order(Instant now, Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
        this.currency = currency;
    }

    public Money total() {
        return orderTicketList.stream().map(OrderTicket::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    public OrderTicket addItem(@NonNull ConcertTicket concertTicket, int quantity) {
        Objects.requireNonNull(concertTicket, "concert ticket must not be null");
        var ticket = new OrderTicket(concertTicket.getId(), concertTicket.getPrice(), quantity);
        orderTicketList.add(ticket);
        return ticket;
    }

    public void removeItem(@NonNull OrderTicketId orderTicketId) {
        Objects.requireNonNull(orderTicketId, "order ticket must not be null");
        orderTicketList.removeIf(v -> v.getId().equals(orderTicketId));
    }
}
