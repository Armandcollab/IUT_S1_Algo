color NOIR = color(0); //<>//

void premierChemin() {

  // Premier chemin
  initForm(width / 3, height / 2, 'W');
  ligne (3);

  turnRight();
  ligne(2);

  turnLeft();
  ligne(5);
}


void deuxiemeChemin() {

  // Deuxième chemin
  initForm(2 * width / 3, height / 2, 'S');
  ligne(10);
  turnLeft();
  goDisplay();
  turnLeft();
  goDisplay();
}

void setup()
{
  size(600, 600);
  background(NOIR);
  //premierChemin();
  //deuxiemeChemin();
  //carre(200,50,5);
  //escalier(10,10,5,5);
  //escargot(width/2,height/2,20);
  zigzag2(width/2,width/2,32);


  //initForm(width/2, height/2, 'N');
}
/*
int i = 0;
final int n = 11;


void draw () {
  /*
  if (i < n-10) { //<>//
    ligne(9);
    randTurn();
    i += 10;
    //arrête le programme lorsque les point sortent du cadre
    if (touchBorder()) {
      println("Perdu ! Touché le bord");
      i = n;
      noLoop();
    }
  }
  if (i >= n-10 && i < n) {
    goDisplay();
    i += 1;
    //arrête le programme lorsque les point sortent du cadre
    if (touchBorder()) { //<>//
      println("Perdu ! Touché le bord");
      i = n;
      noLoop();
    }
  }
  
}
*/
