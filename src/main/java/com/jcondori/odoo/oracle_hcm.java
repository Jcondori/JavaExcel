package com.jcondori.odoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class oracle_hcm {

    public static String file_name = "C:\\Users\\jcondori\\Documents\\GitHub\\Experimentos\\Eliana\\V2\\Workers\\_17.ExternalIdentifier.dat";
    public static int[] list_columns = new int[]{8};
    public static int[] persons = new int[]{21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    public static String dato_delante = "";
    public static String dato_despues = "_";
    public static String ceros = "00000000";


    public static void main(String[] args) {
        //System.out.println(file_name);
        try {
            FileReader fr = new FileReader(new File(file_name));   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace("|", ";");
                String[] columns = line.split(";");

                for (int column : list_columns) {
                    column = column - 1; // Igualamos a conteo normal
//                    if(columns.length > column)
                    String valor = columns[column];
                    System.out.print(tranform(valor));
//                    System.out.print(valor);
//                    System.out.print("|");
                }
                System.out.println();
//                sb.append(line);      //appends line to string buffer
//                sb.append("\n");     //line feed
            }
            fr.close();    //closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());   //returns a string that textually represents the object
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static String tranform(String dato) {
        if (is_numeric(dato)) {
            if (dato.length() < 3) {
                for (int i : persons) {
                    String buscado = String.valueOf(i);
                    if (dato.trim().equals(buscado)) {
                        return dato.trim() + ceros;
                    }
                }
            }
        } else {
            if (dato_delante.length() > 0) {
                for (int i : persons) {
                    String buscado = dato_delante + String.valueOf(i);
                    if (dato.trim().contains(buscado)) {
                        return dato.replace(buscado, buscado + ceros);
                    }
                }
            }
            if (dato_despues.length() > 0) {
                for (int i : persons) {
                    String buscado = String.valueOf(i) + dato_despues;
                    if (dato.trim().contains(buscado)) {
                        return dato.replace(buscado, buscado + ceros);
                    }
                }
            }
        }
        return null;
    }

    public static boolean is_numeric(String numero) {
        try {
            Double num = Double.parseDouble(numero);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
