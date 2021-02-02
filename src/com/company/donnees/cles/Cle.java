package com.company.donnees.cles;

import com.company.exceptions.ExceptionConversionImpossible;

public interface Cle {

    String asString() throws ExceptionConversionImpossible;
    Integer asInteger() throws ExceptionConversionImpossible;
}
