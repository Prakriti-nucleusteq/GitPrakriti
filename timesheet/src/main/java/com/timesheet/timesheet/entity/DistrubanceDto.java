package com.timesheet.timesheet.entity;

/**
 * @author opera_ao6omsd DistrubanceDto.
 *
 */


public class DistrubanceDto {

    /**
     * petsmartEmail.
     */
    private String petsmartEmail;
    /**
     * ntHours.
     */
    private double ntHours;
    /**
     * petsmartHours.
     */
    private double petsmartHours;
    /**
     * name.
     */
    private String name;
    
    /**
     * @param petsmartEmail petsmartEmail.
     * @param ntHours ntHours.
     * @param petsmartHours petsmartHours.
     * @param name name.
     */
    public DistrubanceDto(final String petsmartEmail, final double ntHours, final double petsmartHours, final String name) {
        super();
        this.petsmartEmail = petsmartEmail;
        this.ntHours = ntHours;
        this.petsmartHours = petsmartHours;
        this.name = name;
    }
    /**
     * DistrubanceDto.
     */
    public DistrubanceDto() {
        // TODO Auto-generated constructor stub
    }
    /**
     * @return petsmartEmail.
     */
    public String getPetsmartEmail() {
        return petsmartEmail;
    }
    /**
     * @param petsmartEmail  setPetsmartEmail.
     */
    public void setPetsmartEmail(final String petsmartEmail) {
        this.petsmartEmail = petsmartEmail;
    }
    /**
     * @return ntHours.
     */
    public double getNtHours() {
        return ntHours;
    }
    /**
     * @param ntHours setNtHours.
     */
    public void setNtHours(final double ntHours) {
        this.ntHours = ntHours;
    }
    /**
     * @return petsmartHours.
     */
    public double getPetsmartHours() {
        return petsmartHours;
    }
    /**
     * @param petsmartHours setPetsmartHours.
     */
    public void setPetsmartHours(final double petsmartHours) {
        this.petsmartHours = petsmartHours;
    }
    /**
     * @return name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name setname.
     */
    public void setName(final String name) {
        this.name = name;
    }
    
    
}
