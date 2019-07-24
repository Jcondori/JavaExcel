package com.jcondori.Dao;

import com.jcondori.model.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reporte extends Dao {

    public List<Model> listarReporte() throws SQLException {
        this.Conexion();
        List<Model> lista;
        ResultSet rs;
        try {
            String sql = "SELECT\n" +
                    "  alumno.cod_alum,\n" +
                    "  alumno.ape_alum,\n" +
                    "  alumno.nom_alum,\n" +
                    "  CASE when alumno.ingr_alum is null then '-' else alumno.ingr_alum END AS ingr_alum,\n" +
                    "  nucleos.codnt,\n" +
                    "  to_char(asistencia.fch_dia,'DD/MM/YYYY') as fch_dia,\n" +
                    "  (\n" +
                    "    CASE asistencia.dendia\n" +
                    "      WHEN 'A'   THEN 'ASISTENCIA'\n" +
                    "      WHEN 'I'   THEN 'FALTA'\n" +
                    "      WHEN 'J'   THEN 'JUSTIFICACIÓN'\n" +
                    "      WHEN 'F'   THEN 'FERIADO'\n" +
                    "      ELSE 'SIN ASISTENCIA'\n" +
                    "      END\n" +
                    "    ) AS dendia,\n" +
                    "  responsable.NOM_RES,\n" +
                    "  empresa.NOM_EMP\n" +
                    "FROM\n" +
                    "  ALTERNANCIA\n" +
                    "    INNER JOIN ALTERNANCIA_DETALLE ON ALTERNANCIA_DETALLE.CODALT = ALTERNANCIA.CODALT\n" +
                    "    INNER JOIN ASISTENCIA ON ASISTENCIA.CODALTDET = ALTERNANCIA_DETALLE.CODALTDET\n" +
                    "    INNER JOIN ALUMNO ON ALUMNO.COD_ALUM = ALTERNANCIA_DETALLE.COD_ALUM\n" +
                    "    INNER JOIN AULA ON AULA.COD_AULA = ALTERNANCIA.COD_AULA\n" +
                    "    INNER JOIN NUCLEOS ON NUCLEOS.CODNUC = ALTERNANCIA.CODNUC\n" +
                    "    INNER JOIN responsable ON responsable.cod_res = alternancia_detalle.cod_res\n" +
                    "    INNER JOIN empresa ON responsable.cod_emp = empresa.cod_emp\n" +
                    "WHERE\n" +
                    "    alternancia.cod_aula = 20\n" +
                    "    AND '[CI08]' LIKE ('%' || NUCLEOS.CODNT || '%')\n" +
                    "ORDER BY alumno.APE_ALUM , asistencia.FCH_DIA";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new Model(
                        rs.getString("cod_alum"),
                        rs.getString("ape_alum"),
                        rs.getString("nom_alum"),
                        rs.getString("ingr_alum"),
                        rs.getString("codnt"),
                        rs.getString("fch_dia"),
                        rs.getString("dendia"),
                        rs.getString("NOM_RES"),
                        rs.getString("NOM_EMP")
                ));
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

}
