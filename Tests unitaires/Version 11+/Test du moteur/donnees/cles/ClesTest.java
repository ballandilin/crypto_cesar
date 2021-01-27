/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.cles;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class ClesTest {
    
    @Test
    public void testStructure() throws IllegalArgumentException, IllegalAccessException {
        System.out.println("Test de structure");
        Cles instance = new Cles();
        Field fields[] = Cles.class.getDeclaredFields();
        assertEquals(1,fields.length,"La classe cles ne contient pas le bon nombre d'attributs");
        assertEquals(fields[0].getName(),"listeCles","L''attribut de la classe n'a pas le bon nom");
    }
    
    @Test
    public void testAddCle() throws IllegalArgumentException, IllegalAccessException {
        System.out.println("Test de la méthode addCle");
        String nom = "monId";
        Cle cle = new CleInteger(42);
        Cles instance = new Cles();
        instance.addCle(nom, cle);
        Field field = Cles.class.getDeclaredFields()[0];
        field.setAccessible(true);
        assertEquals(1,((HashMap<String,Cle>) field.get(instance)).size(),"La HashMap est vide malgré un ajout");
        assertEquals(cle,((HashMap<String,Cle>) field.get(instance)).get(nom),"La cle n'est pas correctement stockée dans la HashMap");
    }
    
    @Test
    public void testGetCle_1() {
        System.out.println("1er Test de la méthode getCle");
        String nom = "monId";
        Cles instance = new Cles();
        Cle expResult = null;
        Cle result = instance.getCle(nom);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCle_2() {
        System.out.println("2nd Test de la méthode getCle");
        String nom = "monId";
        Cle cle = new CleInteger(42);
        Cles instance = new Cles();
        instance.addCle(nom, cle);
        Cle expResult = cle;
        Cle result = instance.getCle(nom);
        assertEquals(expResult, result);
    }

    
}
