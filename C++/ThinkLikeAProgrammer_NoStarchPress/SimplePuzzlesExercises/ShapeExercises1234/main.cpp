#include <iostream>

using namespace std;

int main()
{
    //Exercise 2-1
    for (int row = 0; row <4; row ++){
        for(int cell = 0; cell < row; cell++) cout<<" ";
        for(int cell = 0; cell < (4-row)*2; cell++) cout<<"#";
        cout<<"\n";
    }
    cout<<"\n";
    //Exercise 2-2
        for (int row = 1; row<=4;row++){
        for (int hashnum=1;hashnum<=4-row;hashnum++){cout<<" ";}
        for (int hashnum=1;hashnum<=row*2;hashnum++)
            {cout<<"#";}

        cout <<"\n";
    }    for (int row = 1; row<=4;row++){
        for (int hashnum=1;hashnum<=row;hashnum++)
            {cout<<" ";}
        for (int hashnum=1;hashnum<=8-2*row;hashnum++){cout<<"#";}
        cout <<"\n";
    }
    cout<<"\n";
    //Exercise 2-3
    for(int row = 1; row<=4;row++){
        for(int cell = 1; cell<=row; cell++)cout<<" ";
        for(int cell = 1; cell<=row; cell++)cout<<"#";
        for(int cell = 1; cell<=16-4*row; cell++)cout<<" ";
        for(int cell = 1; cell<=row; cell++)cout<<"#";
    cout<<"\n";
    }
    for(int row = 0; row<4;row++){
        for(int cell = 1; cell<=4-row; cell++)cout<<" ";
        for(int cell = 1; cell<=4-row; cell++)cout<<"#";
        for(int cell = 1; cell<=4*row; cell++)cout<<" ";
        for(int cell = 1; cell<=4-row; cell++)cout<<"#";
    cout<<"\n";
    }
    cout<<"\n";

    //Exercise 2-4
    cout<<"My Pattern" << "\n";
        for (int row = 1; row<=4;row++){
        for (int hashnum=1;hashnum<=4-row;hashnum++){cout<<" ";}
        for (int hashnum=1;hashnum<=row*3;hashnum++)
            {cout<<"#";}

        cout <<"\n";
    }    for (int row = 1; row<=4;row++){
        for (int hashnum=1;hashnum<=row;hashnum++)
            {cout<<" ";}
        for (int hashnum=1;hashnum<=12-3*row;hashnum++){cout<<"#";}
        cout <<"\n";
    }
}
