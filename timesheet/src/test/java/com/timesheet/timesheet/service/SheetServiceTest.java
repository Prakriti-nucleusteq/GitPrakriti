package com.timesheet.timesheet.service;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.timesheet.timesheet.entity.NTSheet;
import com.timesheet.timesheet.excelLogic.NTSheetExcel;
import com.timesheet.timesheet.repo.NTRepo;

@ExtendWith(MockitoExtension.class)
class TimesheetServiceImplTest {
    @Mock
    private NTRepo ntTimesheetRepo;
    
    private NTSheetExcel excelHelper= new NTSheetExcel();
    
    @InjectMocks
    private SheetService timesheetServiceImpl;
    
    private NTSheet ntTimesheet1 = new NTSheet();
    
    private List<NTSheet>ntList;
    
    String path =".\\folder\\NT_Timesheet1.xlsx";
    
    InputStream inputStream;
    
    @BeforeEach
    public void setUp() throws FileNotFoundException {
        MockitoAnnotations.openMocks(this);
        inputStream = new FileInputStream(path);
        ntList= new ArrayList<>();
        
       
        LocalDateTime timeStamp =LocalDateTime.now();
        String userName = "sejal jain";
        String petSmartProgramThatYouSupport ="sjain@petsmart.com" ;
        String additionalComments ="AA-01";

      
        ntTimesheet1.setTimeStamp(timeStamp);
        ntTimesheet1.setUserName(userName);
        ntTimesheet1.setPetSmartProgramThatYouSupport(petSmartProgramThatYouSupport);
        ntTimesheet1.setAdditionalComments(additionalComments);

        ntList.add(ntTimesheet1);
        ntList.add(ntTimesheet1);
        ntList.add(ntTimesheet1);
        ntList.add(ntTimesheet1);

    }
    @DisplayName("JUnit test for Saving method")
    @Test
    public void saveNucleusTimesheetTest() throws FileNotFoundException {
       // when(excelHelper.convertNTExcelToListOfTimesheet()).thenReturn(ntList);
        List<NTSheet> list2 =  excelHelper.convertExcelToListOfNTSheet(inputStream);
        Mockito.when(ntTimesheetRepo.saveAll(list2)).thenReturn(list2);
        InputStream inputStreamtest = new FileInputStream(path);
        assertEquals("vufyh", timesheetServiceImpl.save(inputStreamtest));
        assertEquals("mo", timesheetServiceImpl.save(inputStreamtest));
       
    }
}

//import static org.mockito.Mockito.mockStatic;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.timesheet.timesheet.entity.NTSheet;
//import com.timesheet.timesheet.excelLogic.NTSheetExcel;
//import com.timesheet.timesheet.repo.NTRepo;
//
//@ExtendWith(MockitoExtension.class)
//public class SheetServiceTest {
//    
//    @Autowired
//    @InjectMocks
//    private SheetService sheetService;
//    
//    @Mock
//    private NTRepo ntRepo;
//    
//    @Mock
//    private NTSheetExcel excel;
//    
//    private NTSheet ntSheet;
//    
//    @BeforeEach
//    public void setUp() {
//       ntSheet = new NTSheet(LocalDateTime.now(), "prakriti", "pg@gmail.com", new Date(), "dvn", "cdjb");
//    }
//   
//    
//    @org.junit.jupiter.api.Test
//    public void savePositveTest() throws FileNotFoundException {
//
//        List<NTSheet> list = new ArrayList<NTSheet>();
//        list.add(ntSheet);
//
//        String path = ".\\folder\\NT_Timesheet.xlsx";
//
//        File file = new File(path);
//        InputStream inputStream = new FileInputStream(file);
//
////        MockedStatic<NTSheetExcel> classMock = mockStatic(NTSheetExcel.class);
//
//        sheetService.save(inputStream);
//
//        verify(sheetService,times(1)).save(inputStream);
//
//
//
//    }
//}
