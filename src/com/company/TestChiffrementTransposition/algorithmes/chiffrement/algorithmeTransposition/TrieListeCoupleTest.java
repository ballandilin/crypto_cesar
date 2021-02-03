package com.company.TestChiffrementTransposition.algorithmes.chiffrement.algorithmeTransposition;

import com.company.algorithmes.chiffrement.algorithmetransposition.ComparateurCouple;
import com.company.algorithmes.chiffrement.algorithmetransposition.Couple;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author simonetma
 */
public class TrieListeCoupleTest {


    @Test
    public void testTrieListeCouples() {
        System.out.println("Test du trie d'une liste de couple");
        ArrayList<Couple> listeCouple = new ArrayList<>();
        listeCouple.add(new Couple('H',1));
        listeCouple.add(new Couple('e',2));
        listeCouple.add(new Couple('L',3));
        listeCouple.add(new Couple('L',4));
        listeCouple.add(new Couple('o',5));
        Collections.sort(listeCouple,new ComparateurCouple());
        String result = "";
        for(Couple c : listeCouple) {
            result += c.getCaractere() + Integer.toString(c.getPosition());
        }

        assertEquals("H1L3L4e2o5", result);
    }

    private void assertEquals(String h1L3L4e2o5, String result) {
    }

}
