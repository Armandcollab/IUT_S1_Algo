// variables pour la gestion des jets //<>// //<>//
int NB_JETS_MAX = 100;  // la longueur maximale des séquences de jets
int[] jets1 = new int[NB_JETS_MAX];  // la séquence de jets du joueur 1
int nbJets1 = 0;  // la longueur de la séquence de jets du joueur 1
int[] jets2 = new int[NB_JETS_MAX];  // la séquence de jets du joueur 2
int nbJets2 = 0;  // la longueur de la séquence de jets du joueur 2
int joueurCourant = 1;

// somme des éléments d'une séquence de jets (faces).
int somme(int[] seqJets)
{
  int numJet = 0;
  int som = 0;
  while ( seqJets[numJet] != 1 )
  {
    som += seqJets[numJet];
    numJet++;
  }
  return som;
}

//maximum des éléments d'une séquence de jets (faces).
int maximum(int []seqJets)
{
  int numJet = 0;
  int max = 0;
  while ( seqJets[numJet] != 1 ) {
    if (max < seqJets[numJet]) 
      max = seqJets[numJet];
    numJet++;
  }
  return max;
}


//moyenne des éléments d'une séquence de jets (faces).
float moyenne(int [] seqJets, int numJets)
{  
  if (numJets ==0)
    return -1;
  if (numJets == 1)
    return 0;
  return somme(seqJets) * 1. / (numJets - 1);
}

//nombre de face croissantes suxessive obtenue
int suite(int[] seqJets)
{
  int numJet = 0;
  int compt = 0;
  do { 
    compt += 1;
    numJet++;
  } while ( seqJets[numJet] >= seqJets[numJet-1] );
  return compt;
}


// initialisation
void setup() 
{
  test_somme();
  test_moyenne();
  test_maximum();
  size(640, 200);
  afficherDes();
}

// clic quelque part
void mousePressed() {
  int face = calculerFace(mouseX, mouseY);
  if (face > 0) { // si l'utilisateur a cliqué sur une face
    afficherDes(); // on affiche le fond
    if (joueurCourant == 1) {
      jets1[nbJets1] = face;
      nbJets1++;
      afficherJets(jets1, nbJets1, 1); 
      afficherJets(jets2, nbJets2, 2);
    } else {
      jets2[nbJets2] = face;
      nbJets2++;
      afficherJets(jets1, nbJets1, 1); 
      afficherJets(jets2, nbJets2, 2);
    }
        if (face == 1) {
      finSequence();
    }
  }
}

// afficher la séquence
void afficherJets(int[] jets, int nbJets, int numJoueur) {
  int ySeq = 0; // y pour l'affichage de la séquence de jets
  if (numJoueur == 1) {
    ySeq = 20;
  } else if (numJoueur == 2) {
    ySeq = 50;
  }
  text("séquence joueur " + numJoueur+ " : ", 30, ySeq);
  int jet = 0;
  while (jet < nbJets) {
    text(jets[jet], 20 * jet + 160, ySeq);
    jet++;
  }
}

//affiche verdict
void afficherVerdict(float scoreJoueur1, float scoreJoueur2) {
  int gagnant = 0;
  if (scoreJoueur1 == scoreJoueur2) {
    text("Pas de gagnant, égualité", 300, 180);
  } else {
    if (scoreJoueur1 > scoreJoueur2) {
      gagnant = 1;
    } else if (scoreJoueur1 < scoreJoueur2) {
      gagnant = 2;
    }
    text("Gagnant : joueur " + gagnant, 300, 180);
  }
}

// afficher le score
void afficherScore(float score, int numJoueur) {
  int yScore = 0;
  if (numJoueur == 1) {
    yScore = 170;
  } else   if (numJoueur == 2) {
    yScore = 190;
  }
  text("score joueur " + numJoueur+  " = " + score, 30, yScore);
}

// gérer la fin d'une séquence de jets (une fois le 1 saisi).
void finSequence() {
  if (joueurCourant == 1 ) {
    joueurCourant = 2;
  } else {
    afficherScore(suite(jets1), 1);
    afficherScore(suite(jets2), 2);
    afficherVerdict(suite(jets1), suite(jets2));
    nbJets2 = 0; // nouvelle séquence
    nbJets1 = 0;
    joueurCourant = 1;
  }
}
void draw() {
} // requis par mousePressed()
