package com.company.donnees.messages;

import com.company.exceptions.ExceptionConversionImpossible;

import java.util.ArrayList;

/**
 * Class gérant la version ASCII du Message implementant l'interface Message
 */
public class MessageASCII implements Message{

    private ArrayList<Integer> message = new ArrayList<Integer>();

    public MessageASCII(ArrayList<Integer> message) {
        this.message = message;
    }


    /**
     * Renvoie le message ASCII en chaine de caractere si possible
     * @return le message ASCII en chaine de caractere
     * @throws ExceptionConversionImpossible
     */
    @Override
    public String asString() throws ExceptionConversionImpossible{
        try {
            String msg = "";
            
            for (int ascii : this.message) {
                msg += ((char)ascii);
            }
            return msg;
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }

    /**
     * Renvoie le message ASCII sous la forme d'un entier si possible
     * @return le message en entier
     * @throws ExceptionConversionImpossible
     */
    @Override
    public Integer asInteger() throws ExceptionConversionImpossible{
        try {
            return Integer.valueOf(this.message.toString());
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }

    /**
     * Renvoie le Message ASCII de la class
     * @return
     * @throws ExceptionConversionImpossible
     */
    @Override
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible {
        return this.message;
    }

}