#!/bin/bash
echo Code Postale = $1
grep ";"$1";" insee.csv | cut -d';' -f 1
