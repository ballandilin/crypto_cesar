package com.company.algorithmes.chiffrement;

import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import com.company.exceptions.ExceptionChiffrementImpossible;

public class AlgorithmeCesar implements Algorithme{
    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        Message cryptedMsg = null;
        String strCryptedMsg = "";
        int decalage = 0;
        int decalageBis = 0;

        try {
            for (int letter : message.getListAsciiCode()) {
                decalage = letter + clesPrivees.getCle("cleCesar").asInteger();
                decalageBis = decalage;
                decalage = letter == 32?letter:decalage;

                if (decalage >= 127) {
                    decalage %= 127;
                }

                System.out.print(letter + " -> ");
                System.out.println(decalage);


                strCryptedMsg += (char)(decalage);
            }

            cryptedMsg = new MessageString(strCryptedMsg);
            return cryptedMsg;
        } catch (Exception e) {
            throw new ExceptionChiffrementImpossible();
        }
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        return null;
    }

    @Override
    public String getNom() {
        return null;
    }
}
