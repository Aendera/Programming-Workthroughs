import os
import shutil

filetype="."+input("Enter a file ending: ")
newfolder="copytarget"

if not os.path.exists(newfolder):
    os.mkdir(newfolder)
curr_file,destination=[],[]
for folder,subfolder,filenames in os.walk('.'):
    for filename in filenames:
        #print(filename)
        if filename.endswith(filetype): 
            curr_file.append(os.path.join(os.getcwd(),filename))
            destination.append(os.path.join(os.getcwd(),newfolder,filename))

#keeping move in walk works successfully once but results in file not found error
for i in range(len(curr_file)):
     print(curr_file[i])
     print(destination[i])
     shutil.move(curr_file[i],destination[i])
            