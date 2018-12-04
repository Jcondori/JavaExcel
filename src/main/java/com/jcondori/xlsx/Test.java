package com.jcondori.xlsx;

import com.jcondori.Dao.Reporte;
import com.jcondori.model.Model;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws SQLException {
        ReporteAsistencia reporteAsistencia = new ReporteAsistencia();
        Reporte dao = new Reporte();

        List<Model> lista = dao.listarReporte();
        reporteAsistencia.generarReporte(lista);

    }

}
