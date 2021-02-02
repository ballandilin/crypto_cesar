package com.company.exceptions;

import com.company.algorithmes.chiffrement.Algorithme;

public class ExceptionChiffrementImpossible extends ExceptionCryptographie {

    public ExceptionChiffrementImpossible() {
        super("ErreurChiffrement", "Chiffrement impossible");
    }
}
