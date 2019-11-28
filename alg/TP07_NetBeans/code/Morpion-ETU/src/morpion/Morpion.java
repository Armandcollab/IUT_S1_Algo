package morpion;

import java.util.Scanner;

/**
 * Classe pour le jeu du morpion.
 */
class Morpion {

    /**
     * Scanner pour lire sur l'entrée standard.
     */
    static Scanner sc = new Scanner(System.in);

    /**
     * Fonction principale.
     *
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {

        int[][] grille = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int taille = 3;
        int nb_joueurs = 2;
        boolean gagne, fini;
        int nb_coups, joueur;
        int ligne, colonne;

        initialiserGrille(taille, grille);
        afficherGrille(taille, grille);

        nb_coups = 0;
        joueur = nb_joueurs;
        do {
            joueur = changerJoueur(joueur, nb_joueurs);
            System.out.println("Joueur " + joueur + " (" + carac(joueur) + ")");
            boolean continuer;
            do {
                System.out.println("Entrez votre position (ligne puis colonne) :");
                ligne = lireCoordonnee();
                colonne = lireCoordonnee();
                continuer = !inGrille(ligne, colonne, taille)
                        || !caseVide(ligne, colonne, grille);
            } while (continuer);

            poserJeton(ligne, colonne, joueur, grille);
            nb_coups++;
            afficherGrille(taille, grille);
            gagne = estGagne(ligne, colonne, grille, taille);
            fini = estFini(nb_coups, taille);

        } while (!gagne && !fini);

        if (gagne) {
            System.out.println("Victoire du joueur " + joueur);
        } else {
            System.out.println("Partie Nulle");
        }
    }

    /**
     * Lire une coordonnée saisie par l'utilisateur. Vous n'avez pas à
     * comprendre ce code.
     *
     * @return l'entier saisi
     */
    static int lireCoordonnee() {
        int entierSaisi = 0;
        boolean saisieCorrecte = false;
        do {
            try {
                entierSaisi = sc.nextInt();
                saisieCorrecte = (entierSaisi >= 0 && entierSaisi <= 2);
            } catch (java.util.InputMismatchException e) {
                System.err.println("Saisie incorrecte, saisissez un entier.");
                sc.next();
            }
        } while (!saisieCorrecte);
        return entierSaisi;
    }

    /**
     * Initialise une grille, c'est-à-dire met 0 dans chacune de ses cases.
     *
     * @param taille taille de la grille carrée, supérieure à 0
     * @param grille tableau 2D d'entiers. Chaque case vaut : -1 si non
     * initialisée, 0 si vide, 1 si le joueur 1 a posé son pion dessus, 2 si le
     * joueur 2 a posé son pion dessus.
     */
    static void initialiserGrille(int taille, int[][] grille) {
        int lig, col;
        for (lig = 0; lig < taille; lig++) {
            for (col = 0; col < taille; col++) {
                grille[lig][col] = 0;
            }
        }
    }

    /**
     * Passe au joueur suivant et revient au premier joueur lorsque tout les 
     * joueur sont passés.
     * 
     * @param joueur
     * @param nbjoueurs
     * @return 
     */
    static int changerJoueur(int joueur, int nbjoueurs) {
        return (joueur % nbjoueurs +1);
    }

    /**
     * Met le numéro du joueur dans la case qu'il à séléctionné.
     * 
     * @param lig
     * @param col
     * @param joueur
     * @param grille 
     */
    static void poserJeton(int lig, int col, int joueur, int[][] grille) {
        grille[lig][col] = joueur;
    }

    /**
     * Retourne vrai si une ligne est complète, faux sinon.
     * 
     * @param lig
     * @param taille
     * @param grille
     * @return 
     */
    static boolean isLigneComplete(int lig, int taille, int[][] grille) {
        boolean ligneComplete = true;
        int col = 1;
        while (ligneComplete && col < taille) {
            if (grille[lig][col] != grille[lig][0] || grille[lig][0] == 0 || grille[lig][col] == 0) {
                ligneComplete = false;
            }
            col++;
        }
        return ligneComplete;
    }

    /**
     * Retourne vrai si une colonne est complète, faux sinon.
     * 
     * @param col
     * @param taille
     * @param grille
     * @return 
     */
    static boolean isColonneComplete(int col, int taille, int[][] grille) {
        boolean colonneComplete = true;
        int l = 1;
        while (colonneComplete && l < taille) {
            if (grille[l][col] != grille[0][col] || grille[l][col] == 0 || grille[0][col] == 0) {
                colonneComplete = false;
            }
            l++;
        }
        return colonneComplete;
    }

