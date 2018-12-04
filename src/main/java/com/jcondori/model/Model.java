package com.jcondori.model;

import lombok.Data;

@Data
public class Model {
    private String Campo1;
    private String Campo2;
    private String Campo3;
    private String Campo4;
    private String Campo5;
    private String Campo6;
    private String Campo7;
    private String Campo8;
    private String Campo9;

    public Model() {
    }

    public Model(String campo1, String campo2, String campo3, String campo4, String campo5, String campo6, String campo7, String campo8, String campo9) {
        Campo1 = campo1;
        Campo2 = campo2;
        Campo3 = campo3;
        Campo4 = campo4;
        Campo5 = campo5;
        Campo6 = campo6;
        Campo7 = campo7;
        Campo8 = campo8;
        Campo9 = campo9;
    }
}
