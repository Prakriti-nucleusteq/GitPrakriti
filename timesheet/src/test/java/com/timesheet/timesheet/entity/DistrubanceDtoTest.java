package com.timesheet.timesheet.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DistrubanceDtoTest {
    @Test
    public void DistrubanceDtoTest() {
        DistrubanceDto disturbancy = new DistrubanceDto();
        String petsmartEmail="sejal@petsmart.com";
        double ntHours =20.0;
        double petsmartHours =22.0;
        String name="sejal";
        disturbancy.setPetsmartEmail(petsmartEmail);
        disturbancy.setNtHours(ntHours);
        disturbancy.setPetsmartHours(petsmartHours);
        disturbancy.setName(name);
         assertEquals(petsmartEmail, disturbancy.getPetsmartEmail());
         assertEquals(ntHours, disturbancy.getNtHours());
         assertEquals(petsmartHours, disturbancy.getPetsmartHours());
         assertEquals(name, disturbancy.getName() );
    }
    @Test
    public void testGettersAndSetters() {
        DistrubanceDto disturbancy = new DistrubanceDto();
        String petsmartEmail="sejal@petsmart.com";
        disturbancy.setPetsmartEmail(petsmartEmail);
        assertEquals(petsmartEmail, disturbancy.getPetsmartEmail());
        double ntHours =20.0;
        disturbancy.setNtHours(ntHours);
        assertEquals(ntHours, disturbancy.getNtHours());
        double petsmartHours =22.0;
        disturbancy.setPetsmartHours(petsmartHours);
        assertEquals(petsmartHours, disturbancy.getPetsmartHours());
        String name="sejal";
        disturbancy.setName(name);
        assertEquals(name, disturbancy.getName() );
    }
}

