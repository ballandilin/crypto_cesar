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

public class ProtocoleCesar implements Protocole {

    private Personne alice = new Personne("Alice");
    private Personne bob = new Personne("Bob");
    private GenerateurDeClesCesar genClesPrivees = new GenerateurDeClesCesar();
    private AlgorithmeCesar algoCesar = new AlgorithmeCesar();
    private Univers uni = new Univers();
    private Cles clePublique = new Cles();
    private Message messageAlice = null;

    public ProtocoleCesar() throws ExceptionAlgorithmeNonDefini {
        messageAlice = new MessageString("J'ai un peu galéré quand même");
        clePublique.addCle("test", (Cle)genClesPrivees.genererClePublique());

        // assignation des Algos
        alice.setAlgorithme(algoCesar);
        bob.setAlgorithme(algoCesar);

        // attribution des Cles Privees
        alice.setClesPrivees(genClesPrivees.genererClePrivee());
        bob.setClesPrivees(genClesPrivees.genererClePrivee());

        alice.chiffrer(messageAlice, clePublique);


    }

    @Override
    public void executer() {

    }
}
