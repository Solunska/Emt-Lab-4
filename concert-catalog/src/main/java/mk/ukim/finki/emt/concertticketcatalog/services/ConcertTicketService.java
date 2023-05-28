package mk.ukim.finki.emt.concertticketcatalog.services;

import mk.ukim.finki.emt.concertticketcatalog.domain.models.ConcertTicket;
import mk.ukim.finki.emt.concertticketcatalog.domain.models.ConcertTicketId;
import mk.ukim.finki.emt.concertticketcatalog.services.form.ConcertTicketForm;

import java.util.List;

public interface ConcertTicketService {
    ConcertTicket findById(ConcertTicketId id);

    ConcertTicket createConcertTicket(ConcertTicketForm form);

    ConcertTicket orderTicketCreated(ConcertTicketId concertTicketId, int quantity);

    ConcertTicket orderTicketRemoved(ConcertTicketId concertTicketId, int quantity);

    List<ConcertTicket> getAll();

}
