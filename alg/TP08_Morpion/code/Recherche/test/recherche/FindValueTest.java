package recherche;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests unitaires de la classe FindValue.
 */
public class FindValueTest {
    
    @Test
    public void testRechercheLineaire() {
        int[] tabl = {1,2,5,3,5};
        assertEquals(FindValue.rechercheLineaire(tabl, 5), 2);
        assertEquals(FindValue.rechercheLineaire(tabl, 42), -1);
    }

    @Test
    public void testRechercheDichotomique() {
       int[] tabl = {1,2,3,4,5,6,7};
        assertEquals(FindValue.rechercheDichotomique(tabl, 3), 2);
        assertEquals(FindValue.rechercheDichotomique(tabl, 6), 5);
        assertEquals(FindValue.rechercheDichotomique(tabl, 12), -1);
    }
}
