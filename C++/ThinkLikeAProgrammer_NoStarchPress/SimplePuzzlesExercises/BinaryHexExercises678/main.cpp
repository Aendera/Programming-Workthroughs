#include <iostream>
#include <cmath>
using namespace std;

char numberToLetters(int number){
    if (number<10)
        return number+'0';
    else
        return number + 'A' - 10; //should work up to base 36
    //no idea what base 60 representation is like
}
int main()
{
    //TO complete exercise, would need to add base - something input
    //skipiing for now
    //currently works as decimal to other converter
    //Exercise 2-6,7,8
    int number;//keeping it to integeres
    cout<<"Enter a number" << endl;
    cin>>number;
    int base;
    cout<<"Enter a base"<<endl;
    cin>>base;
    int numbercopy=number;
    int total=0;

    while (numbercopy>0){
        numbercopy/=base;
        total++;
    }

    for(int i =total-1; i>=0;i--){
        int value =pow(base,i);
        cout<<numberToLetters(number/value);
            number %= value;
    }
    return 0;
}
