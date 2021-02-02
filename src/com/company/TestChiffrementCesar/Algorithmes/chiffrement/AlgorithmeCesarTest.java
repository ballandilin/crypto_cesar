package com.company.TestChiffrementCesar.Algorithmes.chiffrement;

import com.company.algorithmes.chiffrement.AlgorithmeCesar;
import com.company.donnees.cles.CleInteger;
import com.company.donnees.cles.Cles;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class AlgorithmeCesarTest {


    /**
     * Test of chiffrer method, of class AlgorithmeCesar.
     */
    @Test
    public void testChiffrer() throws Exception {
        System.out.println("Test de la méthode chiffrer");
        Message message = new MessageString("Bonjour comment CA va !");
        Cles clesPubliques = null;
        Cles clesPrivees = new Cles();
        clesPrivees.addCle("cleCesar", new CleInteger(10));
        AlgorithmeCesar instance = new AlgorithmeCesar();
        String expResult = "Lyxtyeb mywwoxd MK fk !";
        String result = instance.chiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }

    /**
     * Test of dechiffrer method, of class AlgorithmeCesar.
     */
    @Test
    public void testDechiffrer() throws Exception {
        System.out.println("Test de la méthode déchiffrer");
        Message message = new MessageString("Lyxtyeb mywwoxd MK fk !");
        Cles clesPubliques = null;
        Cles clesPrivees = new Cles();
        clesPrivees.addCle("cleCesar", new CleInteger(10));
        AlgorithmeCesar instance = new AlgorithmeCesar();
        String expResult = "Bonjour comment CA va !";
        String result = instance.dechiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }

}
