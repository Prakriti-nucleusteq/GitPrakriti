package com.project.helpesk.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * @author opera_ao6omsd.
 *
 */
public final class TicketDto {

    /**
     * Interger.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    /**
     * String.
     */
    // @NotEmpty
    private String description;

    /**
     * assigned.
     */
    private String assigned;

    /**
     * String.
     */
    private String status;

    /**
     * string.
     */
    private String priority;

    /**
     * String name.
     */
    private String name;

    /**
     * local date.
     */
    private LocalDate addedDate;

    /**
     * category.
     */
    @Column(name = "category", nullable = false, length = 100)
    private String category;

    /**
     * subCategory.
     */
    @Column(name = "sub_category", nullable = false, length = 100)
    private String subCategory;

    /**
     * eid.
     */
    @Column(name = "emp_id", nullable = false, length = 20)
    private int eid;

    /**
     * @return get description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param name name.
     */
    public TicketDto(final String name) {
        super();
        this.name = name;
    }

    /**
     * @return name.
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
     * @param priority set priority.
     */
    public void setPriority(final String priority) {
        this.priority = priority;
    }

    /**
     * @return local date.
     */
    public LocalDate getAddedDate() {
        return addedDate;
    }

    /**
     * @param addedDate set add date.
     */
    public void setAddedDate(final LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    /**
     * @return get category.
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
     * @return subcategory.
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * @param subCategory subcategory.
     */
    public void setSubCategory(final String subCategory) {
        this.subCategory = subCategory;
    }

    /**
     * @return get ticket id.
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId ticket id.
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
     * @param ticketId    ticket id.
     * @param description description.
     * @param assigned    assigned.
     * @param status      status.
     * @param priority    priority.
     * @param addedDate   addeddate.
     * @param category    category.
     * @param subCategory subcategory.
     * @param eid         eid.
     */
    public TicketDto(final int ticketId, @NotEmpty final String description, final String assigned, final String status,
            final String priority, final LocalDate addedDate, final String category, final String subCategory,
            final int eid) {
        super();
        this.ticketId = ticketId;
        this.description = description;
        this.assigned = assigned;
        this.status = status;
        this.priority = priority;
        this.addedDate = addedDate;
        this.category = category;
        this.subCategory = subCategory;
        this.eid = eid;
    }

    /**
     * @return eid.
     */
    public int getEid() {
        return eid;
    }

    /**
     * @param eid set eid.
     */
    public void setEid(final int eid) {
        this.eid = eid;
    }

    /**
     * ticket dto.
     */
    public TicketDto() {

    }

}
