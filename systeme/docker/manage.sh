#!/bin/bash
# Author: Romain Giot <romain.giot@u-bordeaux.f>
# Date: September 2017
# Licence: GPL
#
# Script de création de la machine Docker pour le TP de l'étuidant concerné



TAG=$USERNAME:tpadmin
TPDIR=$(pwd)

DOCKER=$(which docker)
DOCKER="sudo $DOCKER"

cd /tmp

case $1 in
build)
  echo $TPDIR/Dockerfile
	if ! test -e $TPDIR/Dockerfile
	then
		echo "[ERREUR] le fichier Dockerfile n'est pas présent"
		exit -1
	fi
	
	cp $TPDIR/Dockerfile .
	$DOCKER build -t $TAG .
;;

run)
	$DOCKER run --rm=true --interactive -t $TAG
;;


free-space)
	$DOCKER rm $($DOCKER ps -qa) # Suppression des instances de conteneurs (des autres étudiants éventuellement)
	$DOCKER rmi $($DOCKER images -qa) # Suppression des images de conteneurs (des autres étudiants éventuellement)
	;;

*)

	echo "[ERREUR] les seules commandes acceptées sont run et build"
esac

