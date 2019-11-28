#!/bin/bash
FOLDER="$1"

du -s "$FOLDER"/* 2>/dev/null | sort -g | tail -5 | tac
