# -*- coding: utf-8 -*-
"""
Created on Sun Jun 14 07:28:49 2020

@author: user
"""

def print_dict(people):
    """Displays dictionary facts"""
    for person in people:
        print("{}: {}".format(person,people[person]))

people={"Jeff":"Is afraid of clowns.",
        "David":"Plays the piano.",
        "Jason": "Can fly an airplane."}
print_dict(people)
print()

people["Jeff"]="Is afraid of heights"
people["Jill"]="Can hula dance."
print_dict(people)