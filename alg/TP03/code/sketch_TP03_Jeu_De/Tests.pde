// tests de la fonction somme()
void test_somme()
{
  println("--- Test somme ---");
  int s;

  int[] j1 = {4, 2, 5, 1};
  s = somme(j1);
  assert(s==11);

  int[] j2 = {1};
  s = somme(j2);
  assert(s==0);
}

// tests de la fonction moyenne()
void test_moyenne()
{
  println("--- Test moyenne ---");
  float m;

  int[] j1 = {4, 2, 5, 1};
  m = moyenne(j1, 4);
  println(abs(m-11./4));
  println(11./3);
  println(m);
  assert(abs(m-11./3)< 1E-4);

  int[] j2 = {1};
  m = moyenne(j2, 1);
  assert(m==0);
  
  int[] j3 = {};
  m = moyenne(j3, 1);
  assert(m==0);
}

void test_maximum()
{
  println("--- Test maximum ---");
  int m;

  int[] j1 = {4, 2, 5, 1};
  m = maximum(j1);
  assert(m==5);

  int[] j2 = {1};
  m = maximum(j2);
  assert(m==0);
  
  
  int[] j3 = {4, 2, 1, 1};
  m = maximum(j3);
  assert(m==4);

}
