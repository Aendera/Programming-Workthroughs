#include <iostream>

using namespace std;

int main()
{
    //Exercise 2-9

    char digitChar;
    int word_length;
    int vowel_count;
    int total_words,total_vowels;
    int max_length,min_length,mean_length,total_length;
    max_length=0;
    min_length=999;
    mean_length=0;
    total_length=0;
    total_vowels=0;
    total_words=0;
    cout << "Enter a line \n";
    do {
        word_length=0;
        vowel_count=0;
    do{
        digitChar = cin.get();
        if ((digitChar=='a')||(digitChar=='e')||(digitChar=='i')||(digitChar=='o')||(digitChar=='u')||(digitChar=='A')||(digitChar=='E')||(digitChar=='I')||(digitChar=='O')||(digitChar=='U'))
            vowel_count++;
        if ((digitChar!=' ') && (digitChar != 10))
            word_length++;
    }   while ((digitChar != 10) && (digitChar != ' '));
    if (word_length>0){
        total_words++;
    cout<<word_length<<endl;
    max_length=max(max_length,word_length);
    min_length=min(min_length,word_length);
    total_vowels += vowel_count;
    total_length += word_length;
    mean_length = (mean_length * (total_words - 1) +word_length)/total_words;
    }
    } while (digitChar != 10);
    cout << "\n";
    cout<<"There are "<<total_words<< " words in this line, with "<<total_vowels<<" vowels in total"<<endl;
    cout<<"The words have a total of "<<total_length<<" characters and a mean length of "<<mean_length<<" characters"<<endl;
    cout<<"The words have a min length of "<<min_length<<" and a max length of "<<max_length<<endl;
    return 0;
}
