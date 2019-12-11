package recursivite;

/**
 * Décomposition en binaire d'un entier en base 10.
 */
class Binaire {

    /**
     * Calcule de la décomposition en binaire d'un entier en base 10. Cette
     * fonction ne prend en entrée que des entiers positifs ou nuls.
     *
     * @param n l'entier (positif) en base 10
     * @return sa décomposition en binaire
     */
    static String chaineBinaire(int n) {
        if (n < 2) {
            return n%2 + "";
        }else{
            return  chaineBinaire(n/2) + n%2;
        }
    }
}
