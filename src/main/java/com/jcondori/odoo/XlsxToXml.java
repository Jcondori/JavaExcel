package com.jcondori.odoo;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class XlsxToXml {

    private static final String XLSX_FILE_PATH = "D:\\Documentos\\JavaProjects\\JavaExcel\\src\\main\\java\\com\\jcondori\\odoo\\sunat.document.type.xlsx";

    public static void main(String[] args) throws IOException {
        InputStream ExcelStream = new FileInputStream(XLSX_FILE_PATH);
        File file = new File(XLSX_FILE_PATH);
        Workbook excel = WorkbookFactory.create(ExcelStream);

        DataFormatter dataFormatter = new DataFormatter(); //Formateador para traer el dato de una celda

        Map<Integer, String> titulos = new HashMap<Integer, String>();

        for (Row row : excel.getSheetAt(0)) {
            String model = file.getName().replace(".xlsx", "").replace(".xls", "");
            if (row.getRowNum() == 0) {
                for (int cellNumber = 0; cellNumber < row.getLastCellNum(); cellNumber++) {
                    titulos.put(cellNumber, dataFormatter.formatCellValue(row.getCell(cellNumber)));
                }
            } else {
                StringBuilder record = new StringBuilder("<record model=\"" + model + "\"");
                for (int cellNumber = 0; cellNumber < row.getLastCellNum(); cellNumber++) {
                    String titulo = titulos.get(cellNumber);
                    if (titulo.equals("id")) {
                        record.append(" id=\"").append(dataFormatter.formatCellValue(row.getCell(cellNumber)).replace(".", "_")).append("\">");
                    } else {
//                        record.append("<field name=\"")
                        StringBuilder field = new StringBuilder("<field name=\"")
                                .append(titulo);
                        String value = dataFormatter.formatCellValue(row.getCell(cellNumber)).trim();
                        if (value.equals("") || value.length() == 0) {
                            field.append("\"/>");
                        } else if (value.contains("eval=") || value.contains("ref=")) {
                            field.append("\" ")
                                    .append(value)
                                    .append("/>");
                        } else {
                            field.append("\">")
                                    .append(value)
                                    .append("</field>");
                        }
                        if (value.equals("") || value.length() == 0) {
                            record.append("<!--").append(field).append("-->");
                        } else {
                            record.append(field);
                        }
                    }
                }
                record.append("</record>");
                System.out.println(record);
            }
        }
        excel.close();
    }
}
