package com.company.algorithmes.chiffrement;

import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import com.company.exceptions.ExceptionChiffrementImpossible;

import static java.lang.Math.abs;

public class AlgorithmeCesar implements Algorithme{
    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        Message cryptedMsg = null;
        String strCryptedMsg = "";
        char cryptLetter;

        try {

            for (int letter : message.getListAsciiCode()) {
                char currentLetter = (char)letter;

                if((currentLetter >= 'a') && (currentLetter <= 'z')) {
                    currentLetter -= 'a';
                    cryptLetter = (char) ((currentLetter + clesPrivees.getCle("cleCesar").asInteger()) % 26);
                    cryptLetter += 'a';
                } else if((currentLetter >= 'A') && (currentLetter <= 'Z')) {
                    currentLetter -= 'A';
                    cryptLetter = (char) ((currentLetter + clesPrivees.getCle("cleCesar").asInteger()) % 26);
                    cryptLetter += 'A';
                } else {
                    cryptLetter = currentLetter;
                }


                strCryptedMsg += cryptLetter;


            }

            cryptedMsg = new MessageString(strCryptedMsg);
            return cryptedMsg;


        } catch (Exception e) {
            throw new ExceptionChiffrementImpossible();
        }
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        Message decryptedMsg = null;
        String strDecryptedMsg = "";
        char decryptLetter = 0;
        char currentLetter = 0;

        try {

            for (int letter : message.getListAsciiCode()) {
                currentLetter = (char)(letter);

                if((currentLetter >= 'a') && (currentLetter <= 'z')) {
                    currentLetter -= 'a';
                    decryptLetter = (char) ((currentLetter - clesPrivees.getCle("cleCesar").asInteger()));
                    decryptLetter += 'a';
                    if ((int)decryptLetter < 97 || (int)decryptLetter > 122) {
                        decryptLetter += 26;
                    }


                } else if((currentLetter >= 'A') && (currentLetter <= 'Z')) {
                    currentLetter -= 'A';
                    decryptLetter = (char) ((currentLetter - clesPrivees.getCle("cleCesar").asInteger()) % 26);
                    decryptLetter += 'A';
                    if ((int)decryptLetter < 65 || (int)decryptLetter > 90) {
                        decryptLetter += 26;
                    }
                } else {
                    decryptLetter = currentLetter;
                }

                strDecryptedMsg += decryptLetter;
            }

            decryptedMsg = new MessageString(strDecryptedMsg);
            return decryptedMsg;


        } catch (Exception e) {
            throw new ExceptionChiffrementImpossible();
        }
    }


    @Override
    public String getNom() {
        return null;
    }
}
