# -*- coding: utf-8 -*-

tasks=[]
task="placeholder"

while task:
    task=input("Enter a task for your to-do list. Press <enter> when done: ")
    if task:
        tasks.append(task)
        print("Task added.")

print()
print()
print("Your To-Do List:")
print("-------------------")
print(*tasks,sep='\n')
    