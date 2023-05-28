package mk.ukim.finki.emt.concertticketcatalog.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.concertticketcatalog.domain.models.ConcertTicket;
import mk.ukim.finki.emt.concertticketcatalog.domain.repository.ConcertTicketRepository;
import mk.ukim.finki.emt.sharedkernel.domen.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domen.financial.Money;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@AllArgsConstructor

public class DataInitializer {
    private final ConcertTicketRepository concertTicketRepository;

    @PostConstruct
    public void initData() {
        ConcertTicket c1 = ConcertTicket.build("Concert 1", "Artist 1", "Venue 1", "TicketType 1", 1, LocalDate.now(), Money.valueOf(Currency.MKD, 500), 10);
        ConcertTicket c2 = ConcertTicket.build("Concert 2", "Artist 2", "Venue 2", "TicketType 2", 2, LocalDate.now(), Money.valueOf(Currency.MKD, 500), 10);
        if (concertTicketRepository.findAll().isEmpty()) {
            concertTicketRepository.saveAll(Arrays.asList(c1, c2));
        }
    }
}

