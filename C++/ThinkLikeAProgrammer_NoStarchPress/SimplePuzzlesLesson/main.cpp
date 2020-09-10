#include <iostream>
using std::cin;
using std::cout;

enum modeType {UPPERCASE, LOWERCASE, PUNCTUATION};
int calcDoubleSum(int digit){
    int doubleDigit = digit *2;
    int sum;
    if (doubleDigit >=10) sum=1+doubleDigit%10;
    else sum = doubleDigit;
    return sum;
}
int main()
{
    /* Triangle and Square
    output patterns */
    for (int row = 1; row<=5;row++){
        for (int hashnum=1;hashnum<=6-row;hashnum++)
            {cout<<"#";}
        cout <<"\n";
    }
    cout <<"\n";
        for (int row = 1; row<=3;row++){
        for (int hashnum=1;hashnum<=row;hashnum++)
            {cout<<"#";}
        cout <<"\n";
    }    for (int row = 1; row<=3;row++){
        for (int hashnum=1;hashnum<=4-row;hashnum++)
            {cout<<"#";}
        cout <<"\n";
    }
    /*Input Processing
    Luhn Checksum Validation */

    char digit;
    int checksum_even = 0;
    int checksum_odd = 0;
    int checksum;
    int position = 1;
    cout << "Enter a number with any number of digits ";
    digit = cin.get();
    while (digit != 10)
    {
        if (position%2==0){
                checksum_even += digit - '0';
                checksum_odd += calcDoubleSum(digit - '0');
        }
        else {
                checksum_odd += digit - '0';
                checksum_even += calcDoubleSum(digit - '0');
       }
        digit = cin.get();
        position++;
    }
    if ((position-1)%2==0) checksum = checksum_even;
    else checksum = checksum_odd;
    cout << "Checksum is " << checksum <<". \n";
    if (checksum % 10 ==0){
        cout << "Checksum divisible by 10. Valid.";
    }else {
        cout << "Checksum not divisible by 10. Invalid. \n";

    }
    /* Tracking State
    Decode a Message */

    char digitChar;
    char outputCharacter;
    modeType mode = UPPERCASE;
    cout << "Enter a number \n";
    do {
    digitChar = cin.get();
    int number = (digitChar - '0');
    digitChar = cin.get();
    while ((digitChar != 10) && (digitChar != ','))
    {
        number = number * 10 + (digitChar - '0');
        digitChar = cin.get();
    }
    switch(mode){
    case UPPERCASE:
        number = number % 27;
        outputCharacter = number + 'A' -1;
        if (number == 0){
            mode = LOWERCASE;
            continue;}
        break;
    case LOWERCASE:
        number = number % 27;
        outputCharacter = number + 'a' -1;
        if (number == 0){
            mode = PUNCTUATION;
            continue;}
        break;
    case PUNCTUATION:
        number = number % 9;
        switch (number){
            case 1:
                outputCharacter = '!';
                break;
            case 2:
                outputCharacter ='?';
                break;
            case 3:
                outputCharacter =',';
                break;
            case 4:
                outputCharacter ='.';
                break;
            case 5:
                outputCharacter =' ';
                break;
            case 6:
                outputCharacter =';';
                break;
            case 7:
                outputCharacter ='\'';
                break;
            case 8:
                outputCharacter ='"';
                break;
                }
        if (number ==0){
            mode = UPPERCASE;
            continue;
    }
        break;
    }
    cout<< outputCharacter;
    } while (digitChar != 10);
    cout << "\n";
    return 0;
}

