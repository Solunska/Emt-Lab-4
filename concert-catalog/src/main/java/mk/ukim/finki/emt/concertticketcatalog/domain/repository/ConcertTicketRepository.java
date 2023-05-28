package mk.ukim.finki.emt.concertticketcatalog.domain.repository;

import mk.ukim.finki.emt.concertticketcatalog.domain.models.ConcertTicket;
import mk.ukim.finki.emt.concertticketcatalog.domain.models.ConcertTicketId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertTicketRepository extends JpaRepository<ConcertTicket, ConcertTicketId> {
}
