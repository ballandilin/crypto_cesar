package com.company.protocoles;

import com.company.algorithmes.chiffrement.AlgorithmeCesar;
import com.company.algorithmes.generateurDeCles.GenerateurDeClesCesar;
import com.company.donnees.cles.Cle;
import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import com.company.entites.Personne;
import com.company.entites.Univers;
import com.company.exceptions.ExceptionAlgorithmeNonDefini;
import com.company.exceptions.ExceptionConversionImpossible;


/**
 * Class permettant de gérer le cryptogramme de Cesar
 */
public class ProtocoleCesar implements Protocole {

    private Personne alice = new Personne("Alice");
    private Personne bob = new Personne("Bob");
    private GenerateurDeClesCesar genClesPrivees = new GenerateurDeClesCesar();
    private AlgorithmeCesar algoCesar = new AlgorithmeCesar();
    private Univers univers = new Univers();
    private Cles clePrivee = new Cles();
    private Message messageAlice = null;
    private Message messageBob = null;


    @Override
    public void executer() {
        System.out.println("##################################################################");
        System.out.println("################### Protocole Cesar ##############################");
        System.out.println("##################################################################");
        System.out.println();

        messageAlice = new MessageString("J'ai un peu galéré quand même");

        // assignation des Algos
        alice.setAlgorithme(algoCesar);
        bob.setAlgorithme(algoCesar);

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

            System.out.println("Message déchiffré de Bob : " + messageBob.asString()  + "\n");

        } catch (ExceptionAlgorithmeNonDefini | ExceptionConversionImpossible exceptionAlgorithmeNonDefini) {
            exceptionAlgorithmeNonDefini.printStackTrace();
        }
    }
}
