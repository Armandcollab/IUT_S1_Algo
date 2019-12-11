# I Fonctionnement d'un Terminale #
 
 1. saisie de la commande
 2. interpreter la commande
 3. executer la commande \
(boule)
    
    
        >prompt: man (commande)

manuelle commande ```man```

option courte : en bleu \
**...** de 0 a ++ 

- \-lettre
- \-- mot

> on peut regrouper les -l -a -r en -lar

### recherche dans manuelle ##


    man geany

    /version
    n
    n
    N

**/** pour rechercher \
**n** pour passer a l'occurence suivante

## Auto completion ##

touche **tabulation** :

- si ambiguité ```tab tab```
- sinon simple ```tab```


## Navigation dans le repertoire ##

- où je suis ```pwd```
- voire le contenue ```ls```
- *acceder* au fichier ```cd```
- creer un dossier vide ```touch```
- *creer* un reépertoire ```mkdir``` 

  
> -p pour creer un repertoir de chemin

- *supprimer* un répertoire ```rmdir```
- *déplacer* et *renommer* un dossier ```mv```
  
- afficher le contenue :
  - d'un petit fichier ```cat```
  - d'un gros fichier ```less```

# II MetatCharactères #

- " **```*```** " emplace n'importe quelle chaine de charactères

- " **```?```** " remplace n'importe quelle caractère
  
- " **```[]```** " liste de charactère
  - " **```[a-c]```** " lise de charactère entre a et c
  - " **```[abc]```** " lise de charactère a b ou c



<p style = 'color:blue; font-size:50px'>#########scp######ssh########

# **I processus** #

```
entrée standard(clavier) --> processus ----->sortie standard(terminal) 
                                | 
                                 ------> sortie d'erreur(terminal)
```

## changer de sortie ##

- utilisation ">" \
redirige la sortie standard vers un .txt 
```
ls ~>/tmp/ls.txt
```

- utilisation ">>" \
ajoute après ce qui est deja écrit dans un txt
```
ls ~>>/tmp/ls.txt
```


## changer d'entrée ##

- utilisation "<"
```
bc < bc.txt "
```

- utilisation "<<"
```
bc << EOF
6+5
4*2
3*8
EOF > fichier .txt
```
<p style='color:grey'> cree un fichier en live </p>

## gestion de sortie vers une entré d'un autre processus ##

' **|** ' 
```
ls -l ~|wc -l 
```

> On peut faire un *pipe line de commande* (mettre plusieurs pipe à la suite)

exemple :
```
anytopnm < Capture.png | pnmscale -pixels 100 | pnmtojpeg > sauvegarde.jpeg
```

## sortie d'erreur ##

**2>** le deux correspond à la sortie d'erreur
> javac test.java 2> bug.txt

    
## encodage de caractère ##

code **ascii** : 
- 7 bites (taille fixe)
- américains (pas accents...)

code **UTF-8** : 
- touts les caractères
- prend plus de place 
  - vérification sur le premier bit de chaue octet si il faut contnuer sur l'octet suivant
  - taille variable en otet
- diificulté pour aller au n éme caractère ( blogation de lire tout les caractères)


# **Permissions** #

= droits d'accés

3 catégories d'utilisateurs : 
- propriétaires / user **```u```** 
- groupe / group **```g```** 
- autres / others **```o```** 

9 droits droits :
- lecture / read **```r```** 
- écriture / write **```w```** 
- éxecution **```x```**

ex : ```ls -l```
- premier caractère " " 
- neuf caractères " r w x " ( ou --- )
  - trois premier **propriétaires**
  - trois suivants **groupe**
  - trois suivants **autres**

stocké en nombre ( base 8 ) parce que 2³ possibilité de droit par catégorie

> rw-r--r-- \
> 644

## Modifier les droits ##

> chmod (nbr ex : 644) fichier

chmod adaptable au -r

> chmod (symbole,symbole,symbole) fichier

utilisateur | modification | droits
|:------------:|:--------------:|:----------:|
u | + | r
g | - | w
o | = | x
a |   |

> chown login fichier 

change le propriétaires

> chgrp groupe fichier

change le groupe


## Liste à controle d'accés ##

permet de donner des droits précis à un utilisateur précis 

Petit + après les droits rwx ( donc indique que c'est *acl* qui contrôle les droits et pas *unix* )

trois premiers : mes droits \
trois suivants : les droits que je peut donner \
trois derniers : les droits pour les autres

> getfacl fichier

donne les droits du fichier

> setfacl -n u:login:rwx fichier

donner un droit (m = modifier)


## chifre un ficier ##
ccrypt

> ccrypt -e monfichier 

oppenssl 
- mdp
- clé pub/pri


# join #
# script #
 ## écrire ##
#!/bin/bash \
selectionne le systeme d'exploitation dans /bin/bash \

les # sont pour les commentaires

## éxécuter ## 

``` bash
$ bash ./script.sh
```

``` bash
$ chmod +x script.sh
$ ./script.sh
```
# **<span style='color:red;text-decoration:underline'> Variables </span>** # 

utilisable dans les scrits
- ```HOME``` chemin du repertorie perso est dedans
- ```PWD``` chemin du repertoire courant
- ```SHELL``` chemin vers le shell
- ```USERNAME``` permet de connaitre l'utilisateur qui execute le script
- ```HOSTNAME``` le nom de la machine
- ```PATH``` enssemble des chemin dans lequels le système d'exploitation va regarder si la commande se trouve ()
- ```LANG``` langue et encodage 

### écrire ###
```bash
variable=valeur 
```
> <span style='color:grey'>attention pas d'espace à côté du égale</span> 

- ### lire ###

``` bash
echo $variable
echo ${varaible}
```

- ### suprimmer ###

```bash

```
## <span style='color:red'> tableaux </span> ##

- ### déclarer un tableau ###
```bash
declare -a pays
```

- ### écrire / ajouter ###
```bash
pays[0] = France
```

- ### accéder ###
```bash
${pays[0]}
```
```bash
i=0
j=1
echo football : ${pays[$i]} contre ${pays[$j]}
```

## <span style='color:red'> variables utiles </span> ##

1. $# = 4 <span style='color:grey'> – le nombre de paramètres </span>
2. $* = Hanoi Paris Bordeaux Ho Chi Minh City
3. $@ = Hanoi Paris Bordeaux **"** Ho Chi Minh City **"**
4. $0 = "./mon-script" <span style='color:grey'>– le nom du script </span>

> ### <span style='color:darkred'> $10 n'éxiste pas ! </span> ###

on fait un décalage avec :
``` bash
shift
```
## <span style='color:red'> informations sup </span> ##

Pour les noms de variables :

1. Noms de variable
2. lettres, des chiffres, blancs soulignés
3. ne commence pas par un chiffre
4. MAJUSCULES/minuscules différenciées

affectation :

1. NOM=CHAINE
2. NOM=EXPRESSION

Avec ```let``` commande let pour affacter les résultats des calculs / commandes dans une variable

```bash
let c=a+b
```

## <span style='color:red'>lecture de variables </span> ##

demander la valeur d'une variable

```bash
read nom prenom
```
demande à écrire le nom et le prenom

## <span style='color:red'> Lire le résultat d'une commande </span> ##

```bash
echo "il y a $(commande) de personne connectées"
```
Il repmplacera $(commande) par le résultat de la commande.

> `` peuvent replacer $() \
> mais à ne pas utiliser !



>Différence entre ' et "\
>' ne change rien de ce qui est contenue \
> ex : '$USER' donne $USER et non aclaveau
# **<span style='color:red;text-decoration:underline'> Fonctions </span>** # 

- Syntaxe
  1. écrire
```bash
function nom-de-la-fonction
{
  ...

}
```
  2. appeler- Générer les fichiers PDF/HTML : ./blog.sh construire

```bash
nom-de-la-fonction paramètre(s)

```
>comme une commande quelconque

# **<span style='color:red;text-decoration:underline'> Processus </span>** #

- stopper un programme en avant plan (foreground)

```
Ctrl + Z
```
- mettre un programme en avant plan (foreground)

```bash
fg xclock
```
- mettre / lancer un programme en arrière plan (background)

```bash
bg xclock
```
```bash
xclock &
```
utiliser une variable pour y "mettre" le processus / stocker son PID
```bash
svgd=$!
```
pstree (arbre des processus lancé)\
jobs (savoir les processus en arrière plan)

kill ()\
wait

# **<span style ='color:red;text-decoration:underline'> structures de controles </span>**

## Case ##

semblable au ```switch```

```bash
case "$format" in
gz)
  #action lors du cas ou format = gz ;;
normal | "")
  #action lors du cas normal | "" ;;
*)
  #action pour tout les autres cas ;;
```
## For ##

```bash
for VAR in LISTE
do
  ...
done
```

## Code De Retour ## 

stocké dans ``` $? ```

si tout ce passe bien = 0 

```bash
exit 42
```

## If then else fi #
```bash
if m=b
then
  action
else
  action2
fi
```

## test ##

```bash
test -f "nom_du_fichier"
```

Test si le fichier existe !

> p128 diapo : autres conditions

## enchainement conditionnelle ##

```&&``` la deuxième est exécutée si la première réussi \
```||``` la deuxième est éxécutée si la première ne réussi pas

```bash
première commande && deuxième
première commande || deuxième
```

## whlie test do done ## 
ex : 
```bash
#!/bin/bash

i=1
f=1

while test $i -le $1
do
  let f=f*i
  let i++
done

exho $f
```

## while read ##

> lecture d'un fichier ligne par ligne numéro prend la valeur première colonne ... 
```bash 
while read numero nom
do
  printf "| %12 | %-30s |\n" $numero "$nom"
done < annuaire.txt
```

## break ##

>sortir d'une boucle



# ***notes*** #

```tr A-Z a-z```  pour maj = min \
mettre un ; entre deux instructions sur une ligne \
ctrl + d (quiter)
