
package com.jcondori.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    private Connection cn = null;

    public void Conexion() {
        try {
            if (cn == null) {
                Class.forName("oracle.jdbc.OracleDriver");
                cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Asistencias", "vallegrande2018");
//                cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SOA", "vallegrande2018");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
                cn = null;
            }
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public static void main(String[] args) {
        Dao dao = new Dao();
        dao.Conexion();
        if (dao.getCn() != null) {
            System.out.println("Conecto");
        } else {
            System.err.println("Error");
        }
    }
}
