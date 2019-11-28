// paramètres du vaisseau et du jeu
int yVaisseau;
int score;
int derniereEtoileTouchee;

// dimensions et emplacement du vaisseau
final int LONGUEUR_VAISSEAU = 40;
final int HAUTEUR_VAISSEAU = 20;
final int X_VAISSEAU = 50;

// étoiles
final int NB_ETOILES = 100;
int[] xEtoile = new int[NB_ETOILES];
int[] yEtoile = new int[NB_ETOILES];
int[] couleurEtoile = new int[NB_ETOILES];

// constantes pour les couleurs des étoiles
final int ETOILE_BLANCHE = 0;
final int ETOILE_VERTE = 1;
final int ETOILE_ROUGE = 2;

////////////////// Fonctions Processing //////////////////////////

/**
 * Initialiser l'application.
 */
void setup() {
  // lancement des tests unitaires
  tousLesTests();
  // paramètres graphiques
  size(400, 300);
  frameRate(60);
  // initialisation des étoiles
  for (int i = 0; i < NB_ETOILES; i++) {
    xEtoile[i] = (int)random(width);
    yEtoile[i] = (int)random(height/2);
    couleurEtoile[i] = (int)random(3);
  }
  // initialisation du vaisseau
  yVaisseau = height / 2;
  // initialisation des paramètres du jeu
  score = 0;
  derniereEtoileTouchee = -1;
}

/**
 * Rafraichir l'écran.
 */
void draw() {
  background(0);
  afficherEtoiles();
  afficherVaisseau();
  miseAJourScore();
  fill(color(255));
  text("Score : " + score, 300, 270);
  text("Dernière étoile touchée : " + derniereEtoileTouchee, 190, 285);
}

/**
 * Traiter l'appui sur une touche.
 */
void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP) {
      yVaisseau += 2;
    }
    if (keyCode == DOWN) {
      yVaisseau -= 2;
    }
  }
}

////////////////// Fonctions propres au jeu //////////////////////////

/**
 * Afficher toutes les étoiles.
 */
void afficherEtoiles() {
  for (int i = 0; i < NB_ETOILES; i++) {
    dessinerEtoile(i); // ou dessinerEtoileAvecFormes(i);
    xEtoile[i]--; // on décale l'étoile vers la gauche
    /* 
    répondre à la question 9 ici
    */
    regenerer(i); // si elle sort par la gauche, on en regénère une à droite
  }
}

// dessiner l'étoile numéro i
void dessinerEtoile(int i) {
    if (etoileToucheVaisseau(i)) {
      derniereEtoileTouchee = i;
      println("étoile touchée : ", i);
      strokeWeight(6);
    } else {
      strokeWeight(2);
    }
    color couleur = color(0);
    switch (couleurEtoile[i]) {
      case ETOILE_BLANCHE: couleur = color(255);
        break;
      case ETOILE_VERTE: couleur = color(0, 255, 0);
        break;
      case ETOILE_ROUGE: couleur = color(255, 0, 0);
        break;
    }
    stroke(couleur);
    point(xEtoile[i], yEtoile[i]);  
}

// dessiner l'étoile numéro i, avec des formes différentes
void dessinerEtoileAvecFormes(int i) {
    int zoom = 1;
    if (etoileToucheVaisseau(i)) {
      derniereEtoileTouchee = i;
      println("étoile touchée : ", i);
      zoom = 2;
    }
    noStroke();
    switch (couleurEtoile[i]) {
      case ETOILE_BLANCHE: 
        fill(color(255));
        ellipse(xEtoile[i], yEtoile[i], 6*zoom, 6*zoom);  
        break;
      case ETOILE_VERTE:
        fill(color(0, 255, 0));
        rectMode(RADIUS);
        rect(xEtoile[i], yEtoile[i], 3*zoom, 3*zoom);  
        break;
      case ETOILE_ROUGE: 
        fill(color(255, 100, 0));
        int diam = 4*zoom;
        quad(xEtoile[i]-diam, yEtoile[i], xEtoile[i], yEtoile[i]+diam, xEtoile[i]+diam, yEtoile[i], xEtoile[i], yEtoile[i]-diam);
        break;
    }
}

/**
 * Afficher le vaisseau.
 */
void afficherVaisseau() {    
  fill(color(255));
  noStroke();
  ellipse(X_VAISSEAU, yVaisseau, X_VAISSEAU - LONGUEUR_VAISSEAU / 2, HAUTEUR_VAISSEAU / 2);
}

/** 
 * Mettre à jour le score.
 */
void miseAJourScore() {
  for (int i = 0; i < NB_ETOILES; i++) {
    if (etoileToucheVaisseau(i)) {
      switch (couleurEtoile[i]) {
        case ETOILE_BLANCHE:
        case ETOILE_VERTE: score++; break;
        case ETOILE_ROUGE: score--; break;
      }
    }
  }
}

/**
 * Tester si une étoile touche le vaisseau (par devant).
 *
 * @param i le numéro de l'étoile
 * @return vrai si l'étoile touche le vaisseau, faux sinon
 */
boolean etoileToucheVaisseau(int i) {
  return 
    xEtoile[i] >= X_VAISSEAU - (LONGUEUR_VAISSEAU / 2) && 
    xEtoile[i] <= X_VAISSEAU + (LONGUEUR_VAISSEAU / 2) && 
    yEtoile[i] >= yVaisseau - (HAUTEUR_VAISSEAU / 2) &&
    yEtoile[i] <= yVaisseau + (HAUTEUR_VAISSEAU / 2);
}

/**
 * Si l'étoile sort de l'écran, on en regénère une à droite.
 *
 * @param i le numéro de l'étoile à considérer
 */
void regenerer(int i) {
}


////////////////////////////// Tests unitaires //////////////////////////////

void tousLesTests() {
  testEtoileToucheVaisseau();
  testMiseAjourScore();
}

/**
 * Tests de la fonction etoileToucheVaisseau.
 */
void testEtoileToucheVaisseau() {
  // touche à droite
  xEtoile[0] = X_VAISSEAU + (LONGUEUR_VAISSEAU / 2);
  yEtoile[0] = yVaisseau;
  assert(etoileToucheVaisseau(0));
  // touche dedans
  xEtoile[0] = X_VAISSEAU;
  yEtoile[0] = yVaisseau;
  assert(etoileToucheVaisseau(0));
  // ne touche pas loin devant
  xEtoile[0] = X_VAISSEAU + LONGUEUR_VAISSEAU;
  yEtoile[0] = yVaisseau;
  assert(!etoileToucheVaisseau(0));
  // ne touche pas au-dessus
  xEtoile[0] = X_VAISSEAU + (LONGUEUR_VAISSEAU / 2);
  yEtoile[0] = yVaisseau + HAUTEUR_VAISSEAU;
  assert(!etoileToucheVaisseau(0));
}

/**
 * Tests de la fonction miseAJourScore.
 */
void testMiseAjourScore() {

  // cas 1 : 
  // l'étoile 0 touche le vaisseau, et elle est verte
  xEtoile[0] = X_VAISSEAU + (LONGUEUR_VAISSEAU / 2);
  yEtoile[0] = yVaisseau;
  couleurEtoile[0] = ETOILE_VERTE;
  // les autres étoiles ne le touchent pas
  for (int i = 1; i < NB_ETOILES; i++) {
    xEtoile[i] = X_VAISSEAU + LONGUEUR_VAISSEAU;
    yEtoile[i] = (int)random(height);
    couleurEtoile[i] = (int)random(3);
  }
  score = 0;
  miseAJourScore();
  assert(score == 1);
  
  // autre(s) cas : à compléter...
}
