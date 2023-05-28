package mk.ukim.finki.emt.ordermanagement.service.forms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.ConcertTicket;

@Data
public class OrderTicketForm {

    @NotNull
    private ConcertTicket concertTicket;

    @Min(1)
    private int quantity = 1;
}
