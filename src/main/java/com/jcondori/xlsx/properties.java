package com.jcondori.xlsx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class properties {

    public static String properties = "C:\\Users\\JCondori\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\docroot\\jcondori.properties".replace("\\", "/");

    public static void main(String[] args) {
        try {
            //Declaramos Instancia
            Properties pro = new Properties();
            //Leer Archive Fisico y cargarlo en la Intacia
//            pro.load(new FileInputStream(properties));
//            System.out.println();
//            for (String string : pro.getProperty("Demo2").split(",")) {
//                System.out.println(string);
//            }
            //Añadir un elemento a la instancia cargada
            pro.put("Demo2", "Hola Mundo,demo,demo2");
            //Guardar la intancia modificada en el archivo fisico
            pro.store(new FileOutputStream(properties), null);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
