/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Matthieu
 */
public class UniversTest {
    @Test
    public void testStructure() {
        System.out.println("Test de structure");
        Field fields[] = Univers.class.getDeclaredFields();
        assertEquals(3,fields.length);
        
        boolean isInstanceHere = false;
        boolean isListeClesPubliquesHere = false;      
        boolean isListeMessagesPublicsHere = false;
        
        for(Field field : fields) {
            field.setAccessible(true);
            switch(field.getName()) {
                case "instance" : isInstanceHere = true; break;
                case "listeClesPubliques" : isListeClesPubliquesHere = true; break;
                case "listeMessagesPublics" : isListeMessagesPublicsHere = true; break;
            }
        }
        assertEquals("Champs instance absent",true, isInstanceHere);
        assertEquals("Champs listeClesPubliques absent",true, isListeClesPubliquesHere);
        assertEquals("Champs listeMessagesPublics absent",true, isListeMessagesPublicsHere);
    }

    /**
     * Test of get method, of class Univers.
     */
    @Test
    public void testGet() {
        System.out.println("Test de la méthode get");
        Univers result = Univers.get();
        assertNotNull(result);
        Univers result2 = Univers.get();
        assertEquals(result,result2);
    }

    /**
     * Test of addCles method, of class Univers.
     */
    @Test
    public void testAddCles() throws IllegalArgumentException, IllegalAccessException {
        System.out.println("Test de la méthode addCles");
        String identifiant1 = "test1";
        Cles cles1 = new Cles();
        Univers.addCles(identifiant1, cles1);
        String identifiant2 = "test2";
        Cles cles2 = new Cles();
        Univers.addCles(identifiant2, cles2);
        
        Field fields[] = Personne.class.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            if(field.getName().equals("listeClesPubliques")) {
                HashMap<String,Cles> liste = (HashMap<String,Cles>)field.get(Univers.get());
                assertEquals(cles1,liste.get(identifiant1));
                assertEquals(cles2,liste.get(identifiant2));
            }
        }
    }

    /**
     * Test of getCles method, of class Univers.
     */
    @Test
    public void testGetCles() {
        System.out.println("Test de la méthode getCles");
        String identifiant = "test1";
        Cles expResult = new Cles();
        Univers.addCles(identifiant, expResult);
        
        Cles result = Univers.getCles(identifiant);
        assertEquals(expResult, result);
    }

    /**
     * Test of addMessage method, of class Univers.
     */
    @Test
    public void testAddMessage() throws IllegalArgumentException, IllegalAccessException {
        System.out.println("Test de la méthode addMessage");
        String identifiant1 = "test1";
        Message message1 = new MessageString("Test1");
        Univers.addMessage(identifiant1, message1);
        String identifiant2 = "test2";
        Message message2 = new MessageString("Test2");
        Univers.addMessage(identifiant2, message2);
        
        Field fields[] = Personne.class.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            if(field.getName().equals("listeMessagesPublics")) {
                HashMap<String,Message> liste = (HashMap<String,Message>)field.get(Univers.get());
                assertEquals(message1,liste.get(identifiant1));
                assertEquals(message2,liste.get(identifiant2));
            }
        }
    }

    /**
     * Test of getMessage method, of class Univers.
     */
    @Test
    public void testGetMessage() {
        System.out.println("Test de la méthode getMessage");
        String identifiant = "test1";
        Message expResult = new MessageString("Test1");
        Univers.addMessage(identifiant, expResult);
        
        Message result = Univers.getMessage(identifiant);
        assertEquals(expResult, result);
    }
    
}
