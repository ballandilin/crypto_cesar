package com.company.algorithmes.chiffrement;

import com.company.algorithmes.chiffrement.algorithmetransposition.ComparateurCouple;
import com.company.algorithmes.chiffrement.algorithmetransposition.Couple;
import com.company.donnees.cles.Cle;
import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import com.company.exceptions.ExceptionChiffrementImpossible;
import com.company.exceptions.ExceptionConversionImpossible;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class AlgorithmeTransposition implements Algorithme{

    private SecureRandom generateur = new SecureRandom();

    /**
     * Methode permettant de chiffrer un message par transposition
     * @param message
     * @param clesPubliques
     * @param clesPrivees
     * @return
     * @throws ExceptionChiffrementImpossible
     */
    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        try {
            char [][] tableauChiffrement = this.remplirTableauChiffrement(message, clesPrivees.getCle("cleTransposition"));
            String res = "";
            ArrayList<Integer> ordre = getOrdreColonne(clesPrivees.getCle("cleTransposition"));

            // on lit le tableau colonnes par colonnes suivant l'ordre obtenue et on le stock dans une variable
            for (int index : ordre) {
                for (int j = 0; j < (tableauChiffrement.length); j++) {
                    res += tableauChiffrement[j][index];
                }
            }
            return new MessageString(res);
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }


    /**
     * Methode permettant de dechiffrer un message chiffrer par transposition
     * @param message
     * @param clesPubliques
     * @param clesPrivees
     * @return
     * @throws ExceptionChiffrementImpossible
     */
    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        try {
            char [][] tableauChiffrement = this.remplirTableauChiffrement(message, clesPrivees.getCle("cleTransposition"));
            char[] msg = message.asString().toCharArray();
            String res = "";
            ArrayList<Integer> ordre = getOrdreColonne(clesPrivees.getCle("cleTransposition"));
            int indexMsg = 0;


            // on remplit le tableau avec le message reçu, colonne par
            //colonne, dans l’ordre obtenu avec la methode
            // getOrdreColonne
            for (int index : ordre) {
                for (int j = 0; j < (tableauChiffrement.length); j++) {
                    tableauChiffrement[j][index] = msg[indexMsg++];
                }
            }

            // on lit le tableau ligne a ligne pour obtenir le message déchiffré
            for (int i = 0; i < tableauChiffrement.length; i++) {
                for (int j = 0; j < (tableauChiffrement[0].length); j++) {
                    res += tableauChiffrement[i][j];
                }
            }

            return new MessageString(res);
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    @Override
    public String getNom() {
        return "AlgorithmeTransposition";
    }


    // ############################ Methode privée #########################################

    /**
     * Permet de crée un tableau de
     * caractères de la bonne taille et dele remplir avec le message.
     * @param message
     * @param cle
     * @return tableau
     * @throws ExceptionConversionImpossible
     */
    private char[][] remplirTableauChiffrement(Message message, Cle cle) throws ExceptionConversionImpossible {

        ByteBuffer b = ByteBuffer.allocate(4) ;
        b.putInt((cle.asString()+message.asString()).hashCode()) ;
        this.generateur = new SecureRandom (b.array()) ;


        int tailleCle = cle.asString().length();
        int tailleMsg = message.asString().length();
        int nbLignes = (int) Math.ceil((double)tailleMsg/(double)tailleCle);
        int nbCol = tailleCle;
        char[][] tableau = new char[nbLignes][nbCol];
        int decalage = 0;
        char[] msg = message.asString().toCharArray();

        tableau = remplirTableauChar(tableau);

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbCol; j++) {
                if (decalage < tailleMsg) {
                    tableau[i][j] = msg[decalage];
                    decalage++;
                }
            }
        }


        return tableau;
    }

    /**
     * Renvoie l’ordre dans lequel lire les colonnes d’après la clé donnée en
     * paramètre sous forme d’une liste d’entiers.
     * @param cle
     * @return ordre
     * @throws ExceptionConversionImpossible
     */
    private ArrayList<Integer> getOrdreColonne(Cle cle) throws ExceptionConversionImpossible {
        ArrayList<Couple> listeCouple = new ArrayList<>();
        ArrayList<Integer> ordre = new ArrayList<>();
        char[] cleArray = cle.asString().toCharArray();
        int index = 0;


        for (char letter : cleArray) {
            listeCouple.add(new Couple(letter, index++));
        }

        Collections.sort(listeCouple, new ComparateurCouple());

        for (Couple c : listeCouple) {
            ordre.add(c.getPosition());
        }

        return ordre;
    }

    /**
     * Permet de générer aleatoirement un caractere de bourrage.
     * Le caractere se situe entre a..z et A..Z
     * @return un caractere
     */
    private char bourrage() {
        int min = 65; // lettre 'A'
        int max = 122; // lettre 'z'
        int tailleString = 1; // un seul caractere

        // l'utilisation de filter permet de ne recuperer que les caracteres que l'on souhaite
        String generateRandString = this.generateur.ints(min, max + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(tailleString)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        // c'est pas incroyable
        return generateRandString.toCharArray()[0];
    }

    /**
     * Permet de remplir le tableau avec des caracteres de bourrage
     * @param tableau
     * @return
     */
    private char[][] remplirTableauChar(char[][] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < (tableau[0].length); j++) {
                tableau[i][j] = this.bourrage();
            }
        }
        return tableau;
    }
}
