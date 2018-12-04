package com.jcondori.xlsx;

import com.jcondori.model.Model;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReporteAsistencia {

    public String path = "C:\\Users\\Jcondori\\3D Objects\\reporte.xlsx";

    public void generarReporte(List<Model> lista) {
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = libro.createSheet();
        int filas = 2;
        XSSFRow fila = hoja.createRow(filas);
        fila.createCell(1).setCellValue("DNI");
        fila.createCell(2).setCellValue("APELLIDOS");
        fila.createCell(3).setCellValue("NOMBRES");
        fila.createCell(4).setCellValue("MODALIDAD");
        fila.createCell(5).setCellValue("CENTRO DE INTEREZ");
        fila.createCell(6).setCellValue("FECHA");
        fila.createCell(7).setCellValue("DIA");
        fila.createCell(8).setCellValue("RESPONSABLE");
        fila.createCell(9).setCellValue("EMPRESA/PREDIO");
        for (Model model : lista) {
            filas++;
            fila = hoja.createRow(filas);
            fila.createCell(1).setCellValue(Integer.valueOf(model.getCampo1()));
            fila.createCell(2).setCellValue(model.getCampo2());
            fila.createCell(3).setCellValue(model.getCampo3());
            fila.createCell(4).setCellValue(model.getCampo4());
            fila.createCell(5).setCellValue(model.getCampo5());
            fila.createCell(6).setCellValue(model.getCampo6());
            fila.createCell(7).setCellValue(model.getCampo7());
            fila.createCell(8).setCellValue(model.getCampo8());
            fila.createCell(9).setCellValue(model.getCampo9());

        }
        for (int i = 1; i < 10; i++) {
            hoja.autoSizeColumn(i);
        }
        guardarReporte(libro);
    }

    public void guardarReporte(XSSFWorkbook libro) {
        try {
            FileOutputStream elFichero = new FileOutputStream(path);
            libro.write(elFichero);
            elFichero.close();
        } catch (IOException e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage());
        }
    }

}
