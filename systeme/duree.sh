#!/bin/bash

function minu 
{
let HEURE=10#$1/100
let MINUTES=10#$1%100

let MINUTESFIN="$HEURE*60 + $MINUTES"

}

minu $1
DEB=$MINUTESFIN
minu $2
ARR=$MINUTESFIN

let RES="$ARR + $DEB"
echo "$RES"
