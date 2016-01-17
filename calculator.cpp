// Pawel Adamczuk
//A calculator

#include <iostream>
#include <stdio.h>
using namespace std;

void M ()
{
     int a, b, c;
     cin >> a >> b >> c;
     
     if (a > b)
        swap(a , b);
     if (b > c)
        swap(b , c);
     if (a > b)
        swap(a , b);
        
     cout << b;
}

void C ()
{
     int a, b, c;
     cin >> a >> b >> c;
     
     cout << "'"<< a << "', '" << b << "', '" << c << "'";   
}

void U ()
{
     string all;
     char a, b, c;
     cin >> a >> b >> c;
     
     a-=32;
     b-=32;
     c-=32;
     
     cout << a << endl << b << endl << c;
}

void K ()
{
     int a, c;
     char operation;
     
     cin >> a >> operation >> c;
     
      switch (operation)
       {
              case '*':
                   printf("%i" , a * c);
                   break;
                   
              case '/':
                   if (c == 0)
                   cout << "!!!";
                   else
                   printf("%i" , a / c);
                   break;
                   
              case '-':
                   printf("%i" , a - c);
                   break; 
                         
              case '+':
                   printf("%i" , a + c);
                   break;
                   
              default:
                   break;          
       }     
}
     
     
     
int main ()
{
    char operation;
    
    cin >> operation;
    
    switch (operation)
    {
           case 'M':
                M();
                break;
                
           case 'U':
                U();
                break;

                
           case 'C':
                C();
                break;

                
           case 'K':
                K();
                break;
                
             default:
                break;       
    }
    
//cin.ignore();
//getchar();
    
    
    
}
