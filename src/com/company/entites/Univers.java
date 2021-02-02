package com.company.entites;

import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;

import java.util.HashMap;

public final class Univers {

    private static HashMap<String, Cles> listeClesPubliques = new HashMap<String, Cles>();
    private static HashMap<String, Message> listeMessagesPublics = new HashMap<String, Message>();
    private static Univers instance = new Univers();

    public Univers() {}

    public static Univers get() {
        return instance;
    }

    public static void addCles(String identifiant, Cles cles) {
        listeClesPubliques.put(identifiant, cles);
    }

    public static Cles getCles(String identifiant) {

        return listeClesPubliques.get(identifiant);
    }

    public static void addMessage(String identifiant, Message message) {
        listeMessagesPublics.put(identifiant, message);
    }

    public static Message getMessage(String identifiant) {
        return listeMessagesPublics.get(identifiant);
    }
}
