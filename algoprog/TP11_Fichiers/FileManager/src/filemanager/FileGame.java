package filemanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Jeu ASCII.
 */
class FileGame {

    /**
     * Chemin vers le fichier stockant le niveau.
     */
    final String FICHIER_NIVEAU = "ressources/game/result.txt";

    /**
     * Déplacer le héros en fonction du mouvement donné en paramètre.
     *
     * @param mouvement mouvement : "m" pour avancer, "j" pour sauter
     * @return vrai ssi le héros est sorti
     */
    boolean moveHero(String mouvement) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FICHIER_NIVEAU));
            int posArro = br.readLine().indexOf('@');
            int posSortie = br.readLine().indexOf('S');
            int posTrou = br.readLine().indexOf('H');
            BufferedWriter bw = new BufferedWriter(new FileWriter(FICHIER_NIVEAU));
            if (mouvement == "m") {
                
            }

        } catch (IOException e) {
            System.out.println("Erreur à l'utilisation du fichier : " + e);
        }
        return false;
    }

    /**
     * Initialiser le niveau en l'écrivant dans le fichier.
     */
    public void initLevel() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FICHIER_NIVEAU));
            bw.write("***********************************");
            bw.newLine();
            bw.write("*@      H            H      H     S");
            bw.newLine();
            bw.write("***********************************");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Erreur à l'utilisation du fichier : " + e);
        }
    }

    /**
     * Afficher un niveau stocké dans le fichier.
     */
    public void displayLevel() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHIER_NIVEAU))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Erreur à l'utilisation du fichier : " + e);
        }
    }
}
