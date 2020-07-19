#! python3
# renameDates.py - Renames filenames with American MM-DD-YYYY date format
# to European DD-MM-YYYY.

import shutil,os,re

datePattern=re.compile(r"""^(.*?) #all text before date
((0|1)?\d)- #1-2 digits for month
((0|1|2|3)?\d)- #one are two digits for dat
((19|20)\d\d) #four digits for year
(.*?)$ #all text after date
""",re.VERBOSE)

#Loop over files in working directory
for amerFilename in os.listdir('.'):
    mo=datePattern.search(amerFilename)

    #Skip files without date
    if mo==None:
        continue
    
    #Get diff parts of filename
    beforePart=mo.group(1)
    monthPart=mo.group(2)
    dayPart=mo.group(4)
    yearPart=mo.group(6)
    afterPart=mo.group(8)
    
    #Form Europe-Style filename
    euroFilename=beforePart+dayPart+'-'+monthPart+'-'+yearPart+afterPart
    #Get abs file paths
    absWorkingDir=os.path.abspath('.')
    amerFilename=os.path.join(absWorkingDir,amerFilename)
    euroFilename=os.path.join(absWorkingDir,euroFilename)
    #Rename files
    print('Renaming "{}" to "{}"...'.format(amerFilename,euroFilename))
    #shutil.move(amerFilename,euroFilename)
