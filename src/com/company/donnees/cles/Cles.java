package com.company.donnees.cles;

import java.util.HashMap;


/**
 * Class permettant de gérer les Cles
 */
public class Cles {

    private final HashMap<String, Cle> listeCles = new HashMap<>();

    public Cles() {}

    /**
     * Renvoie la Cle associé a "nom"
     * @param nom
     * @return Cle associer a nom
     */
    public Cle getCle(String nom) {
        return this.listeCles.get(nom);
    }


    /**
     * Ajoute une Cle a la Hashmap de Cles
     * @param nom
     * @param cle
     */
    public void addCle(String nom, Cle cle) {
        this.listeCles.put(nom, cle);
    }

}
