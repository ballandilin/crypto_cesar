package com.company.exceptions;

import com.company.algorithmes.chiffrement.Algorithme;

/**
 * Class gérant les Exceptions en rapport avec les chiffrements
 */
public class ExceptionChiffrementImpossible extends ExceptionCryptographie {

    public ExceptionChiffrementImpossible() {
        super("ErreurChiffrement", "Chiffrement impossible");
    }
}
