package recherche;

/**
 * Recherche d'une valeur dans un tableau.
 */
class FindValue {

    /**
     * Recherche dans un tableau non trié : parcours linéaire.
     *
     * @param tab le tableau d'éléments
     * @param valeur la valeur à rechercher
     * @return l'indice d'un élément égal à la valeur, ou -1 si un tel élément
     * n'existe pas.
     */
    static int rechercheLineaire(int[] tab, int valeur) {
        int pos = 0;
        boolean trouve = false;

        while (!trouve && pos < tab.length) {
            if (valeur == tab[pos]) {
                pos=pos-1;
                trouve = true;
            } 
            pos++;
        }

        if (!trouve) {
            pos = -1;
        }

        return pos;
    }

    /**
     * Recherche dichotomique dans un tableau trié.
     *
     * @param tab le tableau d'éléments, trié
     * @param valeur la valeur à rechercher
     * @return l'indice d'un élément égal à la valeur, ou -1 si un tel élément
     * n'existe pas.
     */
    static int rechercheDichotomique(int[] tab, int valeur) {
        int gauche, droite, milieu = 0;
        boolean trouve;

        gauche = 0;
        droite = tab.length - 1;
        trouve = false;

        while (!trouve && gauche <= droite) {
            milieu = (droite + gauche) / 2;
            if (valeur < tab[milieu]) {
                droite = milieu - 1;
            } else if (valeur > tab[milieu]) {
                gauche = milieu + 1;
            } else {
                trouve = true;
            }
        }

        if (!trouve) {
            milieu = -1;
        }

        return milieu;
    }
}
