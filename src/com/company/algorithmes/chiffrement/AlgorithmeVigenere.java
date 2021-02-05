package com.company.algorithmes.chiffrement;

import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import com.company.exceptions.ExceptionChiffrementImpossible;


public class AlgorithmeVigenere implements Algorithme{


    /**
     * Methode permettant de chiffrer un message avec la méthode de Vigenere
     * @param message
     * @param clesPubliques
     * @param clesPrivees
     * @return
     * @throws ExceptionChiffrementImpossible
     */
    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {

        try {
            int msgLength = message.asString().length();
            int decalage = 0;
            int tailleCle = clesPrivees.getCle("cleVigenere").asString().length();
            char[] cleArray = clesPrivees.getCle("cleVigenere").asString().toCharArray();
            char[] msgArray = message.asString().toUpperCase().toCharArray();
            String res = "";
            Message msgChiffrer;
            char currentLetter;

            for (int i = 0; i < msgLength; i++) {

                currentLetter = msgArray[i];

                if((currentLetter >= 'A') && (currentLetter <= 'Z')) {
                    decalage = (msgArray[i] + cleArray[i % tailleCle]) % 26;
                    decalage += 'A';
                } else {
                    decalage = currentLetter;
                }

                res += (char)(decalage);

            }

            msgChiffrer = new MessageString(res);
            return msgChiffrer;

        } catch (Exception e) {
            System.out.println(e);
        }

        return message;
    }


    /**
     * Methode permettant de dechiffrer un message chiffrer avec la méthode de Vigenere
     * @param message
     * @param clesPubliques
     * @param clesPrivees
     * @return
     * @throws ExceptionChiffrementImpossible
     */
    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        try {
            int msgLength = message.asString().length();
            int decalage = 0;
            int tailleCle = clesPrivees.getCle("cleVigenere").asString().length();
            char[] cleArray = clesPrivees.getCle("cleVigenere").asString().toCharArray();
            char[] msgArray = message.asString().toUpperCase().toCharArray();
            String res = "";
            Message msgChiffrer;
            char currentLetter;

            for (int i = 0; i < msgLength; i++) {

                currentLetter = msgArray[i];

                if((currentLetter >= 'A') && (currentLetter <= 'Z')) {
                    decalage = (msgArray[i] - cleArray[i % tailleCle] + 26) % 26;
                    decalage += 'A';
                } else {
                    decalage = currentLetter;
                }

                res += (char)(decalage);

            }

            msgChiffrer = new MessageString(res);
            return msgChiffrer;

        } catch (Exception e) {
            System.out.println(e);
        }

        return message;
    }

    @Override
    public String getNom() {
        return "AlgorithmeVigenere";
    }

}
