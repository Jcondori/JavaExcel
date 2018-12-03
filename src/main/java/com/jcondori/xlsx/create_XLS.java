package com.jcondori.xlsx;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class create_XLS {

    public static String path = "C:\\Users\\JCondori\\Desktop\\JCondori\\demo.xls".replace("\\", "/");

    public static void main(String[] args) {

        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet();
        HSSFRow fila = hoja.createRow(0);
        HSSFCell celda = fila.createCell((short) 0);
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
