#!python3
#table print

def printTable(table):
    count=[0]*len(table)
    for col in range(len(table)):
        for row in range(len(table[0])):
            count[col]=max(count[col],len(table[col][row]))
    
    for row in range(len(table[0])):
        for col in range(len(table)):
            print(table[col][row].rjust(count[col]),end=" ")
        print()


if __name__=="__main__":
    tableData = [['apples', 'oranges', 'cherries', 'banana'],
 ['Alice', 'Bob', 'Carol', 'David'],
 ['dogs', 'cats', 'moose', 'goose']]
    printTable(tableData)
