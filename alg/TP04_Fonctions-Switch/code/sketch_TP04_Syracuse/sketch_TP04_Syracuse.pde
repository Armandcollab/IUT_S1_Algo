void setup() //<>//
{
  background(0);
  size(600,600);
  stroke(255);
  strokeWeight(2);
  int u_n;
  boolean vol_atteint;
  int k = 0;
  int alt = -1;
  // premier terme de la suite (valeur entière positive)
  u_n = (int)random(1, 100);
  print(u_n, " ");

  // calcul des termes suivants
  vol_atteint = (u_n == 1);
  while (!vol_atteint) {
    if (alt < u_n){
      alt = u_n;
    }
    
    line(k*10,(float)u_n,10*(k+1), (float)suivant(u_n));
    u_n = suivant(u_n);
    print(u_n, " ");
    k +=1;
    if( u_n == 1 ){
      vol_atteint = true;
      println();
      println("Lonhueur de vol : k = ",k);
      println("altitude maximal du vol : alt = ", alt);
    }
  }
}

// terme suivant de la suite
int suivant(int n)
{
  int res;
  if (n%2 == 0) {
    res = n/2;
  } else {
    res = 3*n + 1;
  }
  return res;
}
