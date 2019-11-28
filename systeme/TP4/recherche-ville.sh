#!/bin/bash
echo Commune choisie = $1
grep $1';' insee.csv
