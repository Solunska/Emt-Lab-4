package mk.ukim.finki.emt.concertticketcatalog.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domen.base.ValueObject;

@Embeddable
@Getter
public class Quantity implements ValueObject {
    private final int quantity;

    protected Quantity() {
        this.quantity = 0;
    }
}
