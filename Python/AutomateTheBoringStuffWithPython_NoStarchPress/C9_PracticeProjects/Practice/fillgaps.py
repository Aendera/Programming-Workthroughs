import os,shutil
import re

#Find files with prefix
prefix=input("Enter file prefix: ")
#Find pattern
old_files=[]
for folder,subfolders,filenames in os.walk('.'):
    for filename in filenames:
        if re.match(r"^"+prefix+r"\d\d\d\..{3,4}$",filename):
            print(filename)
            old_files.append(filename)
#Find first number
old_files.sort()#should be first one
number_0=1
ending=old_files[0][old_files[0].find("."):]
#Correct
correct_files=[os.path.join(os.getcwd(),prefix)+"{:03d}".format(number_0+i)+ending 
               for i in range(len(old_files))]
#Continue correcting until end
print(old_files)
print(correct_files)
for i in range(len(old_files)):
    shutil.move(os.path.join(os.getcwd(),old_files[i]),correct_files[i])