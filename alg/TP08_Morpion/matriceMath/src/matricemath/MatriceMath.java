package matricemath;

/**
 * Traitements sur les matrices.
 */
class MatriceMath {

    /**
     * Fonction principale.
     *
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        // Nous supposerons ici que l'utilisateur est intelligent et qu'il ne 
        // testera qu'avec des matrices de même taille
        int[][] mat1 = {{2, 0, -1, 1}, {8, 1, -3, -2}, {0, 0, 0, 1}};
        int[][] mat2 = {{1, 5, 1, 3}, {0, 2, 0, -1}, {3, 1, 1, 0}};
        int[][] matRes;
        matRes = add(mat1, mat2);
        matRes = sub(mat1, mat2);
    }

    /**
     * Addition de deux matrices de même taille.
     * 
     * @param mat1 la première matrice
     * @param mat2 la seconde matrice
     * @return la matrice résultat de l'addition des matrices en paramètre
     */
    static int[][] add(int[][] mat1, int[][] mat2) {
        int[][] matRes = new int[mat1.length][mat1[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                matRes[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return matRes;
    }

    /**
     * Soustraction de deux matrices de même taille.
     * 
     * @param mat1 la première matrice
     * @param mat2 la seconde matrice
     * @return la matrice résultat de la soustraction des matrices en paramètre
     */
    static int[][] sub(int[][] mat1, int[][] mat2) {
        int[][] matRes = new int[mat1.length][mat1[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                matRes[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
        return matRes;
    }
}