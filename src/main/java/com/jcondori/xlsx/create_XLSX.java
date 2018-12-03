package com.jcondori.xlsx;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class create_XLSX {

    public static String path = "C:\\Users\\JCondori\\Desktop\\JCondori\\demo.xlsx".replace("\\", "/");

    public static void main(String[] args) {

        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = libro.createSheet();
        XSSFRow fila = hoja.createRow(0);
        XSSFCell celda = fila.createCell(0);
        celda.setCellValue("Demo");
        try {
            FileOutputStream elFichero = new FileOutputStream(path);
            libro.write(elFichero);
            elFichero.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
