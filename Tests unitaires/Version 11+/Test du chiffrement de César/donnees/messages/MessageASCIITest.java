/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.messages;

import exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class MessageASCIITest {
    

    /**
     * Test of asString method, of class MessageASCII.
     */
    @Test
    public void testAsString() throws Exception {
        System.out.println("Test de la méthode asString");
        List<Integer> liste = Arrays.asList(65,66,67,97,98,99);
        ArrayList<Integer> arrayListe = new ArrayList<>();
        arrayListe.addAll(liste);
        MessageASCII instance = new MessageASCII(arrayListe);
        String expResult = "ABCabc";
        String result = instance.asString();
        assertEquals(expResult, result);
    }

    /**
     * Test of asInteger method, of class MessageASCII.
     */
    @Test
    public void testAsInteger() throws Exception {
        System.out.println("1er Test de la méthode asInteger");
        MessageASCII instance = new MessageASCII(null);
        try {
            instance.asInteger();
            fail("La méthode devrait renvoyer une exception");
        }
        catch(ExceptionConversionImpossible ex) {
        }
    }

    /**
     * Test of getListAsciiCode method, of class MessageASCII.
     */
    @Test
    public void testGetListAsciiCode() throws Exception {
        System.out.println("Test de la méthode asString");
        List<Integer> expResult = Arrays.asList(65,66,67,97,98,99);
        ArrayList<Integer> arrayListe = new ArrayList<>();
        arrayListe.addAll(expResult);
        MessageASCII instance = new MessageASCII(arrayListe);
        List<Integer> result = instance.getListAsciiCode();
        assertArrayEquals(expResult.toArray(), result.toArray());
    }
    
}
