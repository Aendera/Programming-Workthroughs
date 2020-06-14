# -*- coding: utf-8 -*-

airports=[("O'Hare International Airport","ORD"),
          ("Los Angeles International Airport","LAX"),
          ("Dallas/Fort Worth International Airport","DFW"),
          ("Denver International Airport","DEN")]
for airport in airports:
    name,code=airport
    print("The code for {} is {}.".format(name,code))