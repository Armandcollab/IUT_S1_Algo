package tpstring;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la classe Mail
 */
public class MailTest {

    @Test
    public void testIsValidMail() {
        Mail m1 = new Mail("journet@labri.fr");
        assertTrue(m1.isValidMail());
        Mail m2 = new Mail("t@labri.fr");
        assertFalse(m2.isValidMail());
        Mail m3 = new Mail("journet@.fr");
        assertFalse(m3.isValidMail());
        Mail m4 = new Mail("journet@labri");
        assertFalse(m4.isValidMail());
        Mail m5 = new Mail("journet.nicholas@labri");
        assertFalse(m5.isValidMail());
        Mail m6 = new Mail("journetzzz.nicholas@labri.fr");
        assertTrue(m6.isValidMail());
        Mail m7 = new Mail("journetzzzS.nicholas@labri.fr");
        assertTrue(m7.isValidMail());
        Mail m8 = new Mail("journet@labri.fracaise");
        assertFalse(m8.isValidMail());
        Mail m9 = new Mail("journet@labri.fracais");
        assertTrue(m9.isValidMail());
        Mail m10 = new Mail(" ");
        assertFalse(m10.isValidMail());
        Mail m11 = new Mail("");
        assertFalse(m11.isValidMail());
        Mail m12 = new Mail("journet@labri.f");
        assertFalse(m12.isValidMail());
        Mail m13 = new Mail("abcdefghijklmnopqrst@abcdefghijklmnopqrst.abcdefg");
        assertTrue(m13.isValidMail());
        Mail m14 = new Mail("abcdefghijklmnopqrstu@abcdefghijklmnopqrst.abcdefg");
        assertFalse(m14.isValidMail());
        Mail m15 = new Mail("abcdefghijklmnopqrst@abcdefghijklmnopqrstu.abcdefg");
        assertFalse(m15.isValidMail());
        Mail m16 = new Mail("abcdefghijklmnopqrst@abcdefghijklmnopqrst.abcdefgh");
        assertFalse(m16.isValidMail());
        Mail m17 = new Mail("journet@labr.i.fr");
        assertTrue(m17.isValidMail());
        Mail m18 = new Mail("journet@labr.i.");
        assertTrue(m18.isValidMail());
        Mail m19 = new Mail("jou@lab.fr");
        assertTrue(m19.isValidMail());
        Mail m20 = new Mail("jo@lab.fr");
        assertFalse(m20.isValidMail());
        Mail m21 = new Mail("jo.@lab.fr");
        assertTrue(m21.isValidMail());
    }

}
