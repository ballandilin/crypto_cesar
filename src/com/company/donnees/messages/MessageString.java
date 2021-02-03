package com.company.donnees.messages;

import com.company.exceptions.ExceptionConversionImpossible;

import java.util.ArrayList;


/**
 * Class implementant l'interface Message et gérant les Message en Chaine de caractere
 */
public class MessageString implements Message {

    private String message = "";

    public MessageString(String message) {
        this.message = message;
    }

    /**
     * Renvoie le message en chaine de caractere si possible
     * @return le message en chaine de caractere
     * @throws ExceptionConversionImpossible
     */
    public String asString() throws ExceptionConversionImpossible{
        try {
            return String.valueOf(this.message);
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }


    /**
     * Renvoie le message en entier si possible
     * @return le message en entier
     * @throws ExceptionConversionImpossible
     */
    public Integer asInteger() throws ExceptionConversionImpossible{
        try {
            return Integer.valueOf(this.message);
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }

    /**
     * Renvoie un tableau d'entier correspondant au caractere du message
     * @return tableau d'entier
     * @throws ExceptionConversionImpossible
     */
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible{
        try {
            ArrayList<Integer> asciiList = new ArrayList<Integer>();

            for (char letter : this.message.toCharArray()) {
                asciiList.add((int) (letter));
            }

            return asciiList;
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }
}
