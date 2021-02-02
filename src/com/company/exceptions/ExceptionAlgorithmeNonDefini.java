package com.company.exceptions;

public class ExceptionAlgorithmeNonDefini extends ExceptionCryptographie {

    public ExceptionAlgorithmeNonDefini() {
        super("ErreurAlgorithme", "L'algorithme n'est pas defini");
    }

}
