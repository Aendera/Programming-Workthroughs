# -*- coding: utf-8 -*-
"""
Created on Sat Jun 13 21:49:41 2020

@author: Romain Bettinelli
"""
def user_input():
    """Takes a noun, a verb and an adjective as input from the user"""
    noun=input("Enter a noun : ")
    verb=input("Enter a verb : ")
    adjective=input("Enter an adjective : ")
    return noun,verb,adjective

def fill_in_the_blanks(noun,verb,adjective):
    """Completes a "short story" with a noun, a verb and an adjective"""
    print("The {} {} {} on the bank of the river.".format(
            adjective,noun,verb))
    
fill_in_the_blanks(*user_input())