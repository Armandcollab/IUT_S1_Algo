#############################################################################
#																			#
#					   Principe du tetris en python						  	#
#																			#
#############################################################################
#																			#
#	 coord_courante [0,3]													#
#		  |																	#
#  [[0,0,0,*,0,0,0,0,0,0],		  [[0,1,0,0],	 [[1,1,1,1],				#
#   [0,0,0,0,0,0,0,0,0,0],		   [0,1,0,0],	  [0,0,0,0],				#
#   [0,0,0,0,0,0,0,0,0,0],		   [0,1,0,0],	  [0,0,0,0],				#
#   [0,0,0,0,0,0,0,0,0,0],		   [0,1,0,0]]	  [0,0,0,0]]				#
#   [0,0,0,0,0,0,0,0,0,0],			 piece		   piece					#
#   [0,0,0,0,0,0,0,0,0,0],		  (position 1)	(position 2)				#
#   [0,0,0,0,0,0,0,0,0,0],	1/ On initialise la coordonnee courante de		#
#   [0,0,0,0,0,0,0,0,0,0],	   deplacement et on choisi une piece.			#
#   [0,0,0,0,0,0,0,0,0,0],	2/ On appel la methode chargee de descendre		#
#   [0,0,0,0,0,0,0,0,0,0],	la piece ligne par ligne a une vitesse donnee.  #
#   [0,0,0,0,0,0,0,0,0,0],	3/ Avant chaque deplacement on efface la piece  #
#   [0,0,0,0,0,0,0,0,0,0],	   dans la matrice.								#
#   [0,0,0,0,0,0,0,0,0,0],	4/ On verifie si le deplacement est possible	#
#   [0,0,0,0,0,0,0,0,0,0],	5/ Si oui : suivant le deplacement la			#
#   [0,0,0,0,0,0,0,0,0,0],				coordonnee courante change et on	#
#   [0,0,0,0,0,0,0,0,0,0],				imprime la piece dans la matrice	#
#   [0,0,0,0,0,0,0,0,0,0],	   Si non : on imprime la piece dans la matrice #
#   [0,0,0,0,0,0,0,0,0,0],				a sa coordonnee courante inchangee  #
#   [0,0,0,0,0,0,0,0,0,0],	6/ Si le deplacement n'est plus possible en		#
#   [0,0,0,0,0,0,0,0,0,0]]	   descente on verifie si une ou plusieurs		#
#		tab_grille			  ligne se sont formees.						#
#	   (la matrice)		  7/ Retour en 1/								  	#
#																			#
#############################################################################


from tkinter import *
from time import sleep
from random import *
import pygame


