// Pawel Adamczuk
//A program printing snowmen with ASCII characters.

#include <iostream>
#include <math.h>
#include <stdlib.h>

using namespace std;

int main()
{
    int n;
    int m;
    
    cin >> n >> m;
    
    //kapelusz - gorna czesc
    for (int i = 0; i < n; i++)
        {
            for (int l = 0; l < m * n; l++)
                cout << ' ';
            for (int j = - 3 * n; j <= 3 * n; j++)
                if (abs (j) <= 2 * n)
                    cout << '#';
                else
                    cout << ' ';
            cout << endl;
        }
     //kapelusz - dolna czesc
     for (int i = 0; i < n; i++)
        {
            for (int l = 0; l < m * n; l++)
                cout << ' ';
            for (int j = - 3 * n; j <= 3 * n; j++)           
                cout << '#';
            cout << endl;
        }       
    
    
    for (int i = 2 * n; i > - 2 * n; i--) //matryca kuli glowy
        if (2 * n - i >= n) //ucinamy kule glowy z gory i dolu
            {
                for (int l = 0; l < m * n; l++)
                    cout << ' ';
                for (int j = - 3 * n; j <= 3 * n; j++) //rysujemy kule glowy
                {
                    if (j == 0 and i == -n) //usta
                        cout << '-';
                    else
                        if (abs (j) == n / 2 + 1 and i == n / 2)
                            cout << 'O';
                        else
                            if (sqrt (pow (j, 2) + pow (i, 2)) <= 2 * n)
                                cout << '*';
                            else
                                cout << ' ';                   
                }                
                cout << endl;
            }
            
            
    for (int i = 3 * n - 1; i > - 3 * n; i--) //tulow
    {
        for (int l = 0; l < m * n; l++)
            cout << ' ';
        for (int j = - 3 * n; j <= 3 * n; j++)
            {
                if (j != 0 or i != 0)
                    if (sqrt (pow (j, 2) + pow (i, 2)) <= 3 * n)
                        if (i > abs (j))
                            cout << '|';
                        else
                            cout << '*';
                    else
                        cout << ' ';
                else
                    cout << 'X';
            }                      
        cout << endl;        
    }
    
    
    
    
    for (int k = 4; k <= 3 + m; k++) //rysowanie kul
    {
        for (int i = k * n - 1; i > - n * k; i--)
        {
            for (int l = 0; l < n * (m + 3 - k); l++)
                cout << ' ';
            for (int j = - n * k; j <= n * k; j++)
            {
                if (j != 0 or i != 0)
                    if (sqrt (pow (j, 2) + pow (i, 2)) <= k * n)
                        cout << '*';
                    else
                        cout << ' ';
                else
                    cout << 'X';
            }
            cout << endl;
        }
    }
    
    
    
} // main end
    
