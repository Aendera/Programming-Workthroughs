def commacode(l):
    for idx,value in enumerate(l):
        if idx==0:
            return_string=str(value)
        elif idx==len(l)-1:
            return_string=return_string+", and "+str(value)
        else:
            return_string=return_string+", "+str(value)
    return return_string

if __name__=="__main__":
    spam = ['apples', 'bananas', 'tofu', 'cats']
    print(commacode(spam))
