package com.company.TestMoteur.donnees.cles;

import com.company.donnees.cles.CleInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class CleIntegerTest {

    @Test
    public void testAsString_1() throws Exception {
        System.out.println("1er test de la méthode asString");
        CleInteger instance = new CleInteger(42);
        String expResult = "42";
        String result = instance.asString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAsString_2() throws Exception {
        System.out.println("2nd test de la méthode asString");
        CleInteger instance = new CleInteger(754863);
        String expResult = "754863";
        String result = instance.asString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAsInteger_1() throws Exception {
        System.out.println("1er test de la méthode asInteger");
        CleInteger instance = new CleInteger(42);
        int expResult = 42;
        int result = instance.asInteger();
        assertEquals(expResult, result);
    }

    @Test
    public void testAsInteger_2() throws Exception {
        System.out.println("1er test de la méthode asInteger");
        CleInteger instance = new CleInteger(754863);
        int expResult = 754863;
        int result = instance.asInteger();
        assertEquals(expResult, result);
    }

}
