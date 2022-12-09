package com.timesheet.timesheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.timesheet.timesheet.config.Constants;

import com.timesheet.timesheet.service.SheetService;

import org.springframework.boot.CommandLineRunner;



@SpringBootApplication
public class TimesheetApplication implements CommandLineRunner{

    @Autowired
    private SheetService sheetService;
   
	public static void main(final String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}

    @Override
    public void run(final String... args) throws Exception {
        sheetService.saveemployee(Constants.EMPLOYEE_SHEET);

	
    }

}