def defpiece():
	global piece,tab_couleur,piecen,piecenn,Piecen1,Piecen2
	tab_couleur=['wheat','red','green','yellow','pink','black','#FFFFFF','#FFA500','#90EE90']


	piece1 = [[(0,1,0,0),(0,1,1,0),(0,0,1,0),(0,0,0,0)], # 0 1 0 0
			 [(0,0,0,0),(0,0,1,1),(0,1,1,0),(0,0,0,0)],	 # 0 1 1 0
			 [(0,1,0,0),(0,1,1,0),(0,0,1,0),(0,0,0,0)],	 # 0 0 1 0
			 [(0,0,0,0),(0,0,1,1),(0,1,1,0),(0,0,0,0)]]	 # 0 0 0 0

	piece2 = [[(0,0,0,0),(0,2,2,0),(0,2,2,0),(0,0,0,0)], # 0 0 0 0
			 [(0,0,0,0),(0,2,2,0),(0,2,2,0),(0,0,0,0)],	 # 0 2 2 0
			 [(0,0,0,0),(0,2,2,0),(0,2,2,0),(0,0,0,0)],	 # 0 2 2 0
			 [(0,0,0,0),(0,2,2,0),(0,2,2,0),(0,0,0,0)]]	 # 0 0 0 0

	piece3 = [[(0,3,0,0),(0,3,0,0),(0,3,0,0),(0,3,0,0)], # 0 3 0 0
			 [(0,0,0,0),(3,3,3,3),(0,0,0,0),(0,0,0,0)],	 # 0 3 0 0
			 [(0,3,0,0),(0,3,0,0),(0,3,0,0),(0,3,0,0)],	 # 0 3 0 0
			 [(3,3,3,3),(0,0,0,0),(0,0,0,0),(0,0,0,0)]]	 # 0 3 0 0

	piece4 = [[(0,0,4,0),(0,4,4,0),(0,4,0,0),(0,0,0,0)], # 0 0 4 0
			 [(0,0,0,0),(0,4,4,0),(0,0,4,4),(0,0,0,0)],	 # 0 4 4 0
			 [(0,0,4,0),(0,4,4,0),(0,4,0,0),(0,0,0,0)],	 # 0 4 0 0
			 [(0,0,0,0),(0,4,4,0),(0,0,4,4),(0,0,0,0)]]	 # 0 0 0 0

	piece5 = [[(0,5,0,0),(0,5,5,0),(0,5,0,0),(0,0,0,0)], # 0 5 0 0
			 [(0,0,0,0),(0,0,5,0),(0,5,5,5),(0,0,0,0)],	 # 0 5 5 0
			 [(0,0,0,5),(0,0,5,5),(0,0,0,5),(0,0,0,0)],	 # 0 5 0 0
			 [(0,5,5,5),(0,0,5,0),(0,0,0,0),(0,0,0,0)]]	 # 0 0 0 0

	piece6 = [[(0,0,6,0),(0,0,6,0),(0,6,6,0),(0,0,0,0)], # 0 0 6 0
			 [(0,0,0,0),(0,6,0,0),(0,6,6,6),(0,0,0,0)],	 # 0 0 6 0
			 [(0,6,6,0),(0,6,0,0),(0,6,0,0),(0,0,0,0)],	 # 0 6 6 0
			 [(0,0,0,0),(0,6,6,6),(0,0,0,6),(0,0,0,0)],] # 0 0 0 0

	piece7 = [[(0,8,0,0),(0,8,0,0),(0,8,8,0),(0,0,0,0)], # 0 8 0 0
			 [(0,0,0,0),(0,8,8,8),(0,8,0,0),(0,0,0,0)],	 # 0 8 0 0
			 [(0,8,8,0),(0,0,8,0),(0,0,8,0),(0,0,0,0)],	 # 0 8 8 0
			 [(0,0,0,0),(0,0,0,8),(0,8,8,8),(0,0,0,0)]]	 # 0 0 0 0

#	piece = [[(1,1,1,1),(1,1,1,1),(0,0,0,0),(0,0,0,0)],	 # 1 1 1 1
#			 [(1,1,0,0),(1,1,0,0),(1,1,0,0),(1,1,0,0)],	 # 1 1 1 1
#			 [(1,1,1,1),(1,1,1,1),(1,1,1,1),(1,1,1,1)],	 # 1 1 1 1
#			 [(1,1,1,1),(1,1,1,1),(1,1,1,1),(1,1,1,1)]]	 # 1 1 1 1

	ListePiece = [piece1,piece2,piece3,piece4,piece5,piece6,piece7]
	
	try:
		if piece == 0:
			piece = 0
		else:
			piece = Piecen1
	except NameError:
		piece = choice(ListePiece)
#si piece n'est pas définit choisi une piece au hasard sinon transforme la piece en la suivante

	Piecen1 = choice(ListePiece)
#choisi une piece au hasard pour n+1



#-------------------------------------------------------------------------------
def initialisation():
	""" Creation du tableau de canevas 20 lignes 10 colonnes et de sa matrice
		associee.Definition d'une piece et de ses 2 positions."""
	global tab_can,tab_can2,tab_grille,tab_grille2,coord_courante,vitesse,vitesse_courante,nbr_ligne,niveau,test_notice,button,photo0,photo1,testmusique

	nbr_ligne = 0
#mise à 0 du compteur de ligne complété
	niveau = 1
#mise à 1 du niveau
	vitesse_courante = 300
	vitesse = vitesse_courante
#vitesse de descente de la pièce
	defpiece()

	test_notice = 0
#indicateur de la fenêtre notice
	tab_can=[]
	tab_grille=[]
	for i in range(20):
		tab_can.append([[]]*10)
		tab_grille.append([[]]*10)

	grille_jeu = Frame(fen)
	for ligne in range(20):
		for colonne in range(10):
			couleur = tab_couleur[0]
			tab_can[ligne][colonne] = Canvas(grille_jeu,bg=couleur,height=20,
										   width=20,borderwidth=1,relief=RIDGE)
			tab_can[ligne][colonne].grid(row=ligne,column=colonne)
			tab_grille[ligne][colonne] = 0
	grille_jeu.grid(row=0,column=0)

