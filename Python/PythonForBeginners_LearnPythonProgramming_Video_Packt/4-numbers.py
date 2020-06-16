# -*- coding: utf-8 -*-

#Exercise 1
server_price_per_hour=0.51
server_price_per_day=server_price_per_hour*24.0
server_price_per_month=server_price_per_day*30 # Rounding
print("Price per day : {:.2f} $".format(server_price_per_day ))
print("Price per month : {:.2f} $".format(server_price_per_month ))
print()
print("Price per day for 20 servers: {:.2f} $".format(server_price_per_day * 20 ))
print("Price per month for 20 servers: {:.2f} $".format(server_price_per_month * 20))
print()
budget=918.0
print(budget/server_price_per_day)
print("Number of days one server can be operated with budget of {0:.2f} $: {1:.0f} days (rounded down)".format(
        budget,budget/server_price_per_day))