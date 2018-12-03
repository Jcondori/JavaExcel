package com.jcondori.xlsx;

import java.io.File;

import org.zeroturnaround.zip.ZipUtil;

public class comprimir {

    public static String origen = "C:\\Users\\JCondori\\Documents\\NetBeansProjects\\Demo".replace("\\", "/");

    public static void main(String[] args) {

        ZipUtil.pack(new File(origen), new File("C:\\Users\\JCondori\\Desktop\\demo.zip".replace("\\", "/")));
//        ZipUtil.unexplode(new File(origen + ".zip"));

    }

}
