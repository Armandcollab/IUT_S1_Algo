/* //  Partie 1 //<>//
float Ox, Oy;

void setup(){
  frameRate(60); 
  Ox = (int)random(100);
  Oy = (int)random(100);
}

void draw(){
  stroke(0, random(256), 0);
  background(0);
  line( Ox, Oy, random(100), random(100));
} // tourne en boucle
*/


//Partie 2 et 3

/*
int vaisseauX;
int vaisseauY;
int vitesse;
void setup () {
  size(300,200); //La taille de l'éllipse est fixer au lancement du programme, donc la taille est identique pendant toute cette durée
  noStroke (); // enlève l'affichage de la bordure du cercle
  vaisseauX = 30;
  vaisseauY = 100;
  vitesse = 1;
}
void draw(){
  background(150); //permet d'éviter les trsainées
  ellipse(vaisseauX, 100, 50, 15);
  vaisseauX = vaisseauX + vitesse;
}
void mousePressed(){
  vitesse = - vitesse;
}
void mouseDragged(){
  vaisseauX = mouseX;
  vaisseauY = mouseY;
}
*/

//Partie 4

int origineX;
int origineY;
void setup(){
  size(330,200);
  origineX = width/2;
  origineY = height;
  background(180, 234, 234);
}
void draw(){}

void mousePressed(){
  line(origineX, origineY, mouseX, mouseY);
  ellipse(mouseX, mouseY, 30, 30);
  fill(random(256), random(256), random(256));
}
