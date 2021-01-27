/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import algorithmes.chiffrement.Algorithme;
import algorithmes.chiffrement.AlgorithmeFake;
import donnees.cles.Cles;
import donnees.messages.Message;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class PersonneTest {
    
    @Test
    public void testStructure() {
        System.out.println("Test de structure");
        Personne instance = new Personne("Alice");
        Field fields[] = Personne.class.getDeclaredFields();
        assertEquals(3,fields.length);
        
        boolean isNomHere = false;
        boolean isAlgorithmeHere = false;      
        boolean isClesPriveesHere = false;
        
        for(Field field : fields) {
            field.setAccessible(true);
            switch(field.getName()) {
                case "nom" : isNomHere = true; break;
                case "algorithme" : isAlgorithmeHere = true; break;
                case "clesPrivees" : isClesPriveesHere = true; break;
            }
        }
        assertEquals(true, isNomHere,"Champs nom absent");
        assertEquals(true, isAlgorithmeHere,"Champs algorithme absent");
        assertEquals(true, isClesPriveesHere,"Champs clesPrivees absent");
    }
    
    @Test
    public void testGetNom() {
        System.out.println("Test de la méthode getNom");
        Personne instance = new Personne("Alice");
        String expResult = "Alice";
        String result = instance.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAlgorithme method, of class Personne.
     */
    @Test
    public void testSetAlgorithme() throws IllegalArgumentException, IllegalAccessException {
        System.out.println("Test de la méthode setAlgorithme");
        Algorithme algorithme = new AlgorithmeFake();
        Personne instance = new Personne("Alice");
        instance.setAlgorithme(algorithme);
        
        Field fields[] = Personne.class.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            if(field.getName().equals("algorithme")) {
                assertEquals(algorithme,(Algorithme) field.get(instance));
            }
        }
    }

    /**
     * Test of getAlgorithme method, of class Personne.
     */
    @Test
    public void testGetAlgorithme() {
        System.out.println("Test de la méthode getAlgorithme");
        Algorithme algorithme = new AlgorithmeFake();
        Personne instance = new Personne("Alice");
        instance.setAlgorithme(algorithme);
        assertEquals(algorithme,instance.getAlgorithme());
    }

    /**
     * Test of setClesPrivees method, of class Personne.
     */
    @Test
    public void testSetClesPrivees() throws IllegalArgumentException, IllegalAccessException {
        System.out.println("Test de la méthode setClesPrivees");
        Cles cles = new Cles();
        Personne instance = new Personne("Alice");
        instance.setClesPrivees(cles);
        
        Field fields[] = Personne.class.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            if(field.getName().equals("clesPrivees")) {
                assertEquals(cles,(Cles) field.get(instance));
            }
        }
    }

    /**
     * Test of chiffrer method, of class Personne.
     */
    @Test
    public void testChiffrer() throws Exception {
        System.out.println("Test de la méthode Chiffrer");
        Algorithme algorithme = new AlgorithmeFake();
        Personne instance = new Personne("Alice");
        instance.setAlgorithme(algorithme);
        
        Message message = null;
        Cles clesPubliques = null;
        String expResult = "Chiffre";
        Message result = instance.chiffrer(message, clesPubliques);
        assertEquals(expResult, result.asString());
    }

    /**
     * Test of dechiffrer method, of class Personne.
     */
    @Test
    public void testDechiffrer() throws Exception {
        System.out.println("Test de la méthode Dechiffrer");
        Algorithme algorithme = new AlgorithmeFake();
        Personne instance = new Personne("Alice");
        instance.setAlgorithme(algorithme);
        
        Message message = null;
        Cles clesPubliques = null;
        String expResult = "Dechiffre";
        Message result = instance.dechiffrer(message, clesPubliques);
        assertEquals(expResult, result.asString());
    }
    
}
