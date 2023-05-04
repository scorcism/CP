#!/bin/bash

# Bash Script to add commit and push chnaged files with message
# You use this as an alias 

echo "START"
git add .
git commit -m "$1"
echo "commit $1 ##########"
git push
echo "END"

