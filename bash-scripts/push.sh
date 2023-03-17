#!/bin/bash

# Bash Script to add commit and push chnaged files with message
# You use this as an alias 

git add .
echo "########## Git add DONE ##########"
echo "Commit Message: $1 "
git commit -m "$1"
echo "########## git commit DONE ##########"
git push
echo "########## git push DONE ##########"
