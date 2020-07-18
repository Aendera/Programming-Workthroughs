#! python3
# phoneAndEmail.py - Finds phone numbers and email addresses on the clipboard.
import pyperclip,re

phoneRegex=re.compile(r'''(
    (\d{3}|\(\d{3}\))? #area code
    (\s|-|\.)? #separator
    (\d{3})#middle three
    (\s|-|\.) #separator
    (\d{4}) #last 4 d
    (\s*(ext|x|ext.)\s*(\d{2,5}))? #extension
    )''',re.VERBOSE)

#TODO:Create email regex
emailRegex=re.compile(r'''(
    [a-zA-z0-9._%+-]+ #username
    @
    [a-zA-Z0-9.-]+ #domain name
    (\.[a-zA-Z]{2,4})
    )''',re.VERBOSE)
#TODO:Find matches in clipboard
text=str(pyperclip.paste())
matches=[]
for groups in phoneRegex.findall(text):
    phoneNum='_'.join([groups[1],groups[3],groups[5]])
    if groups[8]!='':
        phoneNum+=' x'+groups[8]
    matches.append(phoneNum)
for groups in emailRegex.findall(text):
    matches.append(groups[0])
#TODO:COpy results to clipboard
if len(matches)>0:
    pyperclip.copy('\n'.join(matches))
    print('Copied to clipboard:')
    print('\n'.join(matches))
else:
    print('No phone numbers or email addresses found.')
