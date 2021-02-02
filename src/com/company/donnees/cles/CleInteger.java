package com.company.donnees.cles;

import com.company.exceptions.ExceptionConversionImpossible;
import jdk.jshell.spi.ExecutionControl;

public class CleInteger implements Cle {

    private Integer cle = 0;

    public CleInteger(Integer cle) {
        this.cle = cle;
    }

    public String asString() throws ExceptionConversionImpossible{
        try {
            return String.valueOf(this.cle);
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }

    public Integer asInteger() throws ExceptionConversionImpossible {
        try {
            return Integer.valueOf(this.cle);
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }
}
