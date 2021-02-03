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
public class BourrageTest {

    @Test
    public void testBourragem() throws Exception {
        System.out.println("Test du bourrage aléatoire seedé");
        Message message = new MessageString("Bonjour comment ca va ?");
        Cle cleString = new CleString("Chat");

        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        Method methode = instance.getClass().getDeclaredMethod("remplirTableauChiffrement", Message.class,Cle.class);
        methode.setAccessible(true);
        char[][] result1 = (char[][]) methode.invoke(instance, message,cleString);
        char[][] result2 = (char[][]) methode.invoke(instance, message,cleString);
        char[][] result3 = (char[][]) methode.invoke(instance, message,cleString);
        char[][] result4 = (char[][]) methode.invoke(instance, message,cleString);

        //Test de seedage
        assertArrayEquals(result1,result2);
        assertArrayEquals(result1,result3);
        assertArrayEquals(result1,result4);
    }

}