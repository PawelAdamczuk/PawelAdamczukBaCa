// Pawel Adamczuk
//This exercise is just column operation on string inputs implemented in C++ considering various methods of calling functions.

#include <iostream>
#include <cstdarg>
#include <math.h>

using namespace std;

    if(ord($input[$i]) > 64 && ord($input[$i]) < 91) {
int myPow ( int a, int b )
{
    int result = 1;
    
    for ( int i = 0; i < b; i++ )
        result *= a;
        
    return result;
}

string sumTwo ( string a, string b )
{
    int temp1;
    int temp2;
    
    int aCount = 0;
    int bCount = 0;
    
    int maxLength = ( a.length() > b.length() ? a.length() : b.length() );
    
    string sum;
    
    for ( int i = 0; i < maxLength + 1; i++ )
    {
        sum.insert (0, 1, '0');
    }
    
    string::iterator it = --sum.end() ;
    
    int tempSum;
    int remainder = 0;
    
    for (int i = 0; i < maxLength + 1; i++)
    {
        temp1 = (aCount++ < a.length() ? a [ a.length() - 1 - i ] - '0' : 0);
        temp2 = (bCount++ < b.length() ? b [ b.length() - 1 - i ] - '0' : 0);
        
        
        
        tempSum = temp1 + temp2 + remainder;
        
        remainder = (tempSum >= 10 ? 1 : 0);        
        *it-- = ( tempSum % 10 ) + '0';
    }
    
    if ( sum [0] == '0' )
        sum.erase (0, 1);
    
    return sum;
}

/*

void operation(string&,	void	(*)(	string*,	int,string*),int,string*);
void operation(string&,	void	(*)(	string*,	int,string*),int,...);

*/

void sum ( string& finResult, int count, string* strArr )
{
    string result; //the main result string to be returned by the function in the end
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = strArr [i];
        
        result = sumTwo ( result, tempStr );
    }
    
    finResult = result;    
}

void sum ( string& finResult, int count, ... )
{
    string result; //the main result string to be returned by the function in the end
    
    va_list vl; //argument list
    va_start (vl, count); //argument list initialisation
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = va_arg ( vl, char* );
        
        result = sumTwo ( result, tempStr );
    }
    
    va_end (vl);
    finResult = result;    
}

void sum ( string* finResult, int count, ... )
{
    string result; //the main result string to be returned by the function in the end
    
    va_list vl; //argument list
    va_start (vl, count); //argument list initialisation
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = va_arg ( vl, char* );
        
        result = sumTwo ( result, tempStr );
    }
    
    va_end (vl);
    *finResult = result;    
}

string sum ( int count, ... )
{
    string result; //the main result string to be returned by the function in the end
    
    va_list vl; //argument list
    va_start (vl, count); //argument list initialisation
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = va_arg ( vl, char* );
        
        result = sumTwo ( result, tempStr );
    }
    
    va_end (vl);
    return result;    
}

string sum ( int count, string* strArr )
{
    string result; //the main result string to be returned by the function in the end
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = strArr [i];
        
        result = sumTwo ( result, tempStr );
    }
    
    return result;    
}

void sum ( string* finResult, int count, string* strArr )
{
    string result; //the main result string to be returned by the function in the end
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = strArr [i];
        
        result = sumTwo ( result, tempStr );
    }
    
    *finResult = result;    
}

string multByInt ( string a, int b )
{
    int temp1;
    int temp2;
    
    int aCount = 0;
    int bCount = 0;
    
    int maxLength;
    
    if ( b >= 10 )
        maxLength = a.length() * ( b / 10 );
    else
        maxLength = a.length();
    
    string prod;
    
    for ( int i = 0; i < maxLength + 1; i++ )
    {
        prod.insert (0, 1, '0');
    }
    
    string::iterator it = --prod.end() ;
    
    int tempProd;
    int remainder = 0;
    
    for (int i = 0; i < maxLength + 1; i++)
    {
        temp1 = (aCount++ < a.length() ? a [ a.length() - 1 - i ] - '0' : 0);
        
        
        
        tempProd = temp1 * b + remainder;
        
        remainder = (tempProd >= 10 ? tempProd / 10 : 0);        
        *it-- = ( tempProd % 10 ) + '0';
    }
    
    while (1)
        if ( prod [0] == '0' )
            prod.erase (0, 1);
        else
            break;
            
    return prod;
    
}

string multTwo ( string a, string b )
{
    if ( a == "0" or b == "0" )
        return "0";
    
    string shorter = ( a.length() < b.length() ? a : b );
    
    string theOtherOne = ( a.length() >= b.length() ? a : b );
    
    string* tempArr = new string [ shorter.length() ];
    
    for ( int i = 0; i < shorter.length(); i++ )
    {
        string tempStr = multByInt ( theOtherOne, ( ( shorter [ shorter.length() - 1 - i ] - '0' ) ) );
        
        tempStr.append (i, '0');
        
        tempArr [i] = tempStr;
        
        
            
    }
    
    return sum ( shorter.length(), tempArr );
    
}

