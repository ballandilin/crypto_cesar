package com.company.donnees.messages;

import com.company.exceptions.ExceptionConversionImpossible;

import java.util.ArrayList;

public class MessageASCII implements Message{

    private ArrayList<Integer> message = new ArrayList<Integer>();

    public MessageASCII(ArrayList<Integer> message) {
        this.message = message;
    }

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

    @Override
    public Integer asInteger() throws ExceptionConversionImpossible{
        try {
            return Integer.valueOf(this.message.toString());
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }

    @Override
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible {
        return this.message;
    }

}