package com.company.TestMoteur.donnees.cles;

import com.company.donnees.cles.CleString;
import com.company.exceptions.ExceptionConversionImpossible;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author simonetma
 */
public class CleStringTest {


    /**
     * Test of asString method, of class CleString.
     */
    @Test
    public void testAsString() throws Exception {
        System.out.println("Test de la méthode asString");
        CleString instance = new CleString("cle De Test");
        String expResult = "cle De Test";
        String result = instance.asString();
        assertEquals(expResult, result);
    }

    /**
     * Test of asInteger method, of class CleString.
     */
    @Test
    public void testAsInteger() throws Exception {
        System.out.println("Test de la méthode asInteger");
        CleString instance = new CleString("cle De Test"); ;
        try{
            instance.asInteger();
            fail("La méthode devrait lever une exception");
        }
        catch(ExceptionConversionImpossible ex) {

        }
    }

}
