package com.project.helpesk.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

/**
 * @author opera_ao6omsd
 *
 */
@Entity
@Table(name = "ticket")
public final class Ticket {

    /**
     * integer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    /**
     * string.
     */
    @Column(name = "description", length = 200)
    private String description;

    /**
     * string.
     */
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    /**
     * . string priority.
     */
    @Column(name = "priority", nullable = false, length = 20)
    private String priority;

    /**
     * local date.
     */
    @Column(name = "date", nullable = false, length = 20)
    private LocalDate addedDate;

    /**
     * category.
     */
    @Column(name = "category", nullable = false, length = 100)
    private String category;

    /**
     * subcategory.
     */
    @Column(name = "sub_category", nullable = false, length = 100)
    private String subCategory;

    /**
     * empID.
     */
    @Column(name = "emp_id", nullable = false, length = 20)
    private int eid;

    /**
     * assignedTo.
     */
    @Column(name = "assigned_to", nullable = false, length = 40)
    private String assigned;

    /**
     * name.
     */
    private String name;

    /**
     * @param name name.
     */
    public Ticket(final String name) {
        super();
        this.name = name;
    }

    /**
     * category.
     */

    /**
     * @return ticket id
     */

    public String getName() {
        return name;
    }

    /**
     * @param name name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description set description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status set status
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @return priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority set priority
     */
    public void setPriority(final String priority) {
        this.priority = priority;
    }

    /**
     * @return local date
     */
    public LocalDate getAddedDate() {
        return addedDate;
    }

    /**
     * @param addedDate addedDate.
     */
    public void setAddedDate(final LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    /**
     * @return category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category category.
     */
    public void setCategory(final String category) {
        this.category = category;
    }

    /**
     * @return subCategory.
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * @param subCategory subCategory.
     */
    public void setSubCategory(final String subCategory) {
        this.subCategory = subCategory;
    }

    /**
     * @param ticketId ticketId.
     */
    public void setTicketId(final Integer ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return ticketId.
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId ticketId.
     */
    public void setTicketId(final int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return assigned.
     */
    public String getAssigned() {
        return assigned;
    }

    /**
     * @param assigned assigned.
     */
    public void setAssigned(final String assigned) {
        this.assigned = assigned;
    }

    /**
     * @param ticketId    ticketId.
     * @param description description.
     * @param status      status.
     * @param priority    priority.
     * @param addedDate   addedDate.
     * @param category    category.
     * @param subCategory subCategory.
     * @param eid         eid.
     * @param assigned    assigned.
     */
    public Ticket(final int ticketId, final String description, final String status, final String priority,
            final LocalDate addedDate, final String category, final String subCategory, final int eid,
            final String assigned) {
        super();
        this.ticketId = ticketId;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.addedDate = addedDate;
        this.category = category;
        this.subCategory = subCategory;
        this.eid = eid;
        this.assigned = assigned;
    }

    /**
     * @return eid.
     */
    public int getEid() {
        return eid;
    }

    /**
     * @param eid eid.
     */
    public void setEid(final int eid) {
        this.eid = eid;
    }

    /**
     * ticket.
     */
    public Ticket() {

    }

}
