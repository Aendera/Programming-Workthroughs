import re

def re_strip(phrase,strip=r'\s'):
    result=re.sub(strip,'',phrase)
    return result

if __name__=="__main__":
    print(re_strip('satoshi Nakamoto','o'))
    
    print(re_strip('satoshi Nakamoto'))
