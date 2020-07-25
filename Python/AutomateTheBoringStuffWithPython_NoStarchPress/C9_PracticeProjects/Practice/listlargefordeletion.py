import os
import shutil

size_lim=100
for folder,subfolder,filenames in os.walk('.'):
    for filename in filenames:
        file=os.path.abspath(os.path.join(folder,filename))
        size=int(os.path.getsize(file))
        if size>size_lim:
            print(file)
            print(size)