#création d'une grille de 10 cases sur 20 qui correspond à l'espace de jeu.

#musique
	pygame.mixer.init()
	music = pygame.mixer.music.load("musique.ogg")
	pygame.mixer.music.play()
	pygame.mixer.music.set_volume(0.1)
#lance la musique , définit son volume
	testmusique = 1
#définit la variable musique comme allumée : 1

	photo0 = PhotoImage(file="soundoff.png")
	photo1 = PhotoImage(file="soundon.png")
#défini les image musique éteinte et allumé qui s'afficheron sur le bouton



	tab_can2=[]
	tab_grille2=[]
	for i in range(4):
		tab_can2.append([[]]*4)
		tab_grille2.append([[]]*4)

	grille_menu = Canvas(Menu)
	for ligne in range(4):
		for colonne in range(4):
			couleur = tab_couleur[0]
			tab_can2[ligne][colonne] = Canvas(grille_menu,bg=couleur,height=20,
										   width=20,borderwidth=1,relief=RIDGE)
			tab_can2[ligne][colonne].grid(row=ligne,column=colonne)
			tab_grille2[ligne][colonne] = 0
	grille_menu.pack(side=TOP, padx=50, pady=5)

#création d'une grille de quatres cases sur quatres qui correspond à l'affichage de la pièce suivante.

	button = Button(Menu, image=photo1,command = musique)
	button.pack(side=TOP, padx=5, pady=5)
#crée le bouton, lui assigne l'image allumé et la commande pour gérer la musique



	fen.bind('<Right>',droite)
	fen.bind('<Left>',gauche)
	fen.bind('<Up>',tourne)
	fen.bind('<Down>',vite)
	fen.bind('<KeyRelease-Down>',vite_relache)
	fen.bind('<space>',piece_change)
#associe les actions au touches du clavier

	maj_Grille()
	nouvelle_Piece()

#-------------------------------------------------------------------------------
def nouvelle_Piece():
	""" C'est par le biais de coord_courante que l'on va se deplacer
		dans la matrice soit horizontalement (gauche:dx=-1,droite:dx=1)
		soit verticalement (descente:dy=1).Sens represente la position de la
		piece dans le tableau contenant la piece courante."""
	global coord_courante,sens

	defpiece()
	coord_courante = [0,3]
	sens = 0
	sleep(1)
	if not verif_Deplacement(0,0,0):
		imprime_Piece(sens)
		print ("Perdu")
		fen.destroy()
	else:
		descente()
		imprime_PieceMenu()

#-------------------------------------------------------------------------------
def descente():
	"""On efface la piece et on teste si elle peut descendre toutes les 250ms.
	Dans le cas contraire on la reinscrit a sa position courante et on verifie
	si une ou plusieurs lignes se sont formees."""
	global vitesse

	efface_Piece()
	if verif_Deplacement(1,0,0):
		coord_courante[0] += 1
		imprime_Piece(sens)
		fen.after(vitesse,descente)
	else :
		imprime_Piece(sens)
		efface_PieceMenu()
		verif_Ligne()
		nouvelle_Piece()
#-------------------------------------------------------------------------------
def vite(event):

	global vitesse

	vitesse = 10

def vite_relache(event):

	global vitesse,vitesse_courante

	vitesse = vitesse_courante

#-------------------------------------------------------------------------------
def gauche(event):
	"""On efface la piece et on verifie si elle peut se deplacer vers la gauche.
	Dans le cas contraire on la reinscrit a sa position courante."""
	efface_Piece()
	if verif_Deplacement(0,-1,0):
		coord_courante[1] -=1
		imprime_Piece(sens)
	else:
		imprime_Piece(sens)

#-------------------------------------------------------------------------------
def droite(event):
	"""On efface la piece et on verifie si elle peut se deplacer vers la droite.
	Dans le cas contraire on la reinscrit a sa position courante."""
	efface_Piece()
	if verif_Deplacement(0,1,0):
		coord_courante[1] += 1
		imprime_Piece(sens)
	else:
		imprime_Piece(sens)

