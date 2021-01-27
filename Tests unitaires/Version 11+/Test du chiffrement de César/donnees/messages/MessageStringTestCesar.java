/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.messages;

import exceptions.ExceptionConversionImpossible;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
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
