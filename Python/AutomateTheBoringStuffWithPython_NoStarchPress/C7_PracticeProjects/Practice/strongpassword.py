import re

def strong(password):
    long=(len(password)>=8)
    u_and_l=re.search(r'[A-Z]',password) and re.search(r'[a-z]',password)
    has_digits=re.search(r'\d',password)
    return bool(long and u_and_l and has_digits)

if __name__=="__main__":
    password="Aristochat1"
    print(password,strong(password))

    password="aristochat1"    
    print(password,strong(password))

    password="Aristochat"
    print(password,strong(password))
