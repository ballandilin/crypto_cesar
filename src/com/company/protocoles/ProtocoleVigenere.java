package com.company.protocoles;

import com.company.algorithmes.chiffrement.AlgorithmeTransposition;
import com.company.algorithmes.generateurDeCles.GenerateurDeClesTransposition;
import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import com.company.entites.Personne;
import com.company.entites.Univers;
import com.company.exceptions.ExceptionAlgorithmeNonDefini;
import com.company.exceptions.ExceptionConversionImpossible;

public class ProtocoleVigenere implements Protocole{


    private Personne alice = new Personne("Alice");
    private Personne bob = new Personne("Bob");
    private GenerateurDeClesTransposition genClesPrivees = new GenerateurDeClesTransposition(10);
    private AlgorithmeTransposition algoTransposition = new AlgorithmeTransposition();
    private Univers univers = new Univers();
    private Cles clePrivee = new Cles();
    private Message messageAlice = null;
    private Message messageBob = null;


    @Override
    public void executer() {
        System.out.println("##################################################################");
        System.out.println("###############Protocole Transposition ###########################");
        System.out.println("##################################################################");


        messageAlice = new MessageString("J'ai un peu galéré quand même, mais se fut drole?!");

        // assignation des Algos
        alice.setAlgorithme(algoTransposition);
        bob.setAlgorithme(algoTransposition);

        // attribution des Cles Privees
        clePrivee = genClesPrivees.genererClePrivee();
        alice.setClesPrivees(clePrivee);
        bob.setClesPrivees(clePrivee);

        try {
            System.out.println("Message clair de Alice : " + messageAlice.asString() + "\n");
            messageAlice = alice.chiffrer(messageAlice, null);
            univers.addMessage("iden", messageAlice);
            messageBob = bob.dechiffrer(univers.getMessage("iden"), null);

            System.out.println("Message chiffré de Alice : " + messageAlice.asString() + "\n");

            System.out.println("Message déchiffré de Bob : " + messageBob.asString() + "\n");

        } catch (ExceptionAlgorithmeNonDefini | ExceptionConversionImpossible exceptionAlgorithmeNonDefini) {
            exceptionAlgorithmeNonDefini.printStackTrace();
        }
    }

}
