package com.company.TestChiffrementTransposition.algorithmes.chiffrement;

import com.company.algorithmes.chiffrement.AlgorithmeTransposition;
import com.company.donnees.cles.Cle;
import com.company.donnees.cles.CleString;
import com.company.donnees.messages.Message;
import com.company.donnees.messages.MessageString;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author simonetma
 */
public class RemplirTableauChiffrementTest {





    /**
     * Test of dechiffrer method, of class AlgorithmeTransposition.
     */
    @Test
    public void testRemplirTableauSansBourrage() throws Exception {
        System.out.println("Test du remplissage du tableau sans bourrage");
        Message message = new MessageString("Bonjour comment ca va ?");
        Cle cleString = new CleString("Chat");

        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        Method methode = instance.getClass().getDeclaredMethod("remplirTableauChiffrement", Message.class,Cle.class);
        methode.setAccessible(true);
        char[][] result = (char[][]) methode.invoke(instance, message,cleString);

        char[][] expResult = {
                {'B','o','n','j'},
                {'o','u','r',' '},
                {'c','o','m','m'},
                {'e','n','t',' '},
                {'c','a',' ','v'},
                {'a',' ','?','x'},
        };

        assertArrayEquals(expResult,result);
    }

    /**
     * Test of dechiffrer method, of class AlgorithmeTransposition.
     */
    @Test
    public void testRemplirTableauSansBourrage2() throws Exception {
        System.out.println("Test du remplissage du tableau sans bourrage");
        Message message = new MessageString("Bonjour, comment ca va ?");
        Cle cleString = new CleString("Chat");

        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        Method methode = instance.getClass().getDeclaredMethod("remplirTableauChiffrement", Message.class,Cle.class);
        methode.setAccessible(true);
        char[][] result = (char[][]) methode.invoke(instance, message,cleString);

        char[][] expResult = {
                {'B','o','n','j'},
                {'o','u','r',','},
                {' ','c','o','m'},
                {'m','e','n','t'},
                {' ','c','a',' '},
                {'v','a',' ','?'},
        };

        assertArrayEquals(expResult,result);
    }
}
