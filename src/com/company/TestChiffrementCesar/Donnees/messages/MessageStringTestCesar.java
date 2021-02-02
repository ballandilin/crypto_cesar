package com.company.TestChiffrementCesar.Donnees.messages;

import com.company.donnees.messages.MessageString;
import com.company.exceptions.ExceptionConversionImpossible;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class MessageStringTestCesar {

    @Test
    public void testgetListAsciiCode() throws ExceptionConversionImpossible {
        System.out.println("Test de la méthode getListAsciiCode");
        MessageString instance = new MessageString("ABCabc");
        List<Integer> expResult = Arrays.asList(65,66,67,97,98,99);
        List<Integer> result = instance.getListAsciiCode();
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

}
