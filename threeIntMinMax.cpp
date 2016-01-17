// Pawel Adamczuk
//Min, max in a set of three integers

#include <stdio.h>
#include <iostream>

using namespace std;

int max(int a , int b , int c)
{
    int max = a;
    if (b > max)
    max = b;
    if (c > max)
    max = c;
    
    return max;    
}

int min(int a , int b , int c)
{
    int min = a;
    if (b < min)
    min = b;
    if (c < min)
    min = c;    
    
    return min;
}

int main()
{
    int setCount;
    scanf ("%i" , &setCount);
    
    int tempA = 0;
    int tempB = 0;
    int tempC = 0;
    
    for ( int i = 0; i<setCount; i++ )
    {
        scanf ("%i" , &tempA);      
        scanf ("%i" , &tempB);
        scanf ("%i" , &tempC);
        
        printf ("%i %i" , min(tempA , tempB , tempC) , max(tempA , tempB , tempC));
        cout<<endl;
        
        
    }
    

}
