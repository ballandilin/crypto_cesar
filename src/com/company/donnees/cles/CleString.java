package com.company.donnees.cles;

import com.company.exceptions.ExceptionConversionImpossible;

public class CleString implements Cle{

    private String identifiant = "";

    public CleString(String identifiant) {
        this.identifiant = identifiant;
    }

    @Override
    public String asString() throws ExceptionConversionImpossible {
        return this.identifiant;
    }

    @Override
    public Integer asInteger() throws ExceptionConversionImpossible {
        throw new ExceptionConversionImpossible();
    }
}
