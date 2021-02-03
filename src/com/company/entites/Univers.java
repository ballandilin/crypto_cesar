package com.company.entites;

import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;

import java.util.HashMap;

/**
 * L'univers des personnages permet de simuler l'envoie de message et de cles
 */
public class Univers {

    private static HashMap<String, Cles> listeClesPubliques = new HashMap<String, Cles>();
    private static HashMap<String, Message> listeMessagesPublics = new HashMap<String, Message>();
    private static Univers instance = new Univers();

    public Univers() {}

    /**
     * Recupere l'univers actuelle
     * @return
     */
    public static Univers get() {
        return instance;
    }

    /**
     * Ajoute une cle a l'univers
     * @param identifiant
     * @param cles
     */
    public static void addCles(String identifiant, Cles cles) {
        listeClesPubliques.put(identifiant, cles);
    }

    /**
     * Recupere la cle dans l'univers associer a l'identifiant
     * @param identifiant
     * @return
     */
    public static Cles getCles(String identifiant) {

        return listeClesPubliques.get(identifiant);
    }

    /**
     * Ajoute une message dans l'univers
     * @param identifiant
     * @param message
     */
    public static void addMessage(String identifiant, Message message) {
        listeMessagesPublics.put(identifiant, message);
    }

    /**
     * Recupere une message dans l'univers associer a un identifiant
     * @param identifiant
     * @return
     */
    public static Message getMessage(String identifiant) {
        return listeMessagesPublics.get(identifiant);
    }

}
