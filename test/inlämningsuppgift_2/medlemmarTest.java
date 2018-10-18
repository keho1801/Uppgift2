package inlämningsuppgift_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import junit.framework.TestCase;
import org.junit.Test;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johnny
 */
public class medlemmarTest {
    Medlemmar lista = new Medlemmar();
    
    @Test
    public void setMedlemTest1(){

       TestCase.assertFalse(lista.checkMedlem(false, 2));
       TestCase.assertFalse(lista.checkMedlem(false,0));
       TestCase.assertTrue(lista.checkMedlem(true, 13));
       TestCase.assertTrue(lista.checkMedlem(true,1));
       
    }
    @Test 
    public void söklistaTest1() throws IOException{
        
       TestCase.assertEquals(true,lista.sökLista("alhambra aromes"));
       TestCase.assertEquals(false,lista.sökLista("kenny hoang"));
       TestCase.assertEquals(true,lista.sökLista("7603021234"));
       TestCase.assertTrue(lista.sökLista("bear belle"));
       TestCase.assertFalse(lista.sökLista("bla bla"));
       
    }
    @Test
    public void skrivTillFilTest() throws IOException{
        
        Path p = Paths.get("src/inlämningsuppgift_2/besökare.txt");
        String filnamn ="src/inlämningsuppgift_2/besökare.txt";
        
        BufferedReader input = Files.newBufferedReader(p);
        String namnet = input.readLine();
        String namnet2 = input.readLine();
        TestCase.assertEquals(namnet.trim(),lista.skrivTillFil(1,filnamn).trim());
        TestCase.assertEquals(namnet2.trim(),lista.skrivTillFil(13, filnamn).trim());
        TestCase.assertNotSame(namnet2.trim(),lista.skrivTillFil(1, filnamn).trim());
        
    }
}