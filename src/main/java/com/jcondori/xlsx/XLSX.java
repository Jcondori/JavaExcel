package com.jcondori.xlsx;

import java.io.FileInputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XLSX {

    public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\JCondori\\Desktop\\demo.xlsx".replace("\\", "/");

    public static void main(String[] args) throws IOException, InvalidFormatException {
        InputStream ExcelStream = new FileInputStream(SAMPLE_XLSX_FILE_PATH);
        Workbook excel = WorkbookFactory.create(ExcelStream);

        DataFormatter dataFormatter = new DataFormatter(); //Formateador para traer el dato de una celda

        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Sheet sheet : excel) {
            for (Row row : sheet) {
                System.err.print(row.getRowNum() + " -->> ");
                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cell.getColumnIndex() + " -> " + cellValue + "\t");
                }
                System.out.println();
            }
            System.out.println("------------------------------------------------------");
        }

//        guardar(excel);
        excel.close();

    }

    public static void guardar(Workbook wb) throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(SAMPLE_XLSX_FILE_PATH);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XLSX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
