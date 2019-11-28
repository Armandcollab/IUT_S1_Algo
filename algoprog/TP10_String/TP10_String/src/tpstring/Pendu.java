package tpstring;

/**
 * Exercice Pendu.
 */
class Pendu {

    /**
     * Nombre de vies restantes pour le joueur.
     */
    int vies;

    /**
     * Mot à deviner.
     */
    String wordToFind;

    /**
     * Mot en cours de construction.
     */
    StringBuilder wordOnGoing;

    /**
     * Constructeur
     *
     * @param aWordToFind le mot à trouver
     */
    Pendu(String aWordToFind) {
        vies = 4;
        wordToFind = aWordToFind;
        wordOnGoing = new StringBuilder();
        for (int i = 0; i < wordToFind.length(); i++) {
            wordOnGoing.append("?");
        }
    }

    /**
     * Traiter une proposition de caractère pour le jeu du pendu.
     *
     * @param a le caractère proposé par le joueur
     */
    void proposeChar(char a) {
        // TODO
    }

    /**
     * Action principale
     * 
     * @param args arguments de la ligne de commande (non utilisés ici)
     */
    public static void main(String[] args) {

        Pendu p = new Pendu("informatique");

        // une partie gagnante :
        p.proposeChar('i');
        p.proposeChar('n');
        p.proposeChar('f');
        p.proposeChar('o');
        p.proposeChar('r');
        p.proposeChar('m');
        p.proposeChar('a');
        p.proposeChar('t');
        p.proposeChar('q');
        p.proposeChar('u');
        p.proposeChar('e');

        // une partie perdante :
        /*
        p.proposeChar('i');
        p.proposeChar('n');
        p.proposeChar('x');
        p.proposeChar('w');
        p.proposeChar('q');
        p.proposeChar('s');
        p.proposeChar('p');
        */
    }
}
