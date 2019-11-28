#!/bin/bash

FICHIER=telephones.dat
NUMERO="$1"
NOM="$2"

echo "$NUMERO $NOM" >> $FICHIER
