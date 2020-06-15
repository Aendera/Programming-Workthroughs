# -*- coding: utf-8 -*-

 #Exercise 1
 
with open('file.txt') as file:
    count=0
    for line in file:
         count+=1
         print("{}: ".format(count),line.rstrip())

 #Exercise 2
with open('animals.txt') as file:
    sorted_animals=sorted(file.readlines())

with open('sorted_animals.txt','w') as file:
    file.writelines(sorted_animals)