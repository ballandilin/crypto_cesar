package com.company.algorithmes.generateurDeCles;

import com.company.donnees.cles.Cle;
import com.company.donnees.cles.CleString;
import com.company.donnees.cles.Cles;

import java.nio.ByteBuffer;
import java.security.SecureRandom;


/**
 * Class implementant l'interface GenerateurDeCles,
 * elle permet de générer une Cle Publique ou une Cle Privee
 * pour l'algorithme de Transposition
 */
public class GenerateurDeClesTransposition implements GenerateurDeCles{

    private int tailleId = 0;
    private SecureRandom generateur = new SecureRandom();

    public GenerateurDeClesTransposition(int tailleId) {
        this.tailleId = tailleId;
    }

    /**
     * Pas encore implémenté
     * @return
     */
    @Override
    public Cles genererClePublique() {
        return null;
    }

    /**
     * Renvoie une Cles identider par une
     * chaine de caractere généré aleatoirement
     * @return cles
     */
    @Override
    public Cles genererClePrivee() {
        Cle cle = new CleString(this.RandString(this.tailleId));
        Cles cles = new Cles();

        cles.addCle("cleTransposition", cle);

        return cles;
    }


    /**
     * Renvoie une chaine de caractere contenant les caractere
     * de a..z et A..Z
     * @return generateRandString
     */
    private String RandString(int taille) {
        int min = 65; // lettre 'A'
        int max = 122; // lettre 'z'
        int tailleString = taille;

        // l'utilisation de filter permet de ne recuperer que les caracteres que l'on souhaite
        String generateRandString = this.generateur.ints(min, max + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(tailleString)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        return generateRandString;
    }
}
