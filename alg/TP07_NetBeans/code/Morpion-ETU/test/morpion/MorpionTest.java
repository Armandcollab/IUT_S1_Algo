/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author aclaveau
 */
public class MorpionTest extends TestCase {
    
    public MorpionTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    @Test
    public void testInitialiserGrille() {
        int taille = 3;
        int[][] grille = {{-1, -1, -1}, { -1, -1, -1}, { -1, -1, -1}};
        Morpion.initialiserGrille(taille, grille);
        for (int lig = 0; lig < grille.length; lig++) {
            for (int col = 0; col < grille[lig].length; col++) {
                assertEquals(0, grille[lig][col]);
            }
        }
    }
    
    @Test
    public void testIsColonneComplete(){
        int taille = 3;
        int[][] grille1 = {{0, 0, 0}, {0, 0, 0},{0, 0, 0}};
        int[][] grille2 = {{2, 1, 1}, {1, 2, 2},{1, 2, 1}};
        int[][] grille3 = {{0, 1, 0}, {0, 1, 2},{2, 1, 0}};
        int[][] grille4 = {{2, 1, 1}, {2, 0, 0},{2, 1, 0}};
        int[][] grille5 = {{1, 0, 2}, {1, 0, 2},{0, 1, 0}};
        
        for (int i = 0; i < 3; i++) {
            assertFalse(Morpion.isColonneComplete(i, taille, grille1));
        }      
        
        for (int i = 0; i < 3; i++) {
            assertFalse(Morpion.isColonneComplete(i, taille, grille2));
        }        
        
        assertFalse(Morpion.isColonneComplete(0, taille, grille3));
        assertTrue( Morpion.isColonneComplete(1, taille, grille3));
        assertFalse(Morpion.isColonneComplete(2, taille, grille3));
        
        assertTrue( Morpion.isColonneComplete(0, taille, grille4));
        assertFalse(Morpion.isColonneComplete(1, taille, grille4));
        assertFalse(Morpion.isColonneComplete(2, taille, grille4));
        
        assertFalse(Morpion.isColonneComplete(0, taille, grille5));
        assertFalse(Morpion.isColonneComplete(1, taille, grille5));
        assertFalse( Morpion.isColonneComplete(2, taille, grille5));
    }
        
    @Test
    public void testIsDiagonaleI(){
        int taille = 3;
        int[][] grille1 = {{0, 0, 0}, {0, 0, 0},{0, 0, 0}};
        int[][] grille2 = {{0, 0, 2}, {1, 2, 1},{2, 0, 1}};
        int[][] grille3 = {{2, 2, 0}, {0, 1, 2},{2, 1, 0}};
        
        assertFalse(Morpion.isDiagonaleI(taille, grille1));
        assertTrue( Morpion.isDiagonaleI(taille, grille2));
        assertFalse(Morpion.isDiagonaleI(taille, grille3));

    }
    @Test
    public void testChangeJoueur(){
        int nbjoueur = 2;
        int joueur1 = 1;
        int joueur2 = 2;
        
        assertEquals(2, Morpion.changerJoueur(joueur1, nbjoueur));
        assertEquals(1,Morpion.changerJoueur(joueur2, nbjoueur));
        
    }
}
    
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}

