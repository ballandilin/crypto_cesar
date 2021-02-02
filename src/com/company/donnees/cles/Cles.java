package com.company.donnees.cles;

import java.util.HashMap;

public class Cles {

    private final HashMap<String, Cle> listeCles = new HashMap<>();

    public Cles() {}

    public Cle getCle(String nom) {
        return this.listeCles.get(nom);
    }

    public void addCle(String nom, Cle cle) {
        this.listeCles.put(nom, cle);
    }

}
