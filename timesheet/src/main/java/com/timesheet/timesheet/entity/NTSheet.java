package com.timesheet.timesheet.entity;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
/**
 * @author opera_ao6omsd ntsheet.
 *
 */
@Data
@Entity
public class NTSheet extends Timesheet {

    
    /**
     * timestamp.
     */
    private LocalDateTime timeStamp;
    /**
     * username.
     */
    private String userName;
    /**
     * email.
     */
    @Id
    private String email;
    /**
     * petSmartProgramThatYouSupport.
     */
    private String petSmartProgramThatYouSupport;
    /**
     * additionalComments.
     */
    private String additionalComments;
    
    
    
    
    
    
    /**
     * to string.
     */
    @Override
    public String toString() {
        return "" + email
                + timeForTheWeekEnding + "";
    }
    /**
     * @return timestamp.
     */
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    /**
     * @param timeStamp set timestamp.
     */
    public void setTimeStamp(final LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    /**
     * @return username.
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param userName user name.
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    /**
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }
    /**
     * timeForTheWeekEnding.
     */
    public Date getTimeForTheWeekEnding() {
        return timeForTheWeekEnding;
    }
    /**
     *setTimeForTheWeekEnding.
     */
    public void setTimeForTheWeekEnding(final Date timeForTheWeekEnding) {
        this.timeForTheWeekEnding = timeForTheWeekEnding;
    }
    /**
     * @return petSmartProgramThatYouSupport.
     */
    public String getPetSmartProgramThatYouSupport() {
        return petSmartProgramThatYouSupport;
    }
    public void setPetSmartProgramThatYouSupport(final String petSmartProgramThatYouSupport) {
        this.petSmartProgramThatYouSupport = petSmartProgramThatYouSupport;
    }

    /**
     * @return additionalComments.
     */
    public String getAdditionalComments() {
        return additionalComments;
    }
    /**
     * @param additionalComments setAdditionalComments.
     */
    public void setAdditionalComments(final String additionalComments) {
        this.additionalComments = additionalComments;
    }
    
    
    /**
     * @param timeStamp timeStamp.
     * @param userName userName.
     * @param email email.
     * @param timeForTheWeekEnding timeForTheWeekEnding.
     * @param petSmartProgramThatYouSupport petSmartProgramThatYouSupport.
     * @param additionalComments additionalComments.
     */
    public NTSheet(LocalDateTime timeStamp, String userName, String email, Date timeForTheWeekEnding,
            String petSmartProgramThatYouSupport,
            String additionalComments) {
        super();
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.email = email;
        this.timeForTheWeekEnding = timeForTheWeekEnding;
        this.petSmartProgramThatYouSupport = petSmartProgramThatYouSupport;

        this.additionalComments = additionalComments;
    }
    /**
     *  ntsheet.
     */
    public NTSheet() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public int hashCode() {
        return Objects.hash(additionalComments, email, petSmartProgramThatYouSupport, timeStamp, userName);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NTSheet other = (NTSheet) obj;
        return Objects.equals(additionalComments, other.additionalComments) && Objects.equals(email, other.email)
                && Objects.equals(petSmartProgramThatYouSupport, other.petSmartProgramThatYouSupport)
                && Objects.equals(timeStamp, other.timeStamp) && Objects.equals(userName, other.userName);
    }
    

}
