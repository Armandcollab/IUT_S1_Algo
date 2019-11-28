#!/bin/bash

function minu 
{
let HEURE=10#$1/100
let MINUTES=10#$1%100

let MINUTESFIN="$HEURE*60 + $MINUTES"
return "$MINUTESFIN"
}
