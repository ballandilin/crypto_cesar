package com.company.algorithmes.chiffrement;

import com.company.donnees.cles.Cle;
import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.exceptions.ExceptionChiffrementImpossible;
import com.company.exceptions.ExceptionConversionImpossible;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AlgorithmeTransposition implements Algorithme{

    private SecureRandom generateur = new SecureRandom();

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        return null;
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        return null;
    }

    @Override
    public String getNom() {
        return null;
    }

    private char[][] remplirTableauChiffrement(Message message, Cle cle) throws ExceptionConversionImpossible {
        int tailleCle = cle.asString().length();
        int tailleMsg = message.asString().length();
        int nbLignes = (int) Math.ceil((float)tailleMsg/(float)tailleCle);
        int nbCol = tailleCle;
        char[][] tableau = new char[nbLignes][nbCol];
        int decalage = 0;
        char[] msg = message.asString().toCharArray();

        ByteBuffer b = ByteBuffer.allocate(4) ;
        b.putInt((cle.asString()+message.asString()).hashCode()) ;
        this.generateur = new SecureRandom (b.array()) ;

        tableau = remplirTableauChar(tableau);

        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < (tableau[0].length); j++) {
                if (decalage < tailleMsg) {
                    tableau[i][j] = msg[decalage];
                    decalage++;
                }
            }
        }

        return tableau;
    }

    private ArrayList<Integer> getOrdreColonne(Cle cle) throws ExceptionConversionImpossible {
        ArrayList<Integer> ordre = new ArrayList<>();
        

        return null;
    }

    private char bourrage() {
        int leftLimit = 65; // lettre 'A'
        int rightLimit = 122; // lettre 'z'
        int targetStringLength = 1;
        Random random = new Random();

        String generateRandChar = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generateRandChar.toCharArray()[0];
    }

    private char[][] remplirTableauChar(char[][] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < (tableau[0].length); j++) {
                tableau[i][j] = this.bourrage();
            }
        }
        return tableau;
    }
}
