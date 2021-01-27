/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;

import algorithmes.generateurdecles.GenerateurDeClesCesar;
import donnees.cles.Cles;
import exceptions.ExceptionConversionImpossible;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class GenerateurDeClesCesarTest {
    
    /**
     * Test of genererClePublique method, of class GenerateurDeClesCesar.
     */
    @Test
    public void testGenererClePublique() {
        System.out.println("Test de la méthode genererClePublique");
        GenerateurDeClesCesar instance = new GenerateurDeClesCesar();
        Cles expResult = null;
        Cles result = instance.genererClePublique();
        assertEquals(expResult, result);
    }

    /**
     * Test of genererClePrivee method, of class GenerateurDeClesCesar.
     */
    @Test
    public void testGenererClePriveeConditions() throws ExceptionConversionImpossible {
        System.out.println("Test de la méthode genererClePrivee - Compris entre 0 et 25");
        GenerateurDeClesCesar instance = new GenerateurDeClesCesar();
        int result = instance.genererClePrivee().getCle("cleCesar").asInteger();
        assert(result>=0);
        assert(result<=25);
    }
    
    /**
     * Test of genererClePrivee method, of class GenerateurDeClesCesar.
     */
    @Test
    public void testGenererClePriveeRepetitions() throws ExceptionConversionImpossible {
        System.out.println("Test de la méthode genererClePrivee - Répétitions");
        GenerateurDeClesCesar instance = new GenerateurDeClesCesar();
        int expResult = instance.genererClePrivee().getCle("cleCesar").asInteger();
        assertEquals(expResult, instance.genererClePrivee().getCle("cleCesar").asInteger());
        assertEquals(expResult, instance.genererClePrivee().getCle("cleCesar").asInteger());
        assertEquals(expResult, instance.genererClePrivee().getCle("cleCesar").asInteger());
    }
    
}
