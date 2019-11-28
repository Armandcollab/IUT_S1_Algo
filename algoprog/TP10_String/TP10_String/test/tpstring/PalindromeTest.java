package tpstring;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la classe Palindrome
 */
public class PalindromeTest {
    
    @Test
    public void testIsPalindrome() {
        Palindrome p1=new Palindrome("toto");
        assertFalse(p1.isPalindrome());
        Palindrome p2=new Palindrome("");
        assertTrue(p2.isPalindrome());    
        Palindrome p3=new Palindrome(" ");
        assertTrue(p3.isPalindrome());
        Palindrome p4=new Palindrome("laval");
        assertTrue(p4.isPalindrome());
        Palindrome p5=new Palindrome("abba");
        assertTrue(p5.isPalindrome());       
        Palindrome p6=new Palindrome("a");
        assertTrue(p6.isPalindrome()); 
        Palindrome p7=new Palindrome("la mariee ira mal");
        assertTrue(p7.isPalindrome()); 
        Palindrome p8=new Palindrome("la mariée ira mal");
        assertFalse(p8.isPalindrome()); 
        Palindrome p9=new Palindrome("lavax");
        assertFalse(p9.isPalindrome());
        Palindrome p10=new Palindrome("xaval");
        assertFalse(p10.isPalindrome());
        Palindrome p11=new Palindrome("lxval");
        assertFalse(p11.isPalindrome());
        Palindrome p12=new Palindrome("axa");
        assertTrue(p12.isPalindrome());
        Palindrome p13=new Palindrome("axba");
        assertFalse(p13.isPalindrome());
    }
    
}
