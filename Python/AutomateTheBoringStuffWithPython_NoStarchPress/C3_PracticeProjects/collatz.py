



def collatz(number):
    if number%2:
        result=3*number+1
    else:
        result=number//2
    print(result)
    return result

if __name__=="__main__":
    try:
        number=int(input('Enter number: '))
        while number!=1:
            number=collatz(number)
    except ValueError:
        print('Must enter an integer')
