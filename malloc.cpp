// Pawel Adamczuk
//Dynamically allocated arrays, adding and modifying content.
#include <iostream>
#include <cstdarg>
#include <string.h>
#include <stdlib.h>

using namespace std;

void mySwap (int* a, int* b)
{
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;    
}


int main()
{
    char oper;
    int mSize;
    int nSize;
    int** mainArr;    
    int temp1;
    int temp2;
    int temp3;    
    int* tempArr;
    
    
    cin >> oper;
    
    if (oper == 'A')
    { 
        cin >> mSize;
        cin >> nSize;
        //A  (&mainArr, mSize, nSize); 
        mainArr = (int**)malloc(mSize * sizeof(int*));
        for(int i=0; i < mSize; i++)
            mainArr[i] = (int*)malloc(nSize * sizeof(int));
        
        for (int j = 0; j < mSize; j++)
            for (int k = 0; k < nSize; k++)
                cin >> mainArr [j] [k];               
                
    }
    
    while (oper != 'K')
    {
        switch (oper)
        {
            case 'B':
                cin >> temp1 >> temp2;
                cin >> mainArr [temp1] [temp2];
                break;
                
            case 'C':
                cin >> temp1 >> temp2;
                for (int i = 0; i < nSize; i++)
                mySwap (&mainArr [temp1] [i], &mainArr [temp2] [i]);
                break;
                
            case 'D':
                cin >> temp1;
                temp2 = mainArr [temp1] [nSize - 1];
                for (int i = nSize - 1; i > 0; i--)
                mainArr [temp1] [i] = mainArr [temp1] [i - 1];
                mainArr [temp1] [0] = temp2;
                break;
                
            case 'E':
                cin >> temp1;
                temp3 = 0;
                for (int i = 0; i < nSize; i++)
                {
                    cin >> temp2;
                    temp3 += temp2 * mainArr [temp1] [i];
                }
                cout << temp3 << endl;
                break;
                
            case 'F':
                tempArr = new int [mSize];
                for (int i = 0; i < mSize - 1; i++)
                    tempArr [i] = 0;                
                
                for (int i = 0; i < nSize; i++)
                {
                    cin >> temp1;
                    for (int j = 0; j < mSize; j++)
                    {
                        tempArr [j] += mainArr [j] [i] * temp1; 
                    }
                }
                
                for (int i = 0; i < mSize - 1; i++)
                    for (int j = 0; j < mSize - i - 1; j++)
                        if (tempArr [j] > tempArr [j+1])
                            mySwap(&tempArr [j], &tempArr[j+1]);
                            
                for (int i = 0; i < mSize; i++)
                    cout << tempArr [i] << " ";
                cout << endl;
                break;
                
            case 'G':
                cin >> temp1;
                temp3 = 1001;
                
                for (int i = 0; i < mSize; i++)
                    if (mainArr [i] [temp1] < temp3)
                    {
                        temp3 = mainArr [i] [temp1];
                        temp2 = i;
                    }
                cout << temp2 << endl;
                break;    
            
                
        }   
        
        cin >> oper;
    }
    
    
    for (int i = 0; i < mSize; i++)
    {
        for (int j = 0; j < nSize; j++)
            cout << mainArr [i] [j] << ' ';
        cout << endl;
    }
    
    
    
    



}
    
