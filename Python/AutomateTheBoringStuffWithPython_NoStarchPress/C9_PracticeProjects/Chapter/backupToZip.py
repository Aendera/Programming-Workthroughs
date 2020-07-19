 
#! python3
# backupToZip.py - Copies an entire folder and its contents into
# a ZIP file whose filename increments.

import zipfile,os

def backupToZip(folder):
    ## Backup the entire contents of "folder" into a ZIP file.

    folder=os.path.abspath(folder)
    # Figure out the filename this code should use based on
    # what files already exist.
    number=1
    while True:
        zipFilename=os.path.basename(folder)+'_'+str(number)+'.zip'
        if not os.path.exists(zipFilename):
            break
        number+=1

    #create zip file
    print('Creating {}...'.format(zipFilename))
    backupZip=zipfile.ZipFile(zipFilename,'w')
    #walk entire folder tree and compress files in each folder
    for foldername,subfolders,filenames in os.walk(folder):
        print('Adding files in {}...'.format(foldername))
        #Add curr folder to zip file
        backupZip.write(foldername)
        #Add all files in folder to ZIP
        for filename in filenames:
            newBase=os.path.basename(folder)+'_'
        if filename.startswith(newBase) and filename.endswith('.zip'):
            continue #Don't backup backup zips
        backupZip.write(os.path.join(foldername,filename))
    backupZip.close()
    print('Done')

backupToZip('cats')
