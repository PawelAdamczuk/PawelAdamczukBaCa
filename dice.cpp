// Pawel Adamczuk
//An implementation of a peculiar dice game.

#include <iostream>

using namespace std;

int main()
{
    double pierwszyPunkty = 0;
    double drugiPunkty = 0;
    
    double tmp1;
    double tmp2;
    
    for (int i = 1; i <= 10; i++)
    {
        if (i % 2 == 1)//gracz pierwszy
        {
            for (int j = 0; j < 10; j++)
            {
                //cout << " " << j << " ";
                cin >> tmp1 >> tmp2;
                
                if ((tmp1 + tmp2 == 7 || tmp1 + tmp2 == 11) && j == 0)
                {
                    cout << "Gracz pierwszy wygral\n";
                    break;
                }
                else
                    if ((tmp1 + tmp2 == 2 || tmp1 + tmp2 == 12) && j == 0)
                    {
                        cout << "Gracz pierwszy przegral\n";
                        pierwszyPunkty += (j + 1);
                        break;
                    }
                    else 
                        if (tmp1 + tmp2 == 5)
                        {
                            cout << "Gracz pierwszy wygral\n";
                            break;
                            
                        }
                        else
                        {
                            pierwszyPunkty += (tmp1 + tmp2) / (j + 1);
                            
                        }
            }        
        }
        else//gracz drugi
        {
            for (int j = 0; j < 10; j++)
            {
                //cout << " " << j << " ";
                cin >> tmp1 >> tmp2;
                
                if ((tmp1 + tmp2 == 7 || tmp1 + tmp2 == 11) && j == 0)
                {
                    cout << "Gracz drugi wygral\n";
                    break;
                }
                else
                    if ((tmp1 + tmp2 == 2 || tmp1 + tmp2 == 12) && j == 0)
                    {
                        cout << "Gracz drugi przegral\n";
                        drugiPunkty += (j + 1);
                        break;
                    }
                    else 
                        if (tmp1 + tmp2 == 5)
                        {
                            cout << "Gracz drugi wygral\n";
                            break;
                            
                        }
                        else
                        {
                            drugiPunkty += (tmp1 + tmp2) / (j + 1);
                        }
            }
                
        }
             
    }
    
    cout << "Wynik pierwszego gracza " << pierwszyPunkty << endl;
    cout << "Wynik drugiego gracza " << drugiPunkty << endl;
    
    if ( pierwszyPunkty == drugiPunkty)
        cout << "Remis" << endl;
    else
        if (pierwszyPunkty > drugiPunkty)
            cout << "Wygral gracz drugi" << endl;
        else
            cout << "Wygral gracz pierwszy" << endl;
    
    

}
    
