package tpstring;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la classe Voyelles
 */
public class VoyellesTest {

    @Test
    public void testCountVoyelles() {
        Voyelles v1 = new Voyelles("bonjour");
        assertEquals(3, v1.countVoyelles());
        Voyelles v2 = new Voyelles("brr");
        assertEquals(0, v2.countVoyelles());
        Voyelles v3 = new Voyelles("oui");
        assertEquals(3, v3.countVoyelles());
        Voyelles v4 = new Voyelles("");
        assertEquals(0, v4.countVoyelles());
        Voyelles v5 = new Voyelles(" ");
        assertEquals(0, v5.countVoyelles());
        Voyelles v6 = new Voyelles("aeiouy");
        assertEquals(6, v6.countVoyelles());
        Voyelles v7 = new Voyelles("ae ccc ;; 555 bca e");
        assertEquals(4, v7.countVoyelles());
    }

}