    /**
     * Retourne vrai si la diagonale directe est compléte, faux sinon.
     * 
     * @param taille
     * @param grille
     * @return 
     */
    static boolean isDiagonaleD(int taille, int[][] grille) {
        boolean diag = true;
        int i = 1;
        while (diag && i < taille) {
            if ((grille[i][i] != grille[0][0]) || (grille[i][i] == 0)) {
                diag = false;
            }
            i++;
        }
        return diag;
    }

    /**
     * Retourne vrai si la diagonale indirecte est complète, faux sinon.
     * 
     * @param taille
     * @param grille
     * @return 
     */
    static boolean isDiagonaleI(int taille, int[][] grille) {
        boolean diag = true;
        int i = 0;
        while (diag && i < taille) {
            if ((grille[i][taille -1 - i] != grille[0][taille -1]) || (grille[i][taille -1 - i] == 0)) {
                diag = false;
            }
            i++;
        }
        return diag;
    }

    /**
     * Retourne vrai si une des deux diagonale est complète, faux sinon.
     * 
     * @param lig
     * @param col
     * @param taille
     * @param grille
     * @return 
     */
    static boolean diagonaleComplete(int lig, int col, int taille, int[][] grille) {
	if (col == lig && col!=0 && col!=taille-1) {
            return (isDiagonaleD(taille, grille) && isDiagonaleI(taille, grille));
        } else if (col == lig) {
            return isDiagonaleD(taille, grille); // test diagonale directe
        } else if (col == taille - 1 - lig) {
            return isDiagonaleI(taille, grille); // test diagonale indirecte
        } else {
            return false; // lig,col pas sur une diagonale
        }
    }

    /**
     * Retourne vrai si un joueur à gagné, faux sinon. Donc à une ligne ou une 
     * colonne ou une diagonale de pleine.
     * 
     * @param lig
     * @param col
     * @param grille
     * @param taille
     * @return 
     */
    static boolean estGagne(int lig, int col, int[][] grille, int taille) {

        return (isLigneComplete(lig, taille, grille)
                || isColonneComplete(col, taille, grille)
                || diagonaleComplete(lig, col, taille, grille));
    }

    /**
     * retourne vrai si la grille est pleine, faux sinon.
     * 
     * @param n
     * @param taille
     * @return 
     */
    static boolean estFini(int n, int taille) {
        return (n == taille * taille);
    }

    /**
     * Retorune un caractère d'affichage suivant le numéro du joueur.
     * 
     * @param n
     * @return 
     */
    static char carac(int n) {
        char c;
        switch (n) {
            case 0:
                c = ' ';
                break;
            case 1:
                c = 'X';
                break;
            case 2:
                c = 'O';
                break;
            case 3:
                c = '*';
                break;
            default:
                c = 'E'; // erreur = carac pas dispo
                break;
        }
        return c;
    }

    /* Affichage
    |   |  
 ---+---+---
    |   |  
 ---+---+---
    |   |  
     */
    /**
     * Affiche les lignes de la grille.
     * 
     * @param taille 
     */
    static void afficherLigneSep(int taille) {
        System.out.print(" ");
        for (int i = 0; i < taille - 1; i++) {
            System.out.print("---+");
        }
        System.out.println("---");
    }

    /**
     * Affiche les colonnes de la grille.
     * 
     * @param lig
     * @param taille
     * @param grille 
     */
    static void afficherLigne(int lig, int taille, int[][] grille) {
        System.out.print(" ");
        for (int col = 0; col < taille - 1; col++) {
            System.out.print(" " + carac(grille[lig][col]) + " |");
        }
        System.out.println(" " + carac(grille[lig][taille - 1]));
    }

    /**
     * Affiche la grille complète.
     * 
     * @param taille
     * @param grille 
     */
    static void afficherGrille(int taille, int[][] grille) {
        System.out.println(" ");
        for (int lig = 0; lig < taille - 1; lig++) {
            afficherLigne(lig, taille, grille);
            afficherLigneSep(taille);
        }
        afficherLigne(taille - 1, taille, grille);
        System.out.println("");
    }

    /**
     * Retourne vrai si la case testée est vide, faux sinon.
     * 
     * @param lig
     * @param col
     * @param grille
     * @return 
     */
    static boolean caseVide(int lig, int col, int[][] grille) {
        return (grille[lig][col] == 0);
    }

    /**
     * Retourne vrai si les valeurs correspondes à une case dans le tableaux,
     * faux sinon.
     * 
     * @param lig
     * @param col
     * @param taille
     * @return 
     */
    static boolean inGrille(int lig, int col, int taille) {
        return !(lig < 0 || lig >= taille || col < 0 || col >= taille);
    }
}
