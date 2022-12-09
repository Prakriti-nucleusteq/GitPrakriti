package com.timesheet.timesheet.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timesheet.timesheet.Exception.RescourseNotFound;
import com.timesheet.timesheet.entity.DistrubanceDto;
import com.timesheet.timesheet.entity.Employee;
import com.timesheet.timesheet.entity.NTSheet;
import com.timesheet.timesheet.entity.PetsmartSheet;
import com.timesheet.timesheet.entity.Result;
import com.timesheet.timesheet.excelLogic.EmployeeSheetExcel;
import com.timesheet.timesheet.excelLogic.NTSheetExcel;
import com.timesheet.timesheet.excelLogic.PetsmartSheetExcel;
import com.timesheet.timesheet.excelLogic.ResultExcel;
import com.timesheet.timesheet.repo.EmployeeRepo;
import com.timesheet.timesheet.repo.NTRepo;
import com.timesheet.timesheet.repo.PetsmartRepo;
import com.timesheet.timesheet.repo.ResultRepo;


@Service
public class SheetService {

    @Autowired
    private ResultRepo resultRepo;

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private NTRepo ntRepo;

    
    @Autowired
    private PetsmartRepo petsmartRepo;

    @Autowired
    StorageService storageService;
    
    @Autowired
    EntityManager entityManager;

    // nucleusteq service calling
    public String save(InputStream inputStream) {
        List<NTSheet> ntSheets = NTSheetExcel.convertExcelToListOfNTSheet(inputStream);
        this.ntRepo.saveAll(ntSheets);
        return "ntsheetprint";
    }

    // petsmart service calling
    public void save1(InputStream inputStream) {
        List<Employee> employees = employeeRepo.findAll();
        List<PetsmartSheet> petsmartSheets = PetsmartSheetExcel.convertExcelToListOfPetsmartSheet(inputStream);
//        for(PetsmartSheet pSheet : petsmartSheets) {
//           for(Employee emp : employees) {
//               if(pSheet.getName().equalsIgnoreCase(emp.getName())) {
//                   pSheet.setEmail(emp.getEmail());
//                   petsmartSheets.add(pSheet);
//               }
//           }
//        }
        
        petsmartSheets.stream().map(petS -> {
            for(Employee emp : employees) {
                if(petS.getName().equalsIgnoreCase(emp.getName())) {
                    petS.setEmail(emp.getEmail());
                }
            }
            return petS;
        }).collect(Collectors.toList());
        this.petsmartRepo.saveAll(petsmartSheets);
    }

    // employee service calliing
    public void saveemployee(String path) {
        List<Employee> employees = EmployeeSheetExcel.convertExcelToListOfemployeesheet(path);
        this.employeeRepo.saveAll(employees);
    }

    public void saveresult(String path) {
        List<Result> results = ResultExcel.convertExcelToListOfresultsheet(path);
        this.resultRepo.saveAll(results);
    }

    public void getResult() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("time");
        String query = "SELECT new com.timesheet.timesheet.entity.DistrubanceDto(NT.email,NT.hoursWorked,PT.hoursWorked,NT.userName)  FROM NTSheet NT\r\n"
                + "JOIN PetsmartSheet PT\r\n"
                + "ON NT.timeForTheWeekEnding = PT.timeForTheWeekEnding\r\n"
                + "WhERE NT.hoursWorked  != PT.hoursWorked\r\n"
                + "AND NT.email  = PT.email";
         TypedQuery<DistrubanceDto> disturbances =   entityManager.createQuery(query, DistrubanceDto.class);
         List<DistrubanceDto> findDisturbances =disturbances.getResultList();
        if (Objects.isNull(sheet)) {
            throw new FileNotFoundException("file not found");
        }

        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        data.put("1", new Object[] { "name" ,"ntHours","petsmartEmail","petsmartHours" ,"disturbance","comments"});

        int q = 1;

try {
    if (!Objects.isNull(findDisturbances)) {
                 for(DistrubanceDto diffResult : findDisturbances) {
                     
                 double disturbance = diffResult.getNtHours() - diffResult.getPetsmartHours();
                 System.out.println("=========>"+diffResult.getNtHours() );
                 if (disturbance != 0) { String comment = "";
                                 if (disturbance > 0) {
                                     comment = "Nucleusteq Hours overfload by " + disturbance + " hours";
                                 } else if (disturbance < 0) {
                                     comment = "Nucleusteq Hours underfload by " + disturbance + " hours";
                                 }
                                 ++q;
                                data.put("q" ,new Object[] { diffResult.getName() ,diffResult.getNtHours() ,diffResult.getPetsmartEmail(),diffResult.getPetsmartHours(),disturbance,comment});
                             }
                         }
                     }
             else {
                 throw new RescourseNotFound("Resourcee not found");
             }



                                    Set<String> keyset = data.keySet();
                                    int rownum = 0;
                                    for (String key : keyset) {
                                        Row row = sheet.createRow(rownum++);
                                        Object[] objArr = data.get(key);
                                        int cellnum = 0;
                                        for (Object obj : objArr) {
                                            Cell cell = row.createCell(cellnum++);
                                            if (obj instanceof String) {
                                                cell.setCellValue((String) obj);
                                            }
                                            else if (obj instanceof Double) {
                                                cell.setCellValue((Double) obj);
                                            }
                                            else {
                                        cell.setCellValue((Integer) obj);
                                            }
                                        }
                                    }

}catch(Exception e) {
       System.out.println("email and name not match");
}finally {

        String filePath = ".\\folder\\result.xlsx";
        File file = new File(filePath);

        FileOutputStream outstream = new FileOutputStream(file);
        workbook.write(outstream);
        outstream.close();
        storageService.uploadFile(file);
        System.out.println("done");

}
    }

}
