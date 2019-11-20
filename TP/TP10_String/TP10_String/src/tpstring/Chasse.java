package tpstring;

/**
 * Exercice Chasse.
 */
class Chasse {

    /**
     * La grille, sous forme d'un tabelau de chaînes de caractères.
     */
    String[] grille = {"alvanillécga", "imrsufpetidm", "dsucrésmdnae",
        "oenshtsioutr", "jvabmodrfbdi", "suiféuépicés", "calagacoarfd", "illkinhiébaa",
        "bdéértsvajim", "epiqmasrcsge", "facideségmri", "chocolatéres"};

    /**
     * La grille, sous forme d'un tableau de caractères à deux dimensions.
     */
    char[][] grilleC;

    /**
     * Dimension d'un côté d'une grille.
     */
    static final int SIZE = 12;

    /**
     * Constructeur.
     */
    Chasse() {
        grilleC = new char[SIZE][SIZE];
    }

    /**
     * Affecter le contenu de grille à grilleC (changement de format).
     */
    void transformGrille() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length(); j++) {
                grilleC[i][j] = grille[i].charAt(j);
            }
        }
    }

    /**
     * Renvoie le contenu de la grille sous la forme d'une chaîne.
     * Ici on redéfinit (override) la méthode toString() disponible pour tous
     * les objets.
     * 
     * @return contenu de la grille sous la forme d'une chaîne
     */
    @Override
    public String toString() {
        String chaine = "";
        for (int i = 0; i < grilleC.length; i++) {
            for (int j = 0; j < grilleC[i].length; j++) {
                chaine = chaine + grilleC[i][j] + " ";
            }
            chaine = chaine + "\n"; // retour à la ligne
        }
        return chaine;
    }

    /**
     * Indique si un mot est présent dans la grille.
     *
     * @param s le mot à chercher
     * @return vrai ssi ce mot est présent dans la grille
     */
    boolean isPresent(String s) {
        return false;
    }

    /**
     * Indique si un mot est présent dans la grille horizontalement, en partant
     * de la case (i, j).
     *
     * @param s le mot à chercher
     * @param i l'indice de ligne où chercher le mot
     * @param j l'indice de colonne où chercher le mot
     * @return vrai ssi le mot est trouvé horizontalement à cette position
     */
    boolean findH(String s, int i, int j) {
        return false;
    }

    /**
     * Indique si un mot est présent dans la grille verticalement, en partant de
     * la case (i, j).
     *
     * @param s le mot à chercher
     * @param i l'indice de ligne où chercher le mot
     * @param j l'indice de colonne où chercher le mot
     * @return vrai ssi le mot est trouvé verticalement à cette position
     */
    boolean findV(String s, int i, int j) {
        return false;
    }

    /**
     * Indique si un mot est présent dans la grille en diagonale, en partant de
     * la case (i, j).
     *
     * @param s le mot à chercher
     * @param i l'indice de ligne où chercher le mot
     * @param j l'indice de colonne où chercher le mot
     * @return vrai ssi le mot est trouvé diagonalement à cette position
     */
    boolean findD(String s, int i, int j) {
        return false;
    }
}
