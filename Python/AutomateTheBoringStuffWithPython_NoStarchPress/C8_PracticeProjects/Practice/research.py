 
import re,os

pattern=re.compile(input('Enter re pattern: '))

for file in os.listdir('.'):
    if file[-4:]!='.txt':
        continue #skipping non-txt files,comment if out to search other files as well
    with open(file) as f:
        text=f.read()
        match=pattern.findall(text)
        if match:
            print(file,match)
