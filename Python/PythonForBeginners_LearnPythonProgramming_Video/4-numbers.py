# -*- coding: utf-8 -*-
"""
Created on Sat Jun 13 21:33:55 2020

@author: Romain Bettinelli
"""

#Exercise 1
server_price_per_hour=0.51
server_price_per_day=server_price_per_hour*24.0
server_price_per_month=server_price_per_day*30 # Rounding
print("Price per day : {} $".format(server_price_per_day ))
print("Price per month : {} $".format(server_price_per_month ))
print()
print("Price per day for 20 servers: {} $".format(server_price_per_day * 20 ))
print("Price per month for 20 servers: {} $".format(server_price_per_month * 20))
print()
budget=918.0
print(budget/server_price_per_day)
print("Number of days one server can be operated with budget of {} $: {} days (rounded down)".format(
        budget,budget/server_price_per_day))