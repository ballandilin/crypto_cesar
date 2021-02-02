package com.company.exceptions;

public class ExceptionConversionImpossible extends ExceptionCryptographie {
    public ExceptionConversionImpossible() {
        super("ErreurConversion", "Conversion impossible");
    }
}
