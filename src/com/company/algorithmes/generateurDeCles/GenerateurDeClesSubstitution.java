package com.company.algorithmes.generateurDeCles;

import com.company.donnees.cles.Cle;
import com.company.donnees.cles.CleString;
import com.company.donnees.cles.Cles;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GenerateurDeClesSubstitution implements GenerateurDeCles{

    private SecureRandom generateur = new SecureRandom();

    @Override
    public Cles genererClePublique() {
        return null;
    }

    @Override
    public Cles genererClePrivee() {
        Cles cles = new Cles();
        Cle clePrivee;
        ArrayList<Character> alphabet = new ArrayList<>();
        String alphaString = "";


        for (int i = 65; i < 91; i++) {
            alphabet.add((char)i);
        }

        Collections.shuffle(alphabet, this.generateur);

        for (char l : alphabet) {
            alphaString += l;
        }

        clePrivee = new CleString(alphaString);
        cles.addCle("cleSubstitution", clePrivee);
        return cles;
    }
}
