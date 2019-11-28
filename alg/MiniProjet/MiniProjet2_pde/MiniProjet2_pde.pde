int vaisseauX, vaisseauY;
int vitesseX, vitesseY;
void setup () {
  size(300, 200); //La taille de l'éllipse est fixer au lancement du programme, donc la taille est identique pendant toute cette durée
  noStroke (); // enlève l'affichage de la bordure du cercle
  vaisseauX = 30;
  vaisseauY = 100;
  vitesseX = 1;
  vitesseY = -1;
}
void draw() {
  background(0); //permet d'éviter les trsainées
  ellipse(vaisseauX, vaisseauY, 50, 15);
  vaisseauX += vitesseX;
  vaisseauY += vitesseY;
  if (vaisseauX <0) {
    vaisseauX = width;
  }
  if (vaisseauX >width) {
    vaisseauX = 0;
  }
  if (vaisseauX <0) {
    vaisseauX = width;
  }
  if (vaisseauX <0) {
    vaisseauX = width;
  }
}
void mousePressed() {
  vitesseX = - vitesseX;
  vitesseY = - vitesseY;
}
void mouseDragged() {
  vaisseauX = mouseX;
  vaisseauY = mouseY;
}
