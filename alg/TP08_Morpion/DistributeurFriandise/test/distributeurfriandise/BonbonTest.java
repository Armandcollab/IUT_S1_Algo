package distributeurfriandise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests unitaires de la classe Bonbon.
 */
public class BonbonTest {
    
    @Test
    public void testChewingGum() {
        Bonbon b = Bonbon.chewingGum(Parfum.CARAMEL);
        Assert.assertEquals("ChewingGum",b.denomination);
        Assert.assertEquals(10,b.poids,0.0001);
        Assert.assertEquals(52,b.calories,0.0001);
        Assert.assertEquals(Parfum.CARAMEL,b.parfum);
    }

    @Test
    public void testChypresers() {
        Bonbon b = Bonbon.chypresers();
        Assert.assertEquals("Chypresses",b.denomination);
        Assert.assertEquals(55,b.poids,0.0001);
        Assert.assertEquals(242,b.calories,0.0001);
        Assert.assertEquals(Parfum.RIZ,b.parfum);
    }

    @Test
    public void testTigre() {
        Bonbon b = Bonbon.tigre();
        Assert.assertEquals("Tigre",b.denomination);
        Assert.assertEquals(45,b.poids,0.0001);
        Assert.assertEquals(228,b.calories,0.0001);
        Assert.assertEquals(Parfum.CHOCOLAT,b.parfum);
    }

    @Test
    public void testNoisettes() {
        Bonbon b = Bonbon.noisettes();
        Assert.assertEquals("Noisettes",b.denomination);
        Assert.assertEquals(50,b.poids,0.0001);
        Assert.assertEquals(250,b.calories,0.0001);
        Assert.assertEquals(Parfum.NOISETTE,b.parfum);
    }

    @Test
    public void testVenus() {
        Bonbon b = Bonbon.venus();
        Assert.assertEquals("Venus",b.denomination);
        Assert.assertEquals(45,b.poids,0.0001);
        Assert.assertEquals(228,b.calories,0.0001);
        Assert.assertEquals(Parfum.CARAMEL,b.parfum);
    }

}