#-------------------------------------------------------------------------------
def tourne(event):
	"""On efface la piece et on verifie si on peut la faire tourner.
	Dans le cas contraire on la reinscrit a sa position courante."""
	global sens

	efface_Piece()
	if verif_Deplacement(0,0,1):
		sens += 1
		if sens == 4:
			sens = 0
		imprime_Piece(sens)
	else:
		imprime_Piece(sens)

#-------------------------------------------------------------------------------
def efface_Piece():
	""" Avant n'importe lequel des deplacements on commence par effacer la piece
		de la matrice. Pour ceci on se place dans la matrice a la coord_courante,
		et on boucle en ligne et en colonne dans la piece.(coord_courante
		represente le coin superieur gauche de la piece).Si la valeur de la
		piece dans une colonne donnee vaut zero on passe a la colonne suivante
		pour ne pas effacer les blocs preexistants.
		Dans le cas contraire son emplacement dans la matrice est mis a zero."""
	for i in range(4):
		for j in range(4):
			if piece[sens][i][j] == 0:
				continue
			tab_grille[coord_courante[0]+i][coord_courante[1]+j] = 0

#-------------------------------------------------------------------------------
def imprime_Piece(sens):
	"""Meme principe que efface_Piece(), cependant ici on passe les coordonnees
	   dans la matrice a la valeur de la piece."""
	for i in range(4):
		for j in range(4):
			if piece[sens][i][j] == 0:
				continue
			tab_grille[coord_courante[0]+i][coord_courante[1]+j] = piece[sens][i][j]
	maj_Grille()

#-------------------------------------------------------------------------------
def imprime_PieceMenu():

	for i in range(4):
		for j in range(4):
			if Piecen1[0][i][j] == 0:
				tab_grille2[i][j] = 0
			else:
				tab_grille2[i][j] = Piecen1[0][i][j]
	maj_Grille2()
#-------------------------------------------------------------------------------
def piece_change(event):
	global Piecen1,Piecen2,piece,sens
	
	if verif_Changement():
		efface_Piece()
		efface_PieceMenu()
#efface la pice dans la grille de jeu et dans la grille de menu
		Piecen2 = Piecen1
		Piecen1 = piece
		piece = Piecen2
#échange la piece du jeu avec la suivante
		imprime_Piece(sens)
		imprime_PieceMenu()
#		print('possible')
#réaffiche la pièce suivante dans la grille de Menu
	else:
		print('impossbile')
#-------------------------------------------------------------------------------	
	
def efface_PieceMenu():

	for i in range(4):
		for j in range(4):
			tab_grille2[i][j] = 0
#-------------------------------------------------------------------------------
def verif_Deplacement(dy,dx,pivot):
	"""La piece a ete effacee, on cherche maintenant a savoir si on peut la
	   reinscrire vers la droite, vers la  gauche, vers le bas ou la faire
	   tourner.Prenons l'exemple d'une translation vers la droite.
	   On cherche d'abord a savoir si la piece ne sera pas en dehors de la
	   matrice.Pour cela on se place a la coord_courante dans la matrice + le
	   decalage(dx=1),et on boucle en ligne et en colonne dans la piece.
	   Pour une ligne donnee,lorsque la coord_courante+dx+incrementation en
	   colonne dans la piece depassent la limite de la matrice en largeur, on
	   verifie la valeur de la colonne correspondante a cette incrementation
	   dans la piece.Si elle vaut zero on poursuit l'incrementation, dans le cas
	   contraire on renvoie un deplacement non possible a la methode appelante.
	   Si la piece ne "deborde" pas, on multiplie la valeur de la coordonnee de
	   la piece par celles de la matrice a la coordonnee correspondante d'apres
	   la incrementations effectuees.Si le produit est non nul, un bloc est deja
	   present donc on renvoie un deplacement non possible."""
	rotation = sens + pivot
	if rotation == 4 :
		rotation = 0
	for i in range(4):
		for j in range(4):
			if coord_courante[1]+(dx+j) > 9 or coord_courante[1]+(dx+j) < 0 or coord_courante[0]+(dy+i) > 19:
				if piece[rotation][i][j] != 0:
					return False
				else:
					continue
			if (piece[rotation][i][j] * tab_grille[coord_courante[0]+(dy+i)] [coord_courante[1]+(j+dx)]) != 0:
				return False
	return True

