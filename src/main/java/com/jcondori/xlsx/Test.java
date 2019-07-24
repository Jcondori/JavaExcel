package com.jcondori.xlsx;

import com.jcondori.Dao.Reporte;
import com.jcondori.model.Model;
import javafx.geometry.Point2D;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPoint2DImpl;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class Test {

    public static String path = "C:\\Users\\Jcondori\\3D Objects\\reporte.xlsx";

//    public static void main(String[] args) throws SQLException {
//        ReporteAsistencia reporteAsistencia = new ReporteAsistencia();
//        Reporte dao = new Reporte();
//
//        List<Model> lista = dao.listarReporte();
//
//        XSSFWorkbook excel = new XSSFWorkbook();
//        XSSFSheet hoja1 = excel.createSheet();
//        XSSFRow titulos = hoja1.createRow(0);
//        titulos.createCell(0).setCellValue("Nombre");
//        titulos.createCell(1).setCellValue("Apellido");
//        titulos.createCell(2).setCellValue("Dato1");
//        titulos.createCell(3).setCellValue("Dato2");
//        titulos.createCell(4).setCellValue("Dato3");
//        int numrow = 0; //Nos posicionamos en la primera fila
//        for (Model model : lista) {
//            numrow++; //Pasar a la siguiente Fila
//            XSSFRow row = hoja1.createRow(numrow); //Creamos la fila para poder escribir en ella
//            row.createCell(0).setCellValue(model.getCampo1());
//            row.createCell(1).setCellValue(model.getCampo2());
//            row.createCell(2).setCellValue(model.getCampo3());
//            row.createCell(3).setCellValue(model.getCampo4());
//            row.createCell(4).setCellValue(model.getCampo5());
//        }
//        try {
//            FileOutputStream elFichero = new FileOutputStream(path);
//            excel.write(elFichero);
//            elFichero.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage() + e.getLocalizedMessage());
//        }
////        reporteAsistencia.generarReporte(lista);
//
//    }

    public static void main(String[] args) {
        try {
            /* Create a Workbook and Worksheet */
            XSSFWorkbook my_workbook = new XSSFWorkbook();
            XSSFSheet my_sheet = my_workbook.createSheet("MyLogo");
//            my_sheet.createRow(0).setHeight(Short.valueOf("2000"));
//            my_sheet.setRow
//            my_sheet.setColumnWidth(0,4000);
            /* Read input PNG / JPG Image into FileInputStream Object*/
            InputStream my_banner_image = null;
            my_banner_image = new FileInputStream("C:\\Users\\Jcondori\\Pictures\\coffee-time-png_91570 - copia.jpg");
            /* Convert picture to be added into a byte array */
            byte[] bytes = IOUtils.toByteArray(my_banner_image);
            /* Add Picture to Workbook, Specify picture type as PNG and Get an Index */
            int my_picture_id = my_workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            /* Close the InputStream. We are ready to attach the image to workbook now */
            my_banner_image.close();
            /* Create the drawing container */
            XSSFDrawing drawing = my_sheet.createDrawingPatriarch();
            /* Create an anchor point */
            XSSFClientAnchor my_anchor = new XSSFClientAnchor();
            /* Define top left corner, and we can resize picture suitable from there */
            my_anchor.setCol1(0);
            my_anchor.setRow1(0);
            /* Invoke createPicture and pass the anchor point and ID */
            XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
            /* Call resize method, which resizes the image */
            my_picture.resize();
            /* Write changes to the workbook */
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Jcondori\\3D Objects\\reporte2.xlsx"));
            my_workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
