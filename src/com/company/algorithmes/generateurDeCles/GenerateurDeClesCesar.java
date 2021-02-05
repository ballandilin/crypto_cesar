package com.company.algorithmes.generateurDeCles;

import com.company.donnees.cles.CleInteger;
import com.company.donnees.cles.Cles;
import com.company.utils.RandThings;


/**
 * Class implementant l'interface GenerateurDeCles,
 * elle permet de générer une Cle Publique ou une Cle Privee
 * pour l'algorithme de Cesar
 */
public class GenerateurDeClesCesar implements GenerateurDeCles{

    private Integer randNum = 0;

    public GenerateurDeClesCesar() {
        this.randNum = new RandThings().getRandomNumberInRange(0, 25);
        System.out.println(this.randNum);
    }


    /**
     * Pas implementé
     * @return null
     */
    public Cles genererClePublique() {
        return null;
    }

    /**
     * Renvoie une Cles privée generé par un nombre aléatoire
     * @return cle
     */
    public Cles genererClePrivee() {
        Cles cle = new Cles();

        cle.addCle("cleCesar", new CleInteger(this.randNum));

        return cle;
    }
}
