package com.company.donnees.cles;

import com.company.exceptions.ExceptionConversionImpossible;
import jdk.jshell.spi.ExecutionControl;


/**
 * Class permettant de gérer les Cles d'entier
 */
public class CleInteger implements Cle {

    private Integer cle = 0;

    public CleInteger(Integer cle) {
        this.cle = cle;
    }

    /**
     * Renvoie la Cle en chaine de caractere
     * @return
     * @throws ExceptionConversionImpossible
     */
    public String asString() throws ExceptionConversionImpossible{
        try {
            return String.valueOf(this.cle);
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }

    /**
     * Renvoie la Cle sous la forme d'un entier
     * @return
     * @throws ExceptionConversionImpossible
     */
    public Integer asInteger() throws ExceptionConversionImpossible {
        try {
            return Integer.valueOf(this.cle);
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }
}
