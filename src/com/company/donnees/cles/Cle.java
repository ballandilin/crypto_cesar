package com.company.donnees.cles;

import com.company.exceptions.ExceptionConversionImpossible;


/**
 * Interface pour gérer les Cles
 */
public interface Cle {

    String asString() throws ExceptionConversionImpossible;
    Integer asInteger() throws ExceptionConversionImpossible;
}
