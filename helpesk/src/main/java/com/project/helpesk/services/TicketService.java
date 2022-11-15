package com.project.helpesk.services;

import java.util.List;

import javax.validation.Valid;

import com.project.helpesk.dto.TicketDto;

/**
 * @author opera_ao6omsd.
 *
 */
public interface TicketService {

    /**
     * @param ticketdto ticketdto.
     * @return createTicket.
     */
    TicketDto createTicket(final TicketDto ticketdto);

    /**
     * @param ticketDto ticketdto.
     * @return updateTicket.
     */
    TicketDto updateTicket(final TicketDto ticketDto);

    /**
     * @param ticketId delete by ticket id.
     */
    void deleteTicket(final Integer ticketId);

    /**
     * @return List of ticket dto or get all ticket.
     */
    List<TicketDto> getAllTicket();

    /**
     * @param ticketId get ticket by id.
     * @return TicketDto get single ticket.
     */
    List<TicketDto> getTicketById(final Integer ticketId);

    /**
     * @param ticketDto ticketdto.
     * @param tid       tid.
     * @return ticket which is update.
     */
    TicketDto updateticket(final @Valid TicketDto ticketDto, final Integer tid);

    /**
     * @param ticketId ticketId.
     */
    void reOpenTicket(final Integer ticketId);

}
