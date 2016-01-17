//Pawel Adamczuk
//This exercise is juggling with C-type memory allocation and pointer dereferencing while modifying character strings.

#include <iostream>
#include <cstdlib>

using namespace std;

int main ()
{
    //WCZYTANIE
    int dl2;
    int dl;
    char temp5;
    char temp6;
    int temp7;
    int temp8;
    char * tempStr;
    int* strLen;
    int n;
    cin >> n;
    int temp;
    int temp2;
    char temp3;
    int m;
    int b;
    char oper;
    
    strLen = (int*) malloc ( n * sizeof (int)); 
    char** arr;
    arr = (char**) malloc ( n * sizeof (char*));
    for ( int i = 0; i < n; i++ )
    {
        cin >> *(strLen + i);
        *(arr + i) = (char*) malloc ( sizeof (char) * (*(strLen + i)));
        temp = 0;
        while (temp < *(strLen + i))
        {
            cin >> temp2;
            cin >> temp3;
            for (int j = 0; j < temp2; j++)
            {
                *(*(arr + i) + temp + j) = temp3;
            }
            temp += temp2;
        }           
    }
    //KONIEC WCZYTYWANIA
    
    cin >> oper;
    while (1)
    {
        switch (oper)
        {
            case 'W':
                for ( int l = 0; l < n; l++ )
                {
                    temp7 = 0;                      
                    temp6 = *(*(arr + l) + temp7);                  
                    while (temp7 < *(strLen + l))
                    {
                        temp8 = 0;
                        temp5 = temp6;
                        temp6 = *(*(arr + l) + temp7);               // a a a a b b b          
                        while ( temp6 == temp5 )
                        {
                            if ( temp8 + temp7 < *(strLen + l) )
                            {
                                temp8++;    
                                temp6 = *(*(arr + l) + temp7 + temp8);
                            }
                            else
                            temp6 = 0;              
                        }                        
                        cout << temp8 << ' ' << temp5;                        
                        temp7 += temp8;                        
                        cout << ' ';                        
                        if (temp7 >= *(strLen + l))
                            cout << endl;
                    }            
                }
                break;
                
            case 'U':
                cin >> m;
                free ( *(arr + m) );
                for ( int i = 0; i < n - m - 1; i++ )
                {
                    *(arr + m + i) = *(arr + m + i + 1);
                    *( strLen + m + i ) = *( strLen + m + i + 1 );                    
                }   
                n = n - 1;
                break;
                
            case 'D':
                cin >> m;
                cin >> b;                
                * (arr + b) = (char*) realloc ( *(arr + b), sizeof (char) * (*(strLen + b) + *(strLen + m)));
                for ( int i = *(strLen + b); i < (*(strLen + b) + *(strLen + m)); i++)
                {
                    *(*(arr + b) + i) = *(*(arr + m) + i - *(strLen  + b));
                }
                *(strLen + b) += *(strLen + m);                
                break;
                
            case 'R':
                cin >> m;
                dl = *(strLen + m);
                tempStr = (char*) malloc ( sizeof (char) * dl);                
                for ( int i = 0; i < dl; i++)
                    *(tempStr + i) = *( *( arr + m ) + dl - 1 - i);                   
                for ( int i = 0; i < dl; i++)
                    *( *( arr + m ) + i) = *(tempStr + i );                
                free ( tempStr );
                break;
                
            case 'X':
                cin >> m;
                if ( *(strLen + m) == 1)
                {
                    free ( *(arr + m) );
                    for ( int i = 0; i < n - m - 1; i++ )
                    {
                        *(arr + m + i) = *(arr + m + i + 1);
                        *( strLen + m + i ) = *( strLen + m + i + 1 );                    
                    }   
                    n = n - 1;
                }
                else
                {
                    tempStr = (char*)  malloc ( ( *(strLen + m) / 2 ) * sizeof (char));
                    b = 0;
                    for (int i = 0; i < *(strLen + m); i++)
                    {
                        if (i % 2 != 0)
                        {
                            *(tempStr + b) = *(*(arr + m) + i);
                            b += 1;
                        }                        
                    }
                    free ( *(arr + m) );
                    *(arr + m) = tempStr;
                    *(strLen + m) = (*(strLen + m) / 2);
                    
                }
                break;
                
            case 'K':
                break;    
               
            default:
                break;           
        }
        
        if (oper == 'K')
        break;
        
        cin >> oper;
    }
    
    for ( int i = 0; i < n; i++ )
       free ( *(arr + i) );
       
    free (arr);
    
    free (strLen);    
}
