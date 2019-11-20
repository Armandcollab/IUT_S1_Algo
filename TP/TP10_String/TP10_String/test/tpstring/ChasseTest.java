package tpstring;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la classe Chasse.
 */
public class ChasseTest {

    @Test
    public void testAfficheGrilleChar() {
        Chasse chasse = new Chasse();
        chasse.transformGrille();
        System.out.println(chasse); // appelle implicitement chasse.toString()
    }

    @Test
    public void testFindH() {
        Chasse c = new Chasse();
        c.transformGrille();
        System.out.println(c);
        assertTrue(c.findH("vanillé", 0, 2));
        assertFalse(c.findH("vanillé", 0, 0));
        assertTrue(c.findH("cga", 0, 9));
        assertFalse(c.findH("cga", 0, 10));
        assertFalse(c.findH("cga", 0, 8));
        assertFalse(c.findH("", 0, 0));
        assertFalse(c.findH(" ", 0, 1));
        assertTrue(c.findH("éres", 11, 8));
        assertFalse(c.findH(" ", 0, 11));
        assertFalse(c.findH(" ", 0, 12));
        assertTrue(c.findH("a", 0, 0));
        assertTrue(c.findH("a", 0, 11));
        assertTrue(c.findH("chocolaté", 11, 0));
    }

    @Test
    public void testFindV() {
        Chasse c = new Chasse();
        c.transformGrille();
        System.out.println(c);
        assertTrue(c.findV("aillé", 4, 2));
        assertTrue(c.findV("amer", 0, 11));
        assertTrue(c.findV("s", 11, 11));
        assertTrue(c.findV("a", 0, 0));
        assertTrue(c.findV("c", 11, 0));
        assertFalse(c.findV(" ", 10, 10));
        assertFalse(c.findV("", 10, 10));
        assertFalse(c.findV("vrn", 0, 2));
        assertFalse(c.findV("fca", 10, 0));
    }

    @Test
    public void testFindD() {
        Chasse c = new Chasse();
        c.transformGrille();
        System.out.println(c);
        assertTrue(c.findD("salé", 5, 0));
        assertTrue(c.findD("srs", 9, 9));
        assertTrue(c.findD("amus", 0, 0));
        assertTrue(c.findD("a", 0, 11));
        assertTrue(c.findD("gm", 0, 10));
        assertFalse(c.findD("amus", 0, 1));
        assertFalse(c.findD("amus", 0, 11));
        assertFalse(c.findD("gma", 0, 10));
        assertFalse(c.findD(" ", 0, 10));
        assertFalse(c.findD("", 0, 10));
        assertFalse(c.findD("a", 0, 19));
    }

    @Test
    public void TestIsPresent() {
        Chasse c = new Chasse();
        c.transformGrille();
        assertTrue(c.isPresent("acide"));
        assertTrue(c.isPresent("aigre"));
        assertTrue(c.isPresent("aillé"));
        assertTrue(c.isPresent("amer"));
        assertTrue(c.isPresent("chocolaté"));
        assertTrue(c.isPresent("épicé"));
        assertTrue(c.isPresent("poivré"));
        assertTrue(c.isPresent("salé"));
        assertTrue(c.isPresent("sucré"));
        assertTrue(c.isPresent("vanillé"));
        assertFalse(c.isPresent(""));
        assertFalse(c.isPresent("scure"));
        assertFalse(c.isPresent("scuréé"));
    }
}
