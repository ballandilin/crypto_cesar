package com.company.algorithmes.chiffrement;

import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import com.company.exceptions.ExceptionChiffrementImpossible;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmeSubstitution implements Algorithme{

    /**
     * Methode permettant de chiffrer un message par substitution
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
            char[] cleArray = clesPrivees.getCle("cleSubstitution").asString().toCharArray();
            char[] msgArray = message.asString().toUpperCase().toCharArray();
            String res = "";
            Message msgChiffrer;
            char currentLetter;
            Map<Character, Character> map = new HashMap<>();

            // on creer une MAP pour associer les lettres ensembles
            for (int i = 65; i < 91; i++) {
                map.put((char)i, cleArray[i-65]);
            }

            for (int i = 0; i < msgLength; i++) {

                currentLetter = msgArray[i];

                if((currentLetter >= 'A') && (currentLetter <= 'Z')) {
                    decalage = map.get(msgArray[i]);
                } else {
                    decalage = currentLetter;
                }

                res += (char)(decalage);

            }
            msgChiffrer = new MessageString(res);
            return msgChiffrer;

        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Methode permettant de dechiffrer un message chiffrer par substition
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
            char[] cleArray = clesPrivees.getCle("cleSubstitution").asString().toCharArray();
            char[] msgArray = message.asString().toUpperCase().toCharArray();
            String res = "";
            Message msgChiffrer;
            char currentLetter;
            Map<Character, Character> map = new HashMap<>();

            // on creer une MAP pour associer les lettres ensembles
            for (int i = 65; i < 91; i++) {
                map.put(cleArray[i-65], (char)i);
            }

            for (int i = 0; i < msgLength; i++) {

                currentLetter = msgArray[i];

                if((currentLetter >= 'A') && (currentLetter <= 'Z')) {
                    decalage = map.get(msgArray[i]);
                } else {
                    decalage = currentLetter;
                }

                res += (char)(decalage);

            }
            msgChiffrer = new MessageString(res);
            return msgChiffrer;

        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String getNom() {
        return null;
    }
}
