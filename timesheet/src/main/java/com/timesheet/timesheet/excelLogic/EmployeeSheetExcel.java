package com.timesheet.timesheet.excelLogic;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.timesheet.timesheet.entity.Employee;


/**
 * @author opera_ao6omsd EmployeeSheetExcel.
 *
 */
public class EmployeeSheetExcel {


    // check that file is of excel type or not
    /**
     * @param file .
     * @return type.
     */
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }

    // convert excel to list of products

    /**
     * @param path path.
     * @return list.
     */
    public static List<Employee> convertExcelToListOfemployeesheet(String path) {
        List<Employee> list = new ArrayList<>();

        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheet("employee info");

            if(Objects.isNull(sheet)) {
                throw new FileNotFoundException("file not found");
            }
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                Employee p = new Employee();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                    case 0:
                        p.setName(cell.getStringCellValue());
                        break;
                    case 1:
                        p.setEmail(cell.getStringCellValue());
                        break;
                    
                    }
                    cid++;

                }

                list.add(p);

            }

        } catch (IOException e) {
            System.out.println("excel sheet empty");
        }
        return list;

    }

}

