package com.company.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Class permettant de renvoyer un nombre aleatoire entre un minimum et un maximum
 */
public class RandThings {

    private SecureRandom generateur = new SecureRandom();

    public int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max dois etre plus grand que min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Renvoie une chaine de caractere contenant les caractere
     * de a..z et A..Z
     * @return generateRandString
     */
    public String RandString(int taille, int min, int max) {
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