void mult ( string& finResult, int count, string* strArr )
{
    string result = "1"; //the main result string to be returned by the function in the end
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = strArr [i];
        
        if ( tempStr == "0" )
        {
            result = "0";
            break;
        }
        
        result = multTwo ( result, tempStr );
    }
    
    finResult = result;    
}

void mult ( string& finResult, int count, ... )
{
    string result = "1"; //the main result string to be returned by the function in the end
    
    va_list vl; //argument list
    va_start (vl, count); //argument list initialisation
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = va_arg ( vl, char* );
        
        if ( tempStr == "0" )
        {
            result = "0";
            break;
        }
        
        result = multTwo ( result, tempStr );
    }
    
    va_end (vl);
    finResult = result;    
}

void mult ( string* finResult, int count, ... )
{
    string result = "1"; //the main result string to be returned by the function in the end
    
    va_list vl; //argument list
    va_start (vl, count); //argument list initialisation
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = va_arg ( vl, char* );
        
        if ( tempStr == "0" )
        {
            result = "0";
            break;
        }
        
        result = multTwo ( result, tempStr );
    }
    
    va_end (vl);
    *finResult = result;    
}

string mult ( int count, ... )
{
    string result = "1"; //the main result string to be returned by the function in the end
    
    va_list vl; //argument list
    va_start (vl, count); //argument list initialisation
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = va_arg ( vl, char* );
        
        if ( tempStr == "0" )
        {
            result = "0";
            break;
        }
        
        result = multTwo ( result, tempStr );
    }
    
    va_end (vl);
    return result;    
}

string mult ( int count, string* strArr )
{
    string result = "1"; //the main result string to be returned by the function in the end
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = strArr [i];
        
        if ( tempStr == "0" )
        {
            result = "0";
            break;
        }
        
        result = multTwo ( result, tempStr );
    }
    
    return result;    
}

void mult ( string* finResult, int count, string* strArr )
{
    string result = "1"; //the main result string to be returned by the function in the end
    
    for ( int i = 0; i < count; i ++ )
    {
        string tempStr = strArr [i];
        
        if ( tempStr == "0" )
        {
            result = "0";
            break;
        }
        
        result = multTwo ( result, tempStr );
    }
    
    *finResult = result;    
}

string operation ( string ( *foo ) ( int, string* ), int count, string* strArr )
{
    return foo ( count, strArr );
}

void operation ( string* finResult,  string ( *foo ) ( int, string* ), int count, string* strArr )
{
    *finResult = foo ( count, strArr );
}

string operation ( string ( *foo ) ( int , string* ), int count, ... )
{
    va_list vl;
    va_start ( vl, count );
    
    string* strArr = new string [ count ];
    
    for ( int i = 0; i < count; i++ )
    {
        strArr [ i ] = va_arg ( vl, char* );
    }
    
    va_end ( vl );
    
    return foo ( count, strArr );
}




void operation ( string* finResult, string ( *foo ) ( int , string* ), int count, ... )
{
    va_list vl;
    va_start ( vl, count );
    
    string* strArr = new string [ count ];
    
    for ( int i = 0; i < count; i++ )
    {
        strArr [ i ] = va_arg ( vl, char* );
    }
    
    va_end ( vl );
    
    *finResult = foo ( count, strArr );
}

void operation ( string& finResult, string ( *foo ) ( int , string* ), int count, ... )
{
    va_list vl;
    va_start ( vl, count );
    
    string* strArr = new string [ count ];
    
    for ( int i = 0; i < count; i++ )
    {
        strArr [ i ] = va_arg ( vl, char* );
    }
    
    va_end ( vl );
    
    finResult = foo ( count, strArr );
}

void operation ( string& finResult,  string ( *foo ) ( int, string* ), int count, string* strArr )
{
    finResult = foo ( count, strArr );
}
//
//int main()
//{
//    //cout << sum ( 2, "1000", "1000" );
//    //cout << endl;
//    //cout << sum ( 5, "900", "900", "900", "900", "900" );
//    
//    //cout << sumTwo( "900", "900" );
//    
//    string stringArr [3] = { "900", "900", "1" };
//    
//    //cout << sum ( 3, stringArr );
//    
//    string testResult;
//    
//    sum ( &testResult, 3, stringArr );
//    
//    //cout << testResult;
//    
//    string testMult = "1234";
//    
//    string testMult2 = "12345";
//    
//    //cout << multTwo( testMult, testMult2 );
//    //cout << myPow( 10, 1 );
//    
//    cout << multTwo ( "12345678", "1234567");
//        
//    return 0;
//}
