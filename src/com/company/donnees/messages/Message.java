package com.company.donnees.messages;

import com.company.exceptions.ExceptionConversionImpossible;

import java.util.ArrayList;

/**
 * Interface Permettant d'implementer un Message
 */
public interface Message {
    String asString() throws ExceptionConversionImpossible;
    Integer asInteger() throws ExceptionConversionImpossible;
    ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible;
}
