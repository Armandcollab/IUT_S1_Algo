package filemanager;

import java.util.Scanner;

/**
 * TP fichiers : jeu ASCII.
 */
class FileManager {

    /**
     * Action principale.
     *
     * @param args arguments de la ligne de commande
     */
   public static void main(String[] args) {
       
        boolean end = false;
        Scanner sc = new Scanner(System.in);
        FileGame f = new FileGame();
        f.initLevel();
        f.displayLevel();
        
        while (!end) {
            String str = sc.nextLine();
            end = f.moveHero(str);
            f.displayLevel();           
        }
        
        System.out.println(" ");
        System.out.println("GAGNE!");
    }
}
