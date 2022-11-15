package com.project.helpesk.controllers;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.helpesk.dto.ApiResponse;
import com.project.helpesk.dto.TicketDto;

import com.project.helpesk.entities.Ticket;
import com.project.helpesk.repositories.TicketRepo;
import com.project.helpesk.services.TicketService;

/**
 * @author opera_ao6omsd.
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/")
public final class TicketController {

    /**
     * ticketService.
     */
    @Autowired
    private TicketService ticketService;

    /**
     * TicketRepo.
     */
    @Autowired
    private TicketRepo ticketRepo;

    // create

    /**
     * @param ticketDto ticket dto.
     * @return create ticket.
     */
    @PostMapping("/ticket")
    public ResponseEntity<TicketDto> createTicket(@RequestBody final TicketDto ticketDto) {

        TicketDto createTicket = this.ticketService.createTicket(ticketDto);
        return new ResponseEntity<TicketDto>(createTicket, HttpStatus.CREATED);
    }

    // delete ticket

    /**
     * @param ticketId ticket id.
     * @return delete ticket.
     */
    @DeleteMapping("ticket/{ticketId}")
    public ApiResponse deleteTicket(@PathVariable final Integer ticketId) {

        this.ticketService.deleteTicket(ticketId);
        return new ApiResponse("Ticket is successfully deleted !!", true);
    }

    /**
     * @param ticketDto ticket dto.
     * @param tid       tid.
     * @return update ticket with there id.
     */

    // update ticket
    /**
     * @param ticketDto ticket dto.
     * @return update ticket.
     */
    @PutMapping("ticket/update")
    public ResponseEntity<TicketDto> updateTicket(@RequestBody final TicketDto ticketDto) {

        TicketDto updateTicket = this.ticketService.updateTicket(ticketDto);
        return new ResponseEntity<TicketDto>(updateTicket, HttpStatus.OK);
    }

    // get all tickets

    /**
     * @return get all tickets.
     */
    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDto>> getAllTicket() {
        List<TicketDto> allTicket = this.ticketService.getAllTicket();
        return new ResponseEntity<List<TicketDto>>(allTicket, HttpStatus.OK);
    }

    // get ticket details by id
    /**
     * @param ticketId ticket id.
     * @return get ticket details by id.
     */
    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<List<TicketDto>> getTicketById(@PathVariable final Integer ticketId) {
        List<TicketDto> ticketDto = this.ticketService.getTicketById(ticketId);
        return new ResponseEntity<List<TicketDto>>(ticketDto, HttpStatus.OK);
    }

    /**
     * @return close status ticket.
     */
    @GetMapping("/tickets/status/close")
    public List<Ticket> getTicketByStatusClose() {
        List<Ticket> ticket = ticketRepo.findByStatusClose("close");
        return ticket;
    }

    /**
     * @return close status ticket.
     */
    @GetMapping("/tickets/status/inprogress")
    public List<Ticket> getTicketByStatusinProgress() {
        List<Ticket> ticket = ticketRepo.findByStatusinProgress("inProgress");
        return ticket;
    }


    /**
     * @return ticket.
     */
    @GetMapping("/tickets/status/open")
    public List<Ticket> getTicketByStatusOpen() {
        List<Ticket> ticket = ticketRepo.findByStatusOpen("open");
        return ticket;
    }

    /**
     * @return moderate priority Ticket.
     */
    @GetMapping("/tickets/priority/moderate")
    public List<Ticket> getTicketByPriorityModerate() {
        List<Ticket> ticket = ticketRepo.findByPriorityModerate("moderate");
        return ticket;
    }

    /**
     * @return high priority ticket.
     */
    @GetMapping("/tickets/priority/high")
    public List<Ticket> getTicketByPriorityHigh() {
        List<Ticket> ticket = ticketRepo.findByPriorityHigh("high");
        return ticket;
    }

    /**
     * @return low ticket priority.
     */
    @GetMapping("/tickets/priority/low")
    public List<Ticket> getTicketByPriorityLow() {
        List<Ticket> ticket = ticketRepo.findByPriorityLow("Low");
        return ticket;
    }

//    /**
//     * @param id id.
//     * @return reopen.
//     */
//    @GetMapping("/reopen/{id}")
//    public ResponseEntity<String> reOpenTicket(final @PathVariable("id") Integer id) {
//        ticketService.reOpenTicket(id);
//        return ResponseEntity.ok("Ticket Re-opened");
//    }

}
