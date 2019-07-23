package com.jcondori.odoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {

    public static void main(String[] args) {
        try {
            FileWriter write = new FileWriter(new File("C:\\Users\\Jcondori\\Desktop\\JCondori\\catalogo.txt"), true);
            PrintWriter print_line = new PrintWriter(write);
            int i = 0;
            while (1 <= 5) {
                i++;
                print_line.println("Hola");
            }
//            print_line.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
