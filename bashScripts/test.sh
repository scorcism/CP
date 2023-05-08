#!/bin/bash

#Define the string value
file="$1"

# Set space as the delimiter
IFS=' '

#Read the split words into an array based on space delimiter
read -a strarr <<< "$file"

#Count the total words
echo "File $1"

javac $1
java ${strarr[1]}

# Print each value of the array by using the loop
for val in "${strarr[1]}";
do
  printf "$val\n"
done