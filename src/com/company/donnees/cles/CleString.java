package com.company.donnees.cles;

import com.company.exceptions.ExceptionConversionImpossible;


/**
 * Class permettant de gérer les Cles de chaine de caractere
 */
public class CleString implements Cle{

    private String identifiant = "";


    public CleString(String identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * Renvoie la Cle de la class
     * @return
     * @throws ExceptionConversionImpossible
     */
    @Override
    public String asString() throws ExceptionConversionImpossible {
        return this.identifiant;
    }

    /**
     * Leve une exception si utilise
     * @return
     * @throws ExceptionConversionImpossible
     */
    @Override
    public Integer asInteger() throws ExceptionConversionImpossible {
        throw new ExceptionConversionImpossible();
    }
}
