package com.timesheet.timesheet.custom;
/**
 * @author opera_ao6omsd .
 *
 */
public class LocationDto {
    /**
     * nucleusteefile.
     */
    public String nucleusteqFile;
    /**
     * petsmartfile.
     */
    public String petsmartFile;
    
    /**
     * @return getNucleusteqFile.
     */
    public String getNucleusteqFile() {
        return nucleusteqFile;
    }
    /**
     * @param nucleusteqFile setNucleusteqFile.
     */
    public void setNucleusteqFile(String nucleusteqFile) {
        this.nucleusteqFile = nucleusteqFile;
    }
    /**
     * @return getPetsmartFile.
     */
    public String getPetsmartFile() {
        return petsmartFile;
    }
    /**
     * @param petsmartFile setPetsmartFile.
     */
    public void setPetsmartFile(String petsmartFile) {
        this.petsmartFile = petsmartFile;
    }
    /**
     * @param nucleusteqFile nucleusteqFile.
     * @param petsmartFile petsmartFile.
     */
    public LocationDto(String nucleusteqFile, String petsmartFile) {
        super();
        this.nucleusteqFile = nucleusteqFile;
        this.petsmartFile = petsmartFile;
    }
    /**
     * LocationDto.
     */
    public LocationDto() {
        super();
    }
}
