# -*- coding: utf-8 -*-
"""
Created on Sat Jun 13 21:44:16 2020

@author: Romain Bettinelli
"""

distance=int(input("How far would you like to travel in miles?\n"))

method="error"#placeholder
if distance<3:
    method="walking"
elif distance<300:
    method="driving"
else:
    method="flying"
    
print("I suggest {} to your destination.".format(method))
