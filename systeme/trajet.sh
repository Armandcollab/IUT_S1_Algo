#/bin/bash

DEPART=$(./minutes.sh $1)
ARRIVEE=$(./minutes.sh $1)

let TOTAL="ARRIVEE - DEPART"
let HH=$TOTAL/60
let MM=$TOTAL%60
echo "$HH$MM"
