package distributeurfriandise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests unitaires de la classe Distributeur.
 */
public class DistributeurTest {
 
    @Test
    public void testAjouterBonbon() {
        Distributeur dis = new Distributeur();
        Bonbon.nombreBonbons = 0;
        Assert.assertTrue(dis.ajouterBonbon(Bonbon.chypresers()));
        Assert.assertEquals("Chypresers",dis.contenu[Bonbon.nombreBonbons-1].denomination);
        Assert.assertTrue(dis.ajouterBonbon(Bonbon.noisettes()));
        Assert.assertEquals("Noisette",dis.contenu[Bonbon.nombreBonbons-1].denomination);
        Assert.assertTrue(dis.ajouterBonbon(Bonbon.chewingGum(Parfum.CARAMEL)));
        Assert.assertEquals("ChewingGum",dis.contenu[Bonbon.nombreBonbons-1].denomination);
        Assert.assertEquals(Parfum.CARAMEL,dis.contenu[Bonbon.nombreBonbons-1].parfum);
        Assert.assertTrue(dis.ajouterBonbon(Bonbon.tigre()));
        Assert.assertEquals("Tigre",dis.contenu[Bonbon.nombreBonbons-1].denomination);
        Assert.assertTrue(dis.ajouterBonbon(Bonbon.noisettes()));
    }

    @Test
    public void testRetirerBonbon() {
        Distributeur dis1 = new Distributeur();
        dis1.ajouterBonbon(Bonbon.tigre());
        Assert.assertEquals("Tigre",dis1.retirerBonbon().denomination);
    }

    @Test
    public void testRetirerBonbons_int() {
        
        Distributeur dis = new Distributeur();
        
       Assert.assertArrayEquals(null,dis.retirerBonbons(3));

        dis.ajouterBonbon(Bonbon.chypresers());
        dis.ajouterBonbon(Bonbon.chewingGum(Parfum.CARAMEL));
        dis.ajouterBonbon(Bonbon.noisettes());
        dis.ajouterBonbon(Bonbon.tigre());
        Bonbon[] tablResultat = dis.retirerBonbons(3);
        Assert.assertEquals("Tigre",tablResultat[0].denomination);
        Assert.assertEquals("Noisette",tablResultat[1].denomination);
        Assert.assertEquals("ChewingGum",tablResultat[2].denomination);
        Assert.assertEquals(Parfum.CARAMEL,tablResultat[2].parfum);
    }

    @Test
    public void testRetirerBonbons_0args() {
        
        Bonbon[] BonbonTab = new Bonbon[4]; 
        Distributeur dis = new Distributeur();
        
        Assert.assertArrayEquals(null,dis.retirerBonbons());
        
        BonbonTab[3] = Bonbon.chypresers();
        dis.ajouterBonbon(Bonbon.chypresers());
        BonbonTab[2] = Bonbon.chewingGum(Parfum.CARAMEL);
        dis.ajouterBonbon(Bonbon.chewingGum(Parfum.CARAMEL));
        BonbonTab[1] = Bonbon.chypresers();
        dis.ajouterBonbon(Bonbon.chypresers());
        BonbonTab[0] = Bonbon.tigre();
        dis.ajouterBonbon(Bonbon.tigre());
        
        Bonbon[] tablRes = dis.retirerBonbons();
        for (int i = 0; i < 4; ++i){
            Assert.assertEquals(BonbonTab[0].denomination,tablRes[0].denomination);
        }
        
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
