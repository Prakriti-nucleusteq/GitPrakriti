package com.timesheet.timesheet.excelLogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.timesheet.timesheet.entity.NTSheet;

/**
 * @author opera_ao6omsd NTSHEET EXCEL.
 *
 */
public class NTSheetExcel {

    // check that file is of excel type or not
    /**
     * @param file file.
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
     * @param inputStream inputstream.
     * @return list.
     */
    public static List<NTSheet> convertExcelToListOfNTSheet(InputStream inputStream) {
        List<NTSheet> list = new ArrayList<>();

        try {
//            File file = new File(path);
//            FileInputStream inputStream = new FileInputStream(file);
            

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheet("sheet1");
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

                NTSheet p = new NTSheet();
                double totalHours =0;
                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                    case 0:
                        p.setTimeStamp(cell.getLocalDateTimeCellValue());
                        break;
                    case 1:
                        p.setUserName(cell.getStringCellValue());
                        break;
                    case 2:
                        p.setEmail(cell.getStringCellValue());
                        break;
                    case 3:
                        p.setTimeForTheWeekEnding((Date) cell.getDateCellValue());
                        break;
                    case 4:
                        p.setPetSmartProgramThatYouSupport(cell.getStringCellValue());
                        break;
                    case 5:
                        totalHours +=  cell.getNumericCellValue();
                        break;
                    case 6:
                        totalHours +=  cell.getNumericCellValue();
                        break;
                    case 7:
                        totalHours +=  cell.getNumericCellValue();
                        break;
                    case 8:
                        totalHours +=  cell.getNumericCellValue();
                        break;
                    case 9:
                        totalHours +=  cell.getNumericCellValue();
                        break;
                    case 10:
                        p.setAdditionalComments(cell.getStringCellValue());
                    default:
                        break;
                    }
                    cid++;

                }
                p.setHoursWorked(totalHours);

                list.add(p);

            }

        } catch (IOException e) {
            System.out.println("excel sheet empty");

        }
        return list;

    }

}
