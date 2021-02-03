package com.company.exceptions;


/**
 * Class gérant les exceptions de conversions
 */
public class ExceptionConversionImpossible extends ExceptionCryptographie {

    public ExceptionConversionImpossible() {
        super("ErreurConversion", "Conversion impossible");
    }
}
