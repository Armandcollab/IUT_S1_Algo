package tpstring;

/**
 * Exercice Voyelles.
 */
class Voyelles {

    /**
     * Mot à analyser
     */
    String mot;

    /**
     * Constructeur
     *
     * @param unMot le mot à analyser
     */
    Voyelles(String unMot) {
        mot = unMot;
    }

    /**
     * Compte le nombre de voyelles du mot à analyser.
     *
     * @return le nombre de voyelles du mot à analyser
     */
    int countVoyelles() {
        int nbrVoyelle = 0;
        for (int i = 0; i < this.mot.length(); ++i) {
            if (this.mot.charAt(i) == 'a' | this.mot.charAt(i) == 'e' | this.mot.charAt(i) == 'i' | this.mot.charAt(i) == 'o' | this.mot.charAt(i) == 'u' | this.mot.charAt(i) == 'y') {
                ++nbrVoyelle;
            }
        }

        return nbrVoyelle;
    }
}
