package com.company.exceptions;


/**
 * Class gérant les exceptions de Cryptographies
 */
public abstract class ExceptionCryptographie extends Exception {
    private String nom = "";
    private String message = "";


    public ExceptionCryptographie(String nom, String message) {
        this.nom = nom;
        this.message = message;
    }

    public void gerer() {
        System.out.println(System.err + ":" + this.message);
        this.printStackTrace(System.err);
    }
}
