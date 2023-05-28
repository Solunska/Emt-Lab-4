package mk.ukim.finki.emt.concertticketcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.concertticketcatalog.domain.models.ConcertTicket;
import mk.ukim.finki.emt.concertticketcatalog.services.ConcertTicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/concertticket")
public class ConcertTicketResource {
    private final ConcertTicketService concertTicketService;

    @GetMapping
    public List<ConcertTicket> getAll(){
        return concertTicketService.getAll();
    }
}
