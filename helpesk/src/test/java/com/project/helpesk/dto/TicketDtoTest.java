package com.project.helpesk.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.helpesk.entities.Category;
import com.project.helpesk.entities.Subcategory;
import com.project.helpesk.entities.Ticket;

@RunWith(SpringRunner.class)
class TicketDtoTest {

	@Test
	public void TicketDtoTest1() {
		
		int ticketId = 1;
		String description = "work from home ";
		String status ="pending";
		String priority = "high";
		LocalDate addedDate = LocalDate.of(2022, 9, 7);
		String assigned = "admin";
		String name ="prakriti";
		String category ="wfh";
		String subCategory ="wfh";
		int eid = 3;
		
		
	      TicketDto ticketDto = new TicketDto();
		ticketDto.setTicketId(ticketId);
		ticketDto.setDescription(description);
		ticketDto.setStatus(status);
		ticketDto.setPriority(priority);
		ticketDto.setAddedDate(addedDate);
		ticketDto.setAssigned(assigned);
		ticketDto.setName(name);
		ticketDto.setCategory(subCategory);
		ticketDto.setSubCategory(subCategory);
		ticketDto.setEid(eid);
		
		
		assertEquals(ticketId, ticketDto.getTicketId());
		assertEquals(description,ticketDto.getDescription());
		assertEquals(status,ticketDto.getStatus());
		assertEquals(priority,ticketDto.getPriority());
		assertEquals(addedDate,ticketDto.getAddedDate());
		assertEquals(assigned,ticketDto.getAssigned());
		assertEquals(name,ticketDto.getName());
		assertEquals(subCategory,ticketDto.getSubCategory());
		assertEquals(category,ticketDto.getCategory());
		assertEquals(eid,ticketDto.getEid());

		
		
		
	}
	@Test
	   public void testGettersAndSetters() {
	    Ticket ticket =new Ticket();
	    assertNull(ticket.getName());
	    String name = "prakriti";
	    ticket.setName(name);;
	    assertEquals(name, ticket.getName());
	    
	    assertNull(ticket.getDescription());
	    String description = "work from home";
	    ticket.setDescription(description);;
	    assertEquals(description, ticket.getDescription());
	    
	    assertNull(ticket.getStatus());
	    String status = "pending";
	    ticket.setStatus(status);;
	    assertEquals(status, ticket.getStatus());

	    assertNull(ticket.getPriority());
	    String priority = "high";
	    ticket.setPriority(priority);;
	    assertEquals(priority, ticket.getPriority());
	   }

}

