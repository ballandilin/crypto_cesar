package com.company.TestChiffrementVigenere.algorithme.generateurDeCles;

import com.company.algorithmes.generateurDeCles.GenerateurDeClesSubstitution;
import com.company.exceptions.ExceptionConversionImpossible;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class GenerateurDeClesSubstitutionTest {

    /**
     * Test of genererClePrivee method, of class GenerateurDeClesSubstitution.
     */
    @Test
    public void testGenererClePrivee() throws ExceptionConversionImpossible {
        System.out.println("genererClePrivee");
        GenerateurDeClesSubstitution instance = new GenerateurDeClesSubstitution();

        HashMap<Character,Boolean> verif = new HashMap<>();
        for(char c='A';c<='Z';c++) {
            verif.put(c, Boolean.FALSE);
        }

        String strCle = instance.genererClePrivee().getCle("cleSubstitution").asString();
        for(Character c:strCle.toCharArray()) {
            verif.put(c, Boolean.TRUE);
        }

        for(char c='A';c<='Z';c++) {
            if(!verif.get(c)) {
                fail("La clé ne contient pas de "+c);
            }
        }
    }

}