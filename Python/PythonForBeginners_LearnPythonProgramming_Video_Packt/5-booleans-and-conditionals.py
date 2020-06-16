# -*- coding: utf-8 -*-

distance=int(input("How far would you like to travel in miles?\n"))


if distance<3:
    method="walking"
elif distance<300:
    method="driving"
else:
    method="flying"
    
print("I suggest {} to your destination.".format(method))
