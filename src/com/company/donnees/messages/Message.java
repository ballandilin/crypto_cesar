package com.company.donnees.messages;

import com.company.exceptions.ExceptionConversionImpossible;

import java.util.ArrayList;

public interface Message {
    String asString() throws ExceptionConversionImpossible;
    Integer asInteger() throws ExceptionConversionImpossible;
    ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible;
}
