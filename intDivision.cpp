// Pawel Adamczuk
//Integer division test

#include <stdio.h>

using namespace std;

int main ()
{
    int dividend;
    int numberOfLines;
    int tempDivisor;
    bool divisorOrNot=0;
    
    scanf ("%d" , &dividend);
    scanf ("%d" , &numberOfLines);
    
    for (int i=0; i<numberOfLines; i++)
    {
        scanf ("%i" , &tempDivisor);
        if (dividend % tempDivisor == 0)
        divisorOrNot=true;        
    }
    
    if (divisorOrNot == 1)
    printf("%s" , "TAK");
    else
    printf("%s" , "NIE");    
}
