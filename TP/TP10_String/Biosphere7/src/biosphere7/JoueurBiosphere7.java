package biosphere7;

import static biosphere7.Utils.CAR_VIDE;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Joueur implémentant les actions possibles à partir d'un plateau, pour un
 * niveau donné.
 */
public class JoueurBiosphere7 implements IJoueurBiosphere7 {

    /**
     * Nombre maximal d'actions possibles, tous niveaux confondus.
     */
    final static int MAX_NB_ACTIONS = 35285;

    /**
     * Vitalité sur le plateau.
     */
    String vitalite = ",0,0";

    /**
     * Compte le nombre d'actions possibles déjà entrées dans le tableau des
     * actions possibles.
     */
    int nbActions;

    /**
     * Cette méthode renvoie, pour un plateau donné et un joueur donné, toutes
     * les actions possibles pour ce joueur.
     *
     * @param plateau le plateau considéré
     * @param couleurJoueur couleur du joueur
     * @param niveau le niveau de la partie à jouer
     * @return l'ensemble des actions possibles
     */
    @Override
    public String[] actionsPossibles(Case[][] plateau, char couleurJoueur, int niveau) {
        // afficher l'heure de lancement
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        System.out.println("actionsPossibles : lancement le "
                + format.format(new Date()));
        // calculer les actions possibles
        String actions[] = new String[MAX_NB_ACTIONS];
        nbActions = 0;
        for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
            for (int col = 0; col < Coordonnees.NB_COLONNES; col++) {
                Coordonnees coord = new Coordonnees(lig, col);
                calculVitalite(plateau, couleurJoueur, 'P', coord, niveau);
                if (plateau[lig][col].espece == Utils.CAR_VIDE) {
                    ajoutActionPommier(coord, actions);
                }
            }
        }
        if (niveau >= 3) {
            Coordonnees coordsCasePourVoisin = new Coordonnees(-1, -1);
            for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
                for (int col = 0; col < Coordonnees.NB_COLONNES; col++) {
                    if (plateau[lig][col].espece != CAR_VIDE) {
                        coordsCasePourVoisin.ligne = lig;
                        coordsCasePourVoisin.colonne = col;
                        calculVitalite(plateau, couleurJoueur, 'C', coordsCasePourVoisin, niveau);
                        ajoutActionCouper(coordsCasePourVoisin, actions);
                    }
                }
            }
        }
        System.out.println("actionsPossibles : fin");
        return Utils.nettoyerTableau(actions);
    }

    /**
     * Calcul le total de vitalité des arbres par joueurs sur le plateau suivant
     * l'action et les renvoi
     *
     * @param plateau le plateau considéré
     * @param couleurJoueur couleur du joueur
     * @return la vitalité des arbre rouge, bleu
     */
    void calculVitalite(Case[][] plateau, char couleurJoueur, char action, Coordonnees coordCase, int niveau) {
        vitalite = null;
        int bleu = 0;
        int rouge = 0;
        for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
            for (int col = 0; col < Coordonnees.NB_COLONNES; col++) {
                if (plateau[lig][col].espece != CAR_VIDE) {
                    if (plateau[lig][col].couleur == Utils.CAR_ROUGE) {
                        rouge += plateau[lig][col].vitalite;
                    } else if (plateau[lig][col].couleur == Utils.CAR_BLEU) {
                        bleu += plateau[lig][col].vitalite;
                    }
                }
            }
        }
        Coordonnees[] coordVoisin = arbreVoisins(plateau, coordCase);

        if (action == 'P') {            // quand on plante un pommier
            if (couleurJoueur == Utils.CAR_ROUGE) {
                rouge++;
                if (niveau >= 4) {
                    for (int i = 0; i < 4; i++) {
                        if (coordVoisin[i].ligne != -1 && coordVoisin[i].colonne != -1
                                && plateau[coordVoisin[i].ligne][coordVoisin[i].colonne].couleur == couleurJoueur) {
                            rouge++;
                        }
                    }

                }

            } else if (couleurJoueur == Utils.CAR_BLEU) {
                bleu++;
                if (niveau >= 5) {
                    for (int i = 0; i < 4; i++) {
                        if (coordVoisin[i].ligne != -1 && coordVoisin[i].colonne != -1 
                                && plateau[coordVoisin[i].ligne][coordVoisin[i].colonne].couleur == couleurJoueur) {
                            bleu++;
                        }
                    }
                }
            }

        } else if (action
                == 'C') {     // quand on coupe un arbre
            if (coordCase.ligne < Coordonnees.NB_LIGNES && coordCase.ligne >= 0 && coordCase.colonne < Coordonnees.NB_COLONNES && coordCase.colonne >= 0) {
                Case caseCentrale = plateau[coordCase.ligne][coordCase.colonne];

                if (caseCentrale.espece != CAR_VIDE && caseCentrale.couleur == Utils.CAR_BLEU) {
                    bleu -= caseCentrale.vitalite;

                } else if (caseCentrale.espece != CAR_VIDE && caseCentrale.couleur == Utils.CAR_ROUGE) {
                    rouge -= caseCentrale.vitalite;

                }

                for (int i = 0; i < 4; i++) {
                    if (coordVoisin[i].ligne != -1 && coordVoisin[i].colonne != -1) {
                        if (plateau[coordVoisin[i].ligne][coordVoisin[i].colonne].couleur == Utils.CAR_BLEU
                                && plateau[coordVoisin[i].ligne][coordVoisin[i].colonne].vitalite < 9) {
                            bleu++;
                        } else if (plateau[coordVoisin[i].ligne][coordVoisin[i].colonne].couleur == Utils.CAR_ROUGE
                                && plateau[coordVoisin[i].ligne][coordVoisin[i].colonne].vitalite < 9) {
                            rouge++;
                        }
                    }
                }
            }
        }

        vitalite = ("," + rouge + "," + bleu);
    }

    /**
     * A partir d'une case vérifie si les cases voisines contiennent un arbre et
     * retorune leurs coordonnées
     *
     * @param plateau le plateau considéré
     * @param coord coordoné de la case dont on vas chercher les arbres voisins
     * @return un tableau contenant les coordonées de arbres voisons si il y en
     * as, sinon -1,-1
     */
    Coordonnees[] arbreVoisins(Case[][] plateau, Coordonnees coord
    ) {
        Coordonnees[] coordsVoisins = new Coordonnees[4]; // 4 correspond au nombre de voisins possibles maximum

        Coordonnees coordsTmp1 = new Coordonnees(coord.ligne + 1, coord.colonne);
        Coordonnees coordsTmp2 = new Coordonnees(coord.ligne - 1, coord.colonne);
        Coordonnees coordsTmp3 = new Coordonnees(coord.ligne, coord.colonne + 1);
        Coordonnees coordsTmp4 = new Coordonnees(coord.ligne, coord.colonne - 1);

        coordsVoisins[0] = regardeSiArbre(plateau, coordsTmp1);

        coordsVoisins[1] = regardeSiArbre(plateau, coordsTmp2);

        coordsVoisins[2] = regardeSiArbre(plateau, coordsTmp3);

        coordsVoisins[3] = regardeSiArbre(plateau, coordsTmp4);

        return coordsVoisins;
    }

    /**
     * Retourne les coordonés d'une case si elle n'est pas vide
     *
     * @param plateau le plateau considéré
     * @param coord coordonnées de la case à regarder
     * @return lex coordonées de la case si il possède un arbre, sinon des
     * coordonnées nul
     */
    Coordonnees regardeSiArbre(Case[][] plateau, Coordonnees coord
    ) {
        if (coord.ligne < Coordonnees.NB_LIGNES && coord.ligne >= 0
                && coord.colonne < Coordonnees.NB_COLONNES && coord.colonne >= 0) {
            if (plateau[coord.ligne][coord.colonne].espece != CAR_VIDE) {
                return coord;
            }
        }
        return (new Coordonnees(-1, -1));
    }

    /**
     * Ajout d'une action de plantation de pommier dans l'ensemble des actions
     * possibles.
     *
     * @param coord coordonnées de la case où planter le pommier
     * @param actions l'ensemble des actions possibles (en construction)
     */
    void ajoutActionPommier(Coordonnees coord, String[] actions
    ) {
        String action = "P" + coord.carLigne() + coord.carColonne() + vitalite;
        actions[nbActions] = action;
        nbActions++;
    }

    /**
     * Ajout d'une action de coupe d' arbre dans l'ensemble des actions
     * possibles.
     *
     * @param coord coordonnées de la case où planter le pommier
     * @param actions l'ensemble des actions possibles (en construction)
     */
    void ajoutActionCouper(Coordonnees coord, String[] actions
    ) {
        String action = "C" + coord.carLigne() + coord.carColonne() + vitalite;
        actions[nbActions] = action;
        nbActions++;
    }
}
