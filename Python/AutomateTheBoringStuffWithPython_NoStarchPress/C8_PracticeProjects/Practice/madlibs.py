import re

file='madlibs.txt'
regex=re.compile(r'(ADJECTIVE|NOUN|ADVERB|VERB)')
with open(file) as f:
    text=f.read()
    matches=re.findall(regex,text)
    replacement_matches=[]
    for idx,item in enumerate(matches):
        if item=='ADJECTIVE':
            replacement=input('Enter an adjective: ')
        elif item=='NOUN':
            replacement=input('Enter a noun: ')
        if item=='VERB':
            replacement=input('Enter a verb: ')
        if item=='ADVERB':
            replacement=input('Enter an adverb:')
        replacement_matches.append(replacement)
    for match in replacement_matches:
        text=re.sub(regex,match,text,count=1)
    with open(file[:-4]+'_edited'+file[-4:],'w') as w:
        w.write(text)
