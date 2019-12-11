package recursivite;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests de la décomposition binaire d'un entier en base 10.
 */
public class BinaireTest {

    @Test
    public void testChaineBinaire() {
        String[] res = new String[1];
        Assert.assertEquals(""+0, Binaire.chaineBinaire(0));
        Assert.assertEquals(""+1, Binaire.chaineBinaire(1));
        Assert.assertEquals("1"+"0"+"0"+"0", Binaire.chaineBinaire(8));
        Assert.assertEquals("1"+"1"+"0"+"1", Binaire.chaineBinaire(13));
    }
}
