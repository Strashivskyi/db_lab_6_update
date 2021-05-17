package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Ticket;
import ua.lviv.iot.dto.RegionDto;
import ua.lviv.iot.dto.TicketDto;
import ua.lviv.iot.service.TicketService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/ticket")
@RestController
public class TicketController {
  private final TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<TicketDto>> getAll() {
    List<Ticket> cities = ticketService.getAll();
    List<TicketDto> ticketDtos = new ArrayList<>();
    for (Ticket ticket : cities) {
      TicketDto ticketDto = new TicketDto(
          ticket.getId(),
          ticket.getArrivalTime(),
          ticket.getDepartureTime(),
          ticket.getPeopleNumber(),
          ticket.getKidsNumber(),
          ticket.getPriceInUSD(),
          ticket.getPaymentTime(),
          ticket.getAmusementParkId(),
          ticket.getClientId()
      );
      ticketDtos.add(ticketDto);
    }
    return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<TicketDto> getById(@PathVariable Integer id) {
    Ticket ticket = ticketService.getById(id);
    try {
      if (ticketService.getById(id) != null && ticketService.getById(id).getArrivalTime() != null) {
        TicketDto ticketDto = new TicketDto(
            ticket.getId(),
            ticket.getArrivalTime(),
            ticket.getDepartureTime(),
            ticket.getPeopleNumber(),
            ticket.getKidsNumber(),
            ticket.getPriceInUSD(),
            ticket.getPaymentTime(),
            ticket.getAmusementParkId(),
            ticket.getClientId()
        );
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<TicketDto> create(@RequestBody Ticket ticket) {
    ticketService.create(ticket);
    TicketDto ticketDto = new TicketDto(
        ticket.getId(),
        ticket.getArrivalTime(),
        ticket.getDepartureTime(),
        ticket.getPeopleNumber(),
        ticket.getKidsNumber(),
        ticket.getPriceInUSD(),
        ticket.getPaymentTime(),
        ticket.getAmusementParkId(),
        ticket.getClientId()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(ticketDto);
  }
  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<TicketDto> update(@PathVariable Integer id,
                                        @RequestBody Ticket ticket) {
    try {
      ticket.setId(id);
      Ticket oldTicket = ticketService.getById(id);
      if (oldTicket != null && oldTicket.getArrivalTime() != null) {
        ticketService.update(id, ticket);
        TicketDto newTicketDto = new TicketDto(
            ticket.getId(),
            ticket.getArrivalTime(),
            ticket.getDepartureTime(),
            ticket.getPeopleNumber(),
            ticket.getKidsNumber(),
            ticket.getPriceInUSD(),
            ticket.getPaymentTime(),
            ticket.getAmusementParkId(),
            ticket.getClientId()
        );
        return new ResponseEntity<>(newTicketDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    try {
      if (ticketService.getById(id) != null && ticketService.getById(id).getArrivalTime() != null) {
        ticketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  }



