package com.timesheet.timesheet.excelLogic;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.timesheet.timesheet.entity.PetsmartSheet;

/**
 * @author opera_ao6omsd PetsmartSheetExcel.
 *
 */
public class PetsmartSheetExcel {


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
    public static List<PetsmartSheet> convertExcelToListOfPetsmartSheet(InputStream inputStream) {
        List<PetsmartSheet> list = new ArrayList<>();

        try {
//           File file = new File(path);
//           FileInputStream inputStream  = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheet("Sheet1");

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

                PetsmartSheet p = new PetsmartSheet();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                    case 0:
                        p.setName(cell.getStringCellValue());
                        break;
                    case 1:
                        p.setProject(cell.getStringCellValue());
                        break;
                    case 2:
                        p.setTimeForTheWeekEnding((Date) cell.getDateCellValue());
                        break;
                    case 3:
                        p.setHoursWorked((int)cell.getNumericCellValue());
                        break;
                    case 4:
                        p.setNotes(cell.getStringCellValue());
                        break;
                    case 5:
                        p.setCreated((LocalDateTime)cell.getLocalDateTimeCellValue());
                        break;
                    default:
                        break;
                    }
                    cid++;

                }

                list.add(p);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

}
