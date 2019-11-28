package distributeurfriandise;


/**
 * Un bonbon.
 */
class Bonbon {

    /**
     * Le nombre global de bonbons fabriqués.
     */
    static int nombreBonbons = 0;

    /**
     * Le nom courant du bonbon.
     */
    String denomination;

    /**
     * Parfum du bonbon, parmi les parfums disponibles.
     */
    Parfum parfum;

    /**
     * Poids du bonbon en grammes.
     */
    float poids;

    /**
     * Nombre de calories du bonbon.
     */
    float calories;

    /**
     * Constructeur de bonbon
     *
     * @param uneDenomination la dénomination du bonbon
     * @param unParfum le parfum du bonbon
     * @param unPoids le poids du bonbon
     * @param desCalories le nombre de calories du bonbon
     */
    Bonbon(String uneDenomination, Parfum unParfum, float unPoids, float desCalories) {
        this.denomination = uneDenomination;
        this.parfum = unParfum;
        this.poids = unPoids;
        this.calories = desCalories;
        nombreBonbons++;
    }

    /**
     * Méthode statique permettant de savoir combien de bonbons ont été fabriqués.
     */
    static int nombreBonbons() {
        return nombreBonbons;
    }

    /**
     * Méthode statique permettant de construire et de retourner un "chewinggum"
     *
     * @param unParfum le parfum souhaité pour le bonbon créé
     * @return un bonbon ayant les caractéristique d'un chewing gum
     */
    static Bonbon chewingGum(Parfum unParfum) {
        return new Bonbon("ChewingGum", unParfum, 10, 52);
    }

    /**
     * Méthode statique permettant de construire et de retourner un "chypresers"
     *
     * @return un bonbon ayant les caractéristique d'un chypresers
     */
    static Bonbon chypresers() {
        return new Bonbon("Chypresers", Parfum.RIZ, 55, 242);
    }

    /**
     * Méthode statique permettant de construire et de retourner un "tigre"
     *
     * @return un bonbon ayant les caractéristique d'un tigre
     */
    static Bonbon tigre() {
       return new Bonbon("Tigre",Parfum.CHOCOLAT,45,228);
    }

    /**
     * Méthode statique permettant de construire et de retourner un "noisettes"
     *
     * @return un bonbon ayant les caractéristique d'un noisettes
     */
    static Bonbon noisettes() {
        return new Bonbon("Noisette", Parfum.NOISETTE, 50, 250);
    }

    /**
     * Méthode statique permettant de construire et de retourner un "venus"
     *
     * @return un bonbon ayant les caractéristique d'un venus
     */
    static Bonbon venus() {
        return new Bonbon("Venus", Parfum.CARAMEL, 45, 228);
    }

    /**
     * Méthode permettant de dessiner un bonbon dans le terminal.
     */
    void dessiner() {
    }

    /**
     * Méthode permettant d'afficher les caractéristiques d'un bonbon.
     */
    void afficher() {
        System.out.println("    Dénomination : "+ this.denomination);
        System.out.println("    Parfum principale : "+ this.parfum);
        System.out.println("    Poids : "+ this.poids + "Calories : "+ this.calories);
    }
}
