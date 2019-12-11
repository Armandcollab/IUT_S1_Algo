package recursivite;

/**
 * Calcul de la puissance d'un entier.
 */
class Puissance {

    /**
     * Calcul de la puissance d'un entier, avec une complexité logarithmique.
     *
     * @param a l'entier à élever à la puissance
     * @param n la puissance
     * @return l'entier élevé à la puissance
     */
    static int puissance(int a, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return a;
        } else if (n % 2 == 0) {
            return puissance(a, n / 2) * puissance(a, n / 2);
        } else {
            return a * puissance(a, (n - 1) / 2) * puissance(a, (n - 1) / 2);
        }
    }
}
