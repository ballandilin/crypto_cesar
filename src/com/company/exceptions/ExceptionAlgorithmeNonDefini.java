package com.company.exceptions;

/**
 * Class gérant les exceptions en rapport avec l'algorithme
 */
public class ExceptionAlgorithmeNonDefini extends ExceptionCryptographie {


    public ExceptionAlgorithmeNonDefini() {
        super("ErreurAlgorithme", "L'algorithme n'est pas defini");
    }

}
