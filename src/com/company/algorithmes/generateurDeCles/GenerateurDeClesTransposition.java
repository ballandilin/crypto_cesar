package com.company.algorithmes.generateurDeCles;

import com.company.donnees.cles.Cle;
import com.company.donnees.cles.CleString;
import com.company.donnees.cles.Cles;

import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class GenerateurDeClesTransposition implements GenerateurDeCles{

    private int tailleId = 0;
    private SecureRandom generateur = new SecureRandom();

    public GenerateurDeClesTransposition(int tailleId) {
        this.tailleId = tailleId;
    }

    @Override
    public Cles genererClePublique() {
        return null;
    }

    @Override
    public Cles genererClePrivee() {
        Cle cle = new CleString(this.RandString());
        Cles cles = new Cles();

        cles.addCle("cleTransposition", cle);


        return cles;
    }

    private String RandString() {
        int leftLimit = 65; // lettre 'A'
        int rightLimit = 122; // lettre 'z'
        int tailleString = this.tailleId;

        String generateRandChar = this.generateur.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(tailleString)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        return generateRandChar;
    }
}
