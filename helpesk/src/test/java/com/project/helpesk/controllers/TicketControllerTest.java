//package com.project.helpesk.controllers;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.helpesk.dto.TicketDto;
//import com.project.helpesk.services.TicketService;
//@ExtendWith(MockitoExtension.class)
//class TicketControllerTest {
//    @Mock
//    private TicketService ticketService;
//    @Autowired
//    private MockMvc mockMvc;
//    @InjectMocks
//    TicketController ticketController;
//    @BeforeEach
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();
//    }
//    @Test
//    public void createTickettest() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        int ticketId = 1;
//        String description = "description";
//        String status = "Status";
//        String priority = "priority";
//        LocalDate addedDate =  LocalDate.of(2020, 1, 8);;
//        String subCategory = "subCategory";
//        String category = "category";
//        int eid = 1;
//        String assigned = "assignTo";
//        String name = "name";
//
//        TicketDto ticketDto1 = buildTicketDto1( ticketId,   description,   status,   priority, addedDate,   category,   subCategory,   eid,
//                  assigned, name);
//        TicketDto ticketDto2 = new TicketDto();
//        ticketDto2.setAssigned(assigned);
//        ticketDto2.setStatus(status);
//        ticketDto2.setPriority(priority);
//        ticketDto2.setEid(eid);
//        ticketDto2.setTicketId(ticketId);
//        ticketDto2.setName(name);
//        ticketDto2.setCategory(category);
//        ticketDto2.setSubCategory(subCategory);
//        ticketDto2.setAddedDate(addedDate);
//        ticketDto2.setDescription(description);
//        Mockito.when(ticketService.createTicket(ticketDto1)).thenReturn(ticketDto1);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String inputJSON = objectMapper.writeValueAsString(ticketDto1);
//        MvcResult mvcResult = this.mockMvc
//                .perform(post("/api/ticket").contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
//        int status1 = mvcResult.getResponse().getStatus();
//        assertEquals(200, status1);
//    }
//    private TicketDto buildTicketDto1(int ticketId, String subCategory, String priority, String category,
//            LocalDate addedDate, String status,
//            String assignTo, int eid, String name, String description) {
//        TicketDto ticketdto = new TicketDto();
//        ticketdto.setTicketId(ticketId);
//        ticketdto.setSubCategory(subCategory);
//        ticketdto.setPriority(priority);
//        ticketdto.setCategory(category);
//        ticketdto.setDescription(description);
//        ticketdto.setAddedDate(addedDate);
//        ticketdto.setEid(eid);
//        ticketdto.setName(name);
//        ticketdto.setStatus(status);
//        ticketdto.setAssigned(assignTo);
//        return ticketdto;
//    }
//    @Test
//    public void updateTickettest() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        
//        int ticketId = 1;
//        String description = "description";
//        String status = "Status";
//        String priority = "priority";
//        LocalDate addedDate =  LocalDate.of(2020, 1, 8);;
//        String subCategory = "subCategory";
//        String category = "category";
//        int eid = 1;
//        String assigned = "assignTo";
//        String name = "name";
//        
//     
//        TicketDto ticketDto1 = buildTicketDto1(ticketId, eid, subCategory, priority, category, description,
//                addedDate, status, assigned , name);
//        TicketDto ticketDto2 = new TicketDto();
//        ticketDto2.setTicketId(1);
//        ticketDto2.setSubCategory("subCategory");
//        ticketDto2.setPriority("priority");
//        ticketDto2.setCategory("category");
//        ticketDto2.setDescription("description");
//        ticketDto2.setAddedDate(addedDate);
//        ticketDto2.setEid(1);
//        ticketDto2.setName("name");
//        ticketDto2.setStatus("status");
//        ticketDto2.setAssigned("assignTo");
//
//        Mockito.when(ticketService.updateTicket(ticketDto1)).thenReturn(ticketDto2);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String inputJSON = objectMapper.writeValueAsString(ticketDto1);
//        MvcResult mvcResult = this.mockMvc
//                .perform(put("/tickets/update").contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
//        int status1 = mvcResult.getResponse().getStatus();
//        assertEquals(200, status1);
//    }
//    private TicketDto buildTicketDto(int ticketId, String subCategory, String priority, String category,
//            String description, LocalDate addedDate,  String status, String assigned, int eid, String name) {
//        TicketDto ticketdto = new TicketDto();
//        ticketdto.setTicketId(ticketId);
//        ticketdto.setSubCategory(subCategory);
//        ticketdto.setPriority(priority);
//        ticketdto.setCategory(category);
//        ticketdto.setDescription(description);
//        ticketdto.setAddedDate(addedDate);
//        ticketdto.setEid(eid);
//        ticketdto.setName(name);
//        ticketdto.setStatus(status);
//        ticketdto.setAssigned(assigned);
//        return ticketdto;
//    }
//    @Test
//    public void getAllTickettest() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        int ticketId = 1;
//        String eid = "eid";
//        String email = "email";
//        String subCategory = "subCategory";
//        String priority = "priority";
//        String category = "category";
//        String assignTo = "assignTo";
//        String description = "description";
//        String createDate = "2022, 6, 6";
//        
//        String status = "Status";
//        TicketDto ticketDto1 = buildTicketDto1(ticketId, eid, email, subCategory, priority, category, description,
//                createDate, resolveDate, requiredDate, status, assignTo);
//        List<TicketDto> ticketDtoList = new ArrayList<TicketDto>();
//        ticketDtoList.add(ticketDto1);
//        Mockito.when(ticketService.getAllTicket()).thenReturn(ticketDtoList);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String inputJSON = objectMapper.writeValueAsString(ticketDto1);
//        MvcResult mvcResult = this.mockMvc
//                .perform(get("/tickets").contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
//        int status1 = mvcResult.getResponse().getStatus();
//        assertEquals(200, status1);
//    }
//    @Test
//    public void getTicketByIdtest() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        int ticketId = 1;
//        String eid = "eid";
//        String email = "email";
//        String subCategory = "subCategory";
//        String priority = "priority";
//        String category = "category";
//        String assignTo = "assignTo";
//        String description = "description";
//        String createDate = "2022, 6, 6";
//        String resolveDate = "2022, 6, 26";
//        String requiredDate = "2022, 6, 16";
//        String status = "Status";
//        TicketDto ticketDto1 = buildTicketDto1(ticketId, eid, email, subCategory, priority, category, description,
//                createDate, resolveDate, requiredDate, status, assignTo);
//        TicketDto ticketDto2 = new TicketDto();
//        ticketDto2.setAssignTo(assignTo);
//        ticketDto2.setStatus(status);
//        ticketDto2.setPriority(priority);
//        ticketDto2.setEid(eid);
//        ticketDto2.setEmail(email);
//        ticketDto2.setCategory(category);
//        ticketDto2.setCreateDate(createDate);
//        ticketDto2.setDescription(description);
//        ticketDto2.setRequiredDate(requiredDate);
//        ticketDto2.setResolvedDate(resolveDate);
//        Mockito.when(ticketService.getTicketById(ticketId)).thenReturn(ticketDto2);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String inputJSON = objectMapper.writeValueAsString(ticketDto1);
//        MvcResult mvcResult = this.mockMvc.perform(get("/tickets/1")).andReturn();
//        int status1 = mvcResult.getResponse().getStatus();
//        assertEquals(200, status1);
//    }
//    @Test
//    public void getalltest() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        int ticketId = 1;
//        String eid = "eid";
//        String email = "email";
//        String subCategory = "subCategory";
//        String priority = "priority";
//        String category = "category";
//        String assignTo = "assignTo";
//        String description = "description";
//        String createDate = "2022, 6, 6";
//        String resolveDate = "2022, 6, 26";
//        String requiredDate = "2022, 6, 16";
//        String status = "Status";
//        TicketDto ticketDto1 = buildTicketDto1(ticketId, eid, email, subCategory, priority, category, description,
//                createDate, resolveDate, requiredDate, status, assignTo);
//        List<TicketDto> ticketDtoList = new ArrayList<TicketDto>();
//        ticketDtoList.add(ticketDto1);
//        Mockito.when(ticketService.getAll("low", "open", "kunal")).thenReturn(ticketDtoList);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String inputJSON = objectMapper.writeValueAsString(ticketDto1);
//        MvcResult mvcResult = this.mockMvc.perform(get("/ticketsfilter?Priority=low&Status=open&assignTo=kunal")
//                .contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
//        int status1 = mvcResult.getResponse().getStatus();
//        assertEquals(200, status1);
//    }
//}