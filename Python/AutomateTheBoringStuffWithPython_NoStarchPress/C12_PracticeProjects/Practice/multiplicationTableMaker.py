import sys, openpyxl

#get number from command line
number=int(sys.argv[1])

wb=openpyxl.Workbook()
sheet=wb.active
for c in range(1,number+1):
    cell=chr(65+c) +str(1)
    sheet[cell]=c
    
for r in range(1,number+1):
    cell="A" +str(r+1)
    sheet[cell]=r

for c in range(1,number+1):
    for r in range(1,number+1):
        cell= chr(65+c)+str(r+1)
        sheet[cell]=c*r
        
wb.save("{}x{}_multiplication_table.xlsx".format(number,number))