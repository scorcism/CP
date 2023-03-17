#!/bin/bash

# Bash Script to add commit and push chnaged files with message
# You use this as an alias 

git add .
git commit -m "$1"
git push