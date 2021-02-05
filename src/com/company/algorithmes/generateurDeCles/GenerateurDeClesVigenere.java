package com.company.algorithmes.generateurDeCles;

import com.company.donnees.cles.Cle;
import com.company.donnees.cles.CleString;
import com.company.donnees.cles.Cles;
import com.company.utils.RandThings;

public class GenerateurDeClesVigenere implements GenerateurDeCles {

    private int tailleCle = 0;

    public GenerateurDeClesVigenere(int tailleCle) {
        this.tailleCle = tailleCle;
    }


    @Override
    public Cles genererClePublique() {
        return null;
    }

    /**
     * Méthode qui permet de générer une cle aleatoire
     * de la taille donnée uniquement comosée de lettre majuscule.
     * @return
     */
    @Override
    public Cles genererClePrivee() {
        Cles cles = new Cles();
        RandThings randThings = new RandThings();
        Cle clePrivee;
        String cle = randThings.RandString(this.tailleCle, 65, 90);

        clePrivee = new CleString(cle);
        cles.addCle("cleVigenere", clePrivee);


        return cles;
    }
}
