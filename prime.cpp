// Pawel Adamczuk
//Prime number test and output

#include <math.h>
#include <stdio.h>

using namespace std;

bool primeOrNot (int number)
{
     if(number <= 1)
     return 0;
     
     for(int i = (int)sqrt(number); i > 1; i--)
     {
             if(number % i == 0)
             return 0;
     }
     return 1;
     
}

int main()
{
    int lineCount=0;
    int tempNumber;
    
    scanf("%i" , &lineCount);
    
    for(int j=0; j<lineCount; j++)
    {
            scanf("%i" , &tempNumber);
            if(primeOrNot(tempNumber) == 1)
            printf("%s" , "TAK\n");
            else
            printf("%s" , "NIE\n");            
    }

}
