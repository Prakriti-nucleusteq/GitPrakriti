

package com.timesheet.timesheet.Controller;


import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.timesheet.Exception.FileNotFoundException;
import com.timesheet.timesheet.custom.LocationDto;
import com.timesheet.timesheet.service.SheetService;
import com.timesheet.timesheet.service.StorageService;


/**
 * @author opera_ao6omsd .
 *
 */
@RestController
@CrossOrigin("*")
public class NTSheetController {

   
   
        /**
         * sheetservice.
         */
        @Autowired
        private SheetService ntsheetService;
        
        /**
         * Storage service.
         */
        @Autowired
        private StorageService storageService;
        

        /**
         * @param locationDto locatonDto.
         * @return get result.
         * @throws FileNotFoundException filenot found exception.
         * @throws IOException ioexception.
         */
        @PostMapping("/timesheet")
        public ResponseEntity<String> timesheet(@RequestBody LocationDto locationDto)
                throws FileNotFoundException, IOException {
            String nucleusteqFile = locationDto.getNucleusteqFile();
            InputStream inputStreamNucleusteq = storageService.downloadFile(nucleusteqFile);
            ntsheetService.save(inputStreamNucleusteq);
            String petsmartFile = locationDto.getPetsmartFile();
            InputStream inputStreamPetsmart = storageService.downloadFile(petsmartFile);
            ntsheetService.save1(inputStreamPetsmart);
            ntsheetService.getResult();
            return new ResponseEntity<String>("Final file uploaded on s3 bucket...", HttpStatus.OK);
        }
    }