package com.company.TestMoteur.algorithmes.chiffrement;

import com.company.algorithmes.chiffrement.Algorithme;
import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import com.company.exceptions.ExceptionChiffrementImpossible;

/**
 * Description de la classe
 * @author Matthieu
 */
public class AlgorithmeFake implements Algorithme {

    @Override
    public String getNom() {
        return "Algorithme de Test";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        return new MessageString("Chiffre");
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        return new MessageString("Dechiffre");
    }

}
