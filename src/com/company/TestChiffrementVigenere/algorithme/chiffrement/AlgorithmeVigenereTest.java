package com.company.TestChiffrementVigenere.algorithme.chiffrement;

import com.company.algorithmes.chiffrement.AlgorithmeVigenere;
import com.company.donnees.cles.CleString;
import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class AlgorithmeVigenereTest {

    @Test
    public void testChiffrer() throws Exception {
        System.out.println("Chiffrement de Vigenère");
        Message message = new MessageString("Bonjour, comment ca va ?");
        Cles clesPubliques = null;
        Cles clesPrivees = new Cles();
        CleString cle = new CleString("CHAT");
        clesPrivees.addCle("cleVigenere", cle);

        AlgorithmeVigenere instance = new AlgorithmeVigenere();
        String expResult = "DVNCQBR, JOFOLNM JA XH ?";

        String result = instance.chiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }

    /**
     * Test of dechiffrer method, of class AlgorithmeVigenere.
     */
    @Test
    public void testDechiffrer() throws Exception {
        System.out.println("Chiffrement de Vigenère");
        Message message = new MessageString("DVNCQBR, JOFOLNM JA XH ?");
        Cles clesPubliques = null;
        Cles clesPrivees = new Cles();
        CleString cle = new CleString("CHAT");
        clesPrivees.addCle("cleVigenere", cle);

        AlgorithmeVigenere instance = new AlgorithmeVigenere();
        String expResult = "BONJOUR, COMMENT CA VA ?";

        String result = instance.dechiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }

}
