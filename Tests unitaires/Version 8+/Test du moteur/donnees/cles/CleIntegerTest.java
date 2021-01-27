/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.cles;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
