package distributeurfriandise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests unitaires de la classe Distributeur.
 */
public class DistributeurTest {
    
    @Test
    public void testAjouterBonbon() {
    }

    @Test
    public void testRetirerBonbon() {
        Distributeur dis = new Distributeur();
        dis.ajouterBonbon(Bonbon.tigre());
        Assert.assertEquals(Bonbon.nombreBonbons,dis.retirerBonbon());
    }

    @Test
    public void testRetirerBonbons_int() {
    }

    @Test
    public void testRetirerBonbons_0args() {
    }

    @Test
    public void testPlein() {
        Distributeur dis = new Distributeur();
        Assert.assertFalse(dis.plein());/*
        dis.nombreBonbons = Distributeur.CONTENANCE_MAX;
        Assert.assertTrue(dis.plein());*/
    }

    @Test
    public void testVide() {
        Distributeur dis = new Distributeur();
        Assert.assertTrue(dis.vide());/*
        dis.nombreBonbons = 1;
        Assert.assertFalse(dis.vide());*/
    }

    @Test
    public void testNombreBonbons() {
    }

}
