# -*- coding: utf-8 -*-

def what_does_the_cat_say(speech):
    text_length=len(speech)
    print("       {}".format("_"*text_length))
    print("     < {} >".format(speech))
    print("       {}".format("-"*text_length))
    print("        /")
    print(" /\_/\ /")
    print("( o.o )")
    print(" > ^ <")

if __name__=="__main__":
    user_input=input("What does the cat say?:\n")
    what_does_the_cat_say(user_input)