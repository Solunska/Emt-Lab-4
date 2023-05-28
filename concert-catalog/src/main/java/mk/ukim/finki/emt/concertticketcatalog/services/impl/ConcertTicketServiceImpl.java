package mk.ukim.finki.emt.concertticketcatalog.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.concertticketcatalog.domain.exceptions.ConcertTicketNotFoundException;
import mk.ukim.finki.emt.concertticketcatalog.domain.models.ConcertTicket;
import mk.ukim.finki.emt.concertticketcatalog.domain.models.ConcertTicketId;
import mk.ukim.finki.emt.concertticketcatalog.domain.repository.ConcertTicketRepository;
import mk.ukim.finki.emt.concertticketcatalog.services.ConcertTicketService;
import mk.ukim.finki.emt.concertticketcatalog.services.form.ConcertTicketForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ConcertTicketServiceImpl implements ConcertTicketService {
    private final ConcertTicketRepository concertTicketRepository;

    @Override
    public ConcertTicket findById(ConcertTicketId id) {
        return concertTicketRepository.findById(id).orElseThrow(ConcertTicketNotFoundException::new);
    }

    @Override
    public ConcertTicket createConcertTicket(ConcertTicketForm form) {
        ConcertTicket c = ConcertTicket.build(form.getConcertName(), form.getArtist(), form.getVenue(), form.getTicketType(), form.getSeatNumber(), form.getDate(), form.getPrice(), form.getSales());
        concertTicketRepository.save(c);
        return c;
    }

    @Override
    public ConcertTicket orderTicketCreated(ConcertTicketId concertTicketId, int quantity) {
        ConcertTicket c = concertTicketRepository.findById(concertTicketId).orElseThrow(ConcertTicketNotFoundException::new);
        c.addSales(quantity);
        concertTicketRepository.saveAndFlush(c);
        return c;
    }

    @Override
    public ConcertTicket orderTicketRemoved(ConcertTicketId concertTicketId, int quantity) {
        ConcertTicket c = concertTicketRepository.findById(concertTicketId).orElseThrow(ConcertTicketNotFoundException::new);
        c.removeSales(quantity);
        concertTicketRepository.saveAndFlush(c);
        return c;
    }

    @Override
    public List<ConcertTicket> getAll() {
        return concertTicketRepository.findAll();
    }
}
