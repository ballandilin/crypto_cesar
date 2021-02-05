package com.company.TestChiffrementVigenere.algorithme.generateurDeCles;

import com.company.algorithmes.generateurDeCles.GenerateurDeClesVigenere;
import com.company.donnees.cles.Cle;
import com.company.donnees.cles.Cles;
import com.company.exceptions.ExceptionConversionImpossible;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class GenerateurDeClesVigenereTest {

    /**
     * Test of genererClePrivee method, of class GenerateurDeClesVigenere.
     */
    @Test
    public void testGenererClePrivee() throws ExceptionConversionImpossible {
        System.out.println("genererClePrivee");
        GenerateurDeClesVigenere instance = new GenerateurDeClesVigenere(10);
        Cles result = instance.genererClePrivee();

        Cle cle = result.getCle("cleVigenere");
        assertNotNull(cle);

        assertEquals(10,cle.asString().length());

        for(char c : cle.asString().toCharArray()) {
            if(c<'A' || c>'Z') {
                fail("La clé ne contient pas que des majuscules.");
            }
        }
    }

}
