package com.project.helpesk.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpesk.dto.TicketDto;
//import com.project.helpesk.dto.UserDto;
//import com.project.helpesk.entities.Category;
import com.project.helpesk.entities.Ticket;

import com.project.helpesk.exceptions.ResourceNotFoundException;
import com.project.helpesk.exceptions.ValidationException;
//import com.project.helpesk.repositories.CategoryRepo;
import com.project.helpesk.repositories.TicketRepo;
//import com.project.helpesk.repositories.UserRepo;
import com.project.helpesk.services.TicketService;

/**
 * @author opera_ao6omsd
 *
 */
@Service
public final class TicketServiceImpl implements TicketService {

    /**
     * return the ticketrepo here.
     */
    @Autowired
    private TicketRepo ticketRepo;

    /**
     * model mapper.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * ticket dto.
     */
    @Override
    public TicketDto createTicket(final TicketDto ticketDto) {

        Ticket ticket = this.modelMapper.map(ticketDto, Ticket.class);
        ticket.setAddedDate(LocalDate.now());
        ticket.setPriority("Moderate");
        ticket.setStatus("Open");
        ticket.setAssigned("Jay Soni");

        Ticket newTicket = this.ticketRepo.save(ticket);

        return this.modelMapper.map(newTicket, TicketDto.class);
    }

    /**
     * update ticket.
     */
    @Override
    public TicketDto updateTicket(final TicketDto ticketDto) {

        Ticket ticket = ticketRepo.findById(ticketDto.getTicketId()).orElseThrow(RuntimeException::new);

        ticket.setStatus(ticketDto.getStatus());
        ticket.setPriority(ticketDto.getPriority());
        ticket.setAssigned(ticketDto.getAssigned());

        System.out.print(ticketDto.getAssigned());

        Ticket updateTicket = this.ticketRepo.save(ticket);
        return this.modelMapper.map(updateTicket, TicketDto.class);
    }

    /**
     * delete ticket.
     */
    @Override
    public void deleteTicket(final Integer ticketId) {
        Ticket ticket = this.ticketRepo.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "ticket id", ticketId));

        this.ticketRepo.delete(ticket);

    }

    /**
     * get all ticket.
     */
    @Override
    public List<TicketDto> getAllTicket() {
        List<Ticket> allTickets = this.ticketRepo.findAll();
        List<TicketDto> ticketDtos = allTickets.stream().map((ticket) -> this.modelMapper.map(ticket, TicketDto.class))
                .collect(Collectors.toList());
        return ticketDtos;
    }

    /**
     * get ticket by id.
     */
    @Override
    public List<TicketDto> getTicketById(final Integer ticketId) {
        List<Ticket> ticket = this.ticketRepo.findByEid(ticketId);

        List<TicketDto> ticketDtos = ticket.stream().map((tickets) -> this.modelMapper.map(tickets, TicketDto.class))
                .collect(Collectors.toList());
        return ticketDtos;
    }

    /**
     * update ticket.
     */
    @Override
    public TicketDto updateticket(final @Valid TicketDto ticketDto, final Integer tid) {
        Ticket ticket = this.ticketRepo.findById(tid)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", tid));
        ticket.setStatus(ticketDto.getStatus());
        ticket.setPriority(ticketDto.getPriority());
        ticket.setAssigned(ticketDto.getAssigned());
        ticket.setDescription(ticket.getDescription());
        Ticket updatedTicket = this.ticketRepo.save(ticket);
        TicketDto ticketDtol = this.ticketToDto(updatedTicket);
        return ticketDtol;
    }

    /**
     * @param ticketDto ticket dto.
     * @return ticket.
     */
    public Ticket dtoToTicket(final TicketDto ticketDto) {
        Ticket ticket = this.modelMapper.map(ticketDto, Ticket.class);

        return ticket;
    }

    /**
     * @param ticket ticket.
     * @return ticket.
     */
    public TicketDto ticketToDto(final Ticket ticket) {
        TicketDto ticketDto = this.modelMapper.map(ticket, TicketDto.class);

        return ticketDto;
    }

    /**
     * reOpen ticket.
     */
    /**
     * ticketId.
     */
    @Override
    public void reOpenTicket(final Integer ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(() -> new ValidationException("Ticket not found"));
        ticket.setStatus("OPEN");
        ticketRepo.save(ticket);
    }
}
