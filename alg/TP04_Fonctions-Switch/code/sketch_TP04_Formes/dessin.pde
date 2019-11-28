void ligne(int n) {
  for (int i = 0; i<n; ++i)
    goDisplay();
}

void carre(int x, int y, int n) {
  initForm(x, y, 'W');
  for (int i = 0; i < 4; ++i) {
    turnLeft();
    ligne (n-1);
  }
}

void dessinMarche(int n) {
  ligne(n-1);
  turnLeft();
  ligne(n-1);
  turnRight();
}
void escalier(int x, int y, int n, int nbmarches) {
  initForm(x, y, 'S');
  for (int i = 0; i < nbmarches; ++i) {
    dessinMarche(n);
  }
}

void escargot (int x, int y, int n) {
  initForm(x, y, 'W');
  ligne(1);
  for (int i = 2; i < n+1; ++i) {
    turnRight();
    print('r');
    ligne(i);
  }
}

void randTurn() {
  int r = (int)random(2);
  if (r==0) {
    turnLeft();
  } else {
    turnRight();
  }
}

void zigzag(int x, int y, int n) {
  initForm(x, y, 'N');
  int i = 0;
  if (i < n-10) {
    for (int o =0; (o+10) < n; o += 10) {
      ligne(10);
      randTurn();
      i += 10;
    }
  } 
  print(i);
  if (i < n) {
    ligne (n-i);
    i =+ n-i;
  }
}


void zigzag2(int x, int y, int n) {
  initForm(x, y, 'N');
  int i = 0;
  if (i < n-10) {
    for (int o =0; (o+10) < n; o += 10) {
      ligne(10);
      randTurn();
      i += 10;
      //arrête le programme lorsque les point sortent du cadre
      if (touchBorder()) {
        println("Perdu ! Touché le bord");
        i = n;
        break;
      }
    }
  }
  if (i < n) {
    int rest = n-i;
    for (int o =0; (o+1) < rest; o += 1) {
      goDisplay();
      i += 1;
      //arrête le programme lorsque les point sortent du cadre
      if (touchBorder()) {
        println("Perdu ! Touché le bord");
        i = n;
        break;
      }
    }
  }
}

boolean touchBorder() {
  if (posY < 0 || posY > height || posX <0 || posX > width) {
    return true;
  } else {
    return false;
  }
}
