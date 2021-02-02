package com.company.donnees.messages;

import com.company.exceptions.ExceptionConversionImpossible;

import java.util.ArrayList;

public class MessageString implements Message {

    private String message = "";

    public MessageString(String message) {
        this.message = message;
    }

    public String asString() throws ExceptionConversionImpossible{
        try {
            return String.valueOf(this.message);
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }

    public Integer asInteger() throws ExceptionConversionImpossible{
        try {
            return Integer.valueOf(this.message);
        } catch (Exception e) {
            throw new ExceptionConversionImpossible();
        }
    }

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
