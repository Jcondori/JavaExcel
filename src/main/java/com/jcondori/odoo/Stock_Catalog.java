package com.jcondori.odoo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stock_Catalog {

    public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\Jcondori\\Desktop\\JCondori\\Stock_Catalog.xlsx".replace("\\", "/");

    public static void main(String[] args) throws IOException, InvalidFormatException {
        InputStream ExcelStream = new FileInputStream(SAMPLE_XLSX_FILE_PATH);
        Workbook excel = WorkbookFactory.create(ExcelStream);

        DataFormatter dataFormatter = new DataFormatter(); //Formateador para traer el dato de una celda

        //System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Sheet sheet : excel) {
            for (Row row : sheet) {
                    if (row.getRowNum() != 0) {
                        String Numero = dataFormatter.formatCellValue(row.getCell(0));
                        String Descripcion = dataFormatter.formatCellValue(row.getCell(1));
                        Descripcion = Descripcion.trim();
                        System.out.println("<record model=\"sunat.stock_catalog\" id=\"" + Numero + "\"><field name=\"number\">" + Numero + "</field><field name=\"description\">" + Descripcion + "</field></record>");
                    }
            }
            //System.out.println("------------------------------------------------------");
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
            Logger.getLogger(Stock_Catalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