#-------------------------------------------------------------------------------

def verif_Changement(): 
	for i in range(4):
		for j in range(4):
			if coord_courante[1]+(j) > 9 or coord_courante[1]+(j) < 0 or coord_courante[0]+(i) > 19:
				if Piecen1[sens][i][j] != 0:
					#print('a')
					print(Piecen1)
					return False
				else:
					#print('aa')
					return True
			else:
				#print('aaa')
				return True

def verif_Ligne():

	global nbr_ligne,niveau,vitesse_courante,vitesse

	"""Appelee apres chaque pose de piece, cette methode verifie par recursivite
	si au moins une ligne a ete construite.On se deplace ligne par ligne de par
	le bas dans la matrice.Par defaut la ligne est consideree complete.Pour
	chaque ligne on verifie chaque colonnes. Si la valeur de la matrice a cette
	coordonnee vaut zero la ligne n'est pas complete et on passe a la ligne
	suivante. Lorsqu'une ligne est complete on la supprime, on rajoute une ligne
	de "zero" en premier indice et on refait une verification de par le bas."""
	for ligne in range(19,-1,-1):
		ligne_complete = True
		for colonne in range(10):
			if tab_grille[ligne][colonne] == 0:
				ligne_complete = False

		if ligne_complete:
			del tab_grille[ligne]
			tab_grille[0:0] = [[0,0,0,0,0,0,0,0,0,0]]
			nbr_ligne = int(nbr_ligne) + 1
			print (nbr_ligne)

#		compte le nombre de ligne compléter
#		si > 9 remet le compteur à 0 et augmente le niveau et la vitesse
#		de descente des pieces

			if nbr_ligne > 10 :
#				print ("niveau up")
				niveau = niveau + 1
				vitesse_courante = vitesse_courante - 25
				vitesse = vitesse_courante
				print (vitesse)
				nbr_ligne = 0


			maj_Grille()
			verif_Ligne()

#-------------------------------------------------------------------------------
def maj_Grille():
	"""Mise a jour des canevas en fonction des couleurs referencees par les
	valeurs de la matrice."""
	for ligne in range(20):
		for colonne in range(10):
			couleur = tab_couleur[tab_grille[ligne][colonne]]
			tab_can[ligne][colonne].configure(bg=couleur)
			#séléctione une case, prend sa valuer et définit sa couleur en fonction.

	fen.update()

#-------------------------------------------------------------------------------
def maj_Grille2():

	for ligne in range(4):
		for colonne in range(4):
			couleur = tab_couleur[tab_grille2[ligne][colonne]]
			tab_can2[ligne][colonne].configure(bg=couleur)
			#séléctione une case, prend sa valuer et définit sa couleur en fonction.

	fen.update()

#-------------------------------------------------------------------------------
def musique():

	global testmusique

	if testmusique == 1:
		testmusique = 0
		#Test si la variable musique est sur 1, si elle l'est, la met sur 0
		pygame.mixer.music.pause()
		#met la musique en pause
		button.config(image=photo0)
		#change l'image du bouton musique sur l'image éteinte
		#print("stop")


	elif testmusique == 0:
		testmusique = 1
		#Test si la variable musique est sur 0, si elle l'est, la met sur 1
		pygame.mixer.music.unpause()
		#relance la musique
		button.config(image=photo1)
		#change l'image du bouton musique sur l'image allumée
		#print("unpause")
#-------------------------------------------------------------------------------
def nouvellefen ():
	global test_notice,fen1
	if test_notice == 0:
		fen1 = Toplevel()
		fen1.title("Notice")
		img_notice = PhotoImage(file='menuimage.png')
		label = Label(fen1,image=img_notice)
		label.image = img_notice
		label.grid()
		test_notice = 1
		
		
	else :
		fen1.destroy()
		test_notice = 0


fen = Tk()
fen.wm_geometry(newGeometry='+220+0')
fen.resizable(0,0)

Menu = Canvas(fen,width=200,height=500)
Menu.grid(row=0,column=1)

button2 = Button(fen, text='menu', command = nouvellefen)
button2.grid(row=0,column=2)




initialisation()
fen.mainloop()

