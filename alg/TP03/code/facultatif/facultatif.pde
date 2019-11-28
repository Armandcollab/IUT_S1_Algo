void intervalle(int a, int b) //<>//
{
  // met a < b
  if (a>b)
  {
    int tmp = 0;
    tmp = a;
    a = b;
    b = tmp;
  }

  int[] entier = new int[b-a];
  int valeur = a;
  int position = 0;

  while (valeur < b)
  {
    entier[position] = valeur;
    valeur++;
    position++;
  }

  position=1;

  while (position < b-a)
  {
    println (entier[position]);
    position++;
  }
}


//retourne le minimum des 4 valeurs données
int minimum(int a, int b, int c, int d)
{
  if (a <= b)
    if (a <= c) 
      if (a <= d)
        return a;
  if (b<=a)
    if (b <= c) 
      if (b <= d)
        return b;
  if (c<=a)
    if (c <= b) 
      if (c <= d)
        return c;
  if (d<=b)
    if (d <= c) 
      if (d <= a)
        return d;
  return 0;
}

//affiche la solution d'un équation du premier degré de parametre a et b
void premmierDegre(float a, float b)
{
  println("x = ", -b/a);
}

//affiche les solutions d'une équation du second degré
void secondDegre(float a, float b, float c)
{
  float d = discriminant(a, b, c);
  if (discriminant(a, b, c) > 0)
    println("x1 = ", (-b-(sqrt (d))/(2*a)), " et x2 = ", (-b+(sqrt (d))/(2*a)));
  else if (discriminant(a, b, c) == 0)
    premmierDegre(a, b);
  else
    println("Pas de solution réel");
}

//renvoie le discriminant
float discriminant(float a, float b, float c)
{
  if (b == 0 && a ==0 && c == 0)
    return -1;
  else
    return b*b-4*a*c;
}

void setup() {
  //intervalle(12, 5);
  //(minimum(0, 0, 0, 0));
  //premmierDegre(5, 8);
  secondDegre(0, 0, 0);
}
