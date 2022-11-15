package com.project.helpesk.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class TicketTest {

    int ticketId =1;
    String description = "abc";
    String status = "open";
    String priority = "high";
    LocalDate addedDate = LocalDate.of(2020, 1, 8);
    String category = "xyz";
    String subCategory = "hardware problem";
    int eid = 1;
    String assigned = "sakshi";
    String name = "kunal";
    
    @Test
    public void testGetterSetter() {
    Ticket ticket= new Ticket( ticketId, description, status, priority,
             addedDate,  category,  subCategory,  eid,
            assigned);
    
    ticket.setTicketId(ticketId);
    ticket.setDescription(description);
    ticket.setStatus(status);
    ticket.setPriority(priority);
    ticket.setAddedDate(addedDate);
    ticket.setCategory(category);
    ticket.setSubCategory(subCategory);
    ticket.setEid(eid);
    ticket.setAssigned(assigned);
    ticket.setName(name);
    assertEquals(1, ticket.getTicketId());
    assertEquals(description, ticket.getDescription());
    assertEquals(status, ticket.getStatus());
    assertEquals(priority, ticket.getPriority());
    assertEquals(addedDate, ticket.getAddedDate());
    assertEquals(category, ticket.getCategory());
    assertEquals(subCategory, ticket.getSubCategory());
    assertEquals(eid, ticket.getEid());
    assertEquals(assigned, ticket.getAssigned());
    assertEquals(name, ticket.getName());
    }
}
