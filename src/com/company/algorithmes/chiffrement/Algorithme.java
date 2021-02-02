package com.company.algorithmes.chiffrement;

import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.exceptions.ExceptionChiffrementImpossible;


public interface Algorithme {
    String nom = "";

    Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible;
    Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible;
    String getNom();

}
