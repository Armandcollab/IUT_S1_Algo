#!/bin/bash

FICHIER=telephones.dat
NOM="$1"

grep " $NOM" $FICHIER
