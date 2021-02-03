package com.company.entites;

import com.company.algorithmes.chiffrement.Algorithme;
import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.exceptions.ExceptionAlgorithmeNonDefini;

public class Personne {

    private String nom = "";
    private Algorithme algorithme = null;
    private Cles clesPrivees = null;

    public Personne(String nom) {
        this.nom = nom;
    }

    /**
     * Renvoie le résultat de la méthode homonyme de l'algorithme dont dispose la personne
     * @param message
     * @param clesPubliques
     * @return Le message chiffrer
     * @throws ExceptionAlgorithmeNonDefini
     */
    public Message chiffrer(Message message, Cles clesPubliques) throws ExceptionAlgorithmeNonDefini {
        try {
            return algorithme.chiffrer(message, clesPubliques, this.clesPrivees);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Renvoie le résultat de la méthode homonyme de l'algorithme dont dispose la personne
     * @param message
     * @param clesPubliques
     * @return Le message dechiffrer
     * @throws ExceptionAlgorithmeNonDefini
     */
    public Message dechiffrer(Message message, Cles clesPubliques) throws ExceptionAlgorithmeNonDefini {
        try {
            return algorithme.dechiffrer(message, clesPubliques, this.clesPrivees);
        } catch (Exception e) {
            System.out.println(e);
        }
        return message;
    }

//*******************  Setter et Getter *******************

    public String getNom() {
        return nom;
    }


    public Algorithme getAlgorithme() {
        return algorithme;
    }

    public void setAlgorithme(Algorithme algorithme) {
        this.algorithme = algorithme;
    }


    public Cles getClesPrivees() {
        return clesPrivees;
    }

    public void setClesPrivees(Cles clesPrivees) {
        this.clesPrivees = clesPrivees;
    }

}
