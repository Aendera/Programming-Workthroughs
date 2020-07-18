def displayInventory(inventory):
    print('Inventory:')
    count=0
    for item in inventory.items():
        print('{} {}'.format(*item[::-1]))
        count+=item[1]
    print('Total number of items: {}'.format(count))

def addToInventory(inventory,addedItems):
    for item in addedItems:
        if item in inventory:
            inventory[item]+=1
        else:
            inventory[item]=1
    return inventory

if __name__=="__main__":
    stuff = {'rope': 1, 'torch': 6, 'gold coin': 42, 'dagger': 1, 'arrow': 12}
    displayInventory(stuff)
    inv = {'gold coin': 42, 'rope': 1}
    print()
    dragonLoot = ['gold coin', 'dagger', 'gold coin', 'gold coin', 'ruby']
    inv = addToInventory(inv, dragonLoot)
    displayInventory(inv)
