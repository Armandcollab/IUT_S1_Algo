int[] listeTempe;

int n = 5;


//tirage des température aléatoire entre -10 et 40
void tempAleatoire(int n)
{
  int tour = 0;
  listeTempe = new int[n];
  while ( tour < n ) {
    listeTempe[tour] = (int)random(51)-10;
    tour++;
  }
}

//somme de toutes les températures
int somme(int[] listeTempe)
{
  int tmp = 0;
  int som = 0;
  while ( n > tmp )
  {
    som += listeTempe[tmp];
    tmp++;
  }
  return som;
}

//maximum températures
int maximum(int []listeTempe)
{
  int tmp = 0;
  int max = 0;
  while ( n > tmp ) {
    if (max < listeTempe[tmp]) 
      max = listeTempe[tmp];
    ++tmp;
  }
  return max;
}



//minimum des températures.
int minimum(int []listeTempe)
{
  int tmp = 0;
  int min = 0;
  while ( n > tmp ) {
    if (min > listeTempe[tmp]) 
      min = listeTempe[tmp];
    ++tmp;
  }
  return min;
}


//moyenne des températures
float moyenne(int [] listeTempe, int tour)
{  
  if (tour ==0)
    return -1;
  if (tour == 1)
    return 0;
  return somme(listeTempe) * 1. / (n);
}






void setup()
{
  tempAleatoire(n);  
  /*
  int tmp = 0;
  while ( n > tmp ) {
    println(listeTempe[tmp]);
    ++tmp;
  }
  */
  
//affichage de la température maximum, minimum et de la moyenne
  println("Maximum : ", maximum(listeTempe), "°C");
  println("Minimum : ", minimum(listeTempe), "°C");
  println("Moyenne : ", moyenne(listeTempe, n), "°C");
}
