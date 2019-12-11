package recursivite;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests du calcul de la puissance.
 */
public class PuissanceTest {

    @Test
    public void testPuissance() {
        Assert.assertEquals(1,Puissance.puissance(1, 0));
        Assert.assertEquals(1,Puissance.puissance(120, 0));
        Assert.assertEquals(4,Puissance.puissance(2, 2));
        Assert.assertEquals(16,Puissance.puissance(4, 2));
        Assert.assertEquals(8,Puissance.puissance(2, 3));
        Assert.assertEquals(16,Puissance.puissance(2, 4));
        Assert.assertEquals(32,Puissance.puissance(2, 5));
    }
}
