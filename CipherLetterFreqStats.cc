// Pawel Adamczuk
//This is an exercise involving running letter frequency statistics on a sample text, then comparing it with the cipher text in order to decode it and finally displaying all the statistics on both texts.

#include <iostream>
#include <algorithm>
#include <fstream>


//     65...........................................................................................................................90   59
//     A    B    C    D    E    F    G    H    I    J    K    L    M    N    O    P    Q    R    S    T    U    V    W    X    Y    Z    ;
//     1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27

using namespace std;

typedef struct Letter
{
    int quantity;
    char letter;
    
    Letter ()
    {
        quantity = 0;
    }
    
} Letter;

typedef struct Code
{
    bool used;
    char first;
    char second;
    Code ()
    {
        used = 0;
    }
} Code;

typedef struct CodeAlphabet 
{
    Code codes [27];
} CodeAlphabet;

typedef struct Alphabet
{
    int total;
    
    Letter letters [27];
    
    Alphabet ()
    {
        for ( int i = 0; i < 26; i++ )
            letters [i].letter = 65 + i;
        letters[26].letter = 59;
        total = 0;
    }
      
} Alphabet;



bool sortByQuantity ( const Letter& lhs, const Letter& rhs ) { return lhs.quantity > rhs.quantity; }

void u () //template file analysis
{
    Alphabet tempAlphabet;
    char tempChar;
    char* inputFileName = new char [512];
    char* outputFileName = new char [512];
    cin >> inputFileName;
    cin >> outputFileName; 
    
    FILE* inputFile = fopen ( inputFileName, "r" );
    FILE* outputFile = fopen ( outputFileName, "w" );
    
    delete inputFileName;
    delete outputFileName;
    
    
    while (1)
    {
        tempChar = getc ( inputFile );
        
        if ( tempChar == EOF )
            break;
                        
        if ( tempChar == 59 )
            tempAlphabet.letters[26].quantity += 1;
        else
            tempAlphabet.letters[ tempChar - 65 ].quantity += 1;
        tempAlphabet.total += 1;       
    }
    
    sort ( tempAlphabet.letters, tempAlphabet.letters + 27, sortByQuantity );
    
    
    /*for ( int i = 0; i < 27; i++ ) //test
    {
        for ( int j = 0; j < tempAlphabet.letters[i].quantity; j++ )
            cout << tempAlphabet.letters[i].letter;
        cout << endl;
    }*/
    
    for ( int i = 0; i < 27; i++ )
    {
        if ( tempAlphabet.letters[i].quantity == 0 )
            break;
            
        fprintf ( outputFile, "Znaleziono %8i znakow %c, co stanowi %6.3f%% wszystkich.\n", tempAlphabet.letters[i].quantity, tempAlphabet.letters[i].letter, (float)tempAlphabet.letters[i].quantity * 100 / (float)tempAlphabet.total );
    }
    cout << tempAlphabet.total;
    fclose ( outputFile );
    fclose ( inputFile );
}

void o () //decipher file analysis and decoding
{
    Alphabet inputStatAlphabet;
    Alphabet decipherStatAlphabet;
    char tempChar;
    char* decipherFileName = new char [1024];
    char* statFileName = new char [1024];
    char* outputFileName = new char [1024];
    cin >> decipherFileName;
    cin >> statFileName;
    cin >> outputFileName;
    
    FILE* decipherFile = fopen ( decipherFileName, "r" );
    FILE* statFile = fopen ( statFileName, "r" );
    FILE* outputFile = fopen ( outputFileName, "a+" );
    
    
    while (1)
    {
        tempChar = getc ( decipherFile );
        
        if ( tempChar == EOF )
            break;
                        
        if ( tempChar == 59 )
            decipherStatAlphabet.letters[26].quantity += 1;
        else
            decipherStatAlphabet.letters[ tempChar - 65 ].quantity += 1;
        decipherStatAlphabet.total += 1;       
    }
    
    sort ( decipherStatAlphabet.letters, decipherStatAlphabet.letters + 27, sortByQuantity );
    
    
    /*for ( int i = 0; i < 27; i++ ) //test
    {
        for ( int j = 0; j < tempAlphabet.letters[i].quantity; j++ )
            cout << tempAlphabet.letters[i].letter;
        cout << endl;
    }*/
    
    for ( int i = 0; i < 27; i++ )
    {
        if ( decipherStatAlphabet.letters[i].quantity == 0 )
            break;
            
        printf ( "Znaleziono %8i znakow %c, co stanowi %6.3f%% wszystkich.\n", decipherStatAlphabet.letters[i].quantity, decipherStatAlphabet.letters[i].letter, (float)decipherStatAlphabet.letters[i].quantity * 100 / (float)decipherStatAlphabet.total );
    }
    
    
    while ( 1 )
    {
        char character;
        int quantity;
        fscanf ( statFile, "Znaleziono %8i znakow %c, co stanowi %*6f%% wszystkich.\n", &quantity, &character );
        
        
        
        if ( character == ';' )
            inputStatAlphabet.letters[26].quantity = quantity;
        else       
            inputStatAlphabet.letters[character - 65].quantity = quantity;
            
        if ( feof(statFile) )
            break;
        
    }
    
    sort ( inputStatAlphabet.letters, inputStatAlphabet.letters + 27, sortByQuantity );
    
    CodeAlphabet codeAlphabet;
    
    for ( int i = 0; i < 27; i++ )
    {
        if ( decipherStatAlphabet.letters[i].quantity == 0 )
            break;
            
        if ( decipherStatAlphabet.letters[i].letter == ';' )
        {
            codeAlphabet.codes[ 26 ].first = decipherStatAlphabet.letters[i].letter;
            codeAlphabet.codes[ 26 ].second = inputStatAlphabet.letters[i].letter;
            codeAlphabet.codes[ 26 ].used = 1;
            
        }
        else
        {            
            codeAlphabet.codes[ decipherStatAlphabet.letters[i].letter - 65 ].first = decipherStatAlphabet.letters[i].letter;
            codeAlphabet.codes[ decipherStatAlphabet.letters[i].letter - 65 ].second = inputStatAlphabet.letters[i].letter;
            codeAlphabet.codes[ decipherStatAlphabet.letters[i].letter - 65 ].used = 1;
        }
            
    }
    
    for ( int i = 0; i < 27; i++ )
    {
        if ( codeAlphabet.codes[i].used )
            printf ( "Symbol %c koduje %c\n", codeAlphabet.codes[i].first, codeAlphabet.codes[i].second);
    }
    
    rewind ( decipherFile );
    
    while (1)
    {
        tempChar = getc ( decipherFile );
        
        if ( tempChar == EOF )
            break;
                        
        if ( tempChar == 59 )
            fprintf ( outputFile, "%c", codeAlphabet.codes[ 26 ].second );
        else
            fprintf ( outputFile, "%c", codeAlphabet.codes[ tempChar - 65 ].second );       
    }
    
    char seekedChar;
    cin >> seekedChar;
    int n = -1;
    char tempSeekChar;
    bool firstFoundChar = 0;
    
    while (1)
    {
        fseek ( outputFile, n, SEEK_END );
        tempSeekChar = fgetc ( outputFile );
        n--;
        if ( tempSeekChar == seekedChar and firstFoundChar == 1 )
            break;
        else
            if ( tempSeekChar == seekedChar )
                firstFoundChar = true;
    }
    
    
    fseek ( outputFile, n, SEEK_END );
    tempSeekChar = fgetc ( outputFile );
    
    int howManyPrinted = 0;
    
    while (1)
    {
        tempSeekChar = fgetc ( outputFile );
        if ( tempSeekChar == -1 or howManyPrinted == 50 )
            break;
            
        printf ( "%c", tempSeekChar );
        howManyPrinted++;
        
        
    }    
    //cout << decipherStatAlphabet.total;
    fclose ( decipherFile );
    fclose ( statFile );
    fclose ( outputFile );
}

void w ()
{
    char* fileName = new char [1024];
    cin >> fileName;
    
    FILE* file = fopen ( fileName, "r" );
    
    int skip;
    cin >> skip;
    
    for ( int i = 0; i < skip; i ++ )
        fgetc ( file );
        
    int print;
    cin >> print;
    char tempChar;
        
    for ( int i = 0; i < print; i++ )
    {
        tempChar = fgetc ( file );
        if ( tempChar == -1 )
            break;
        cout << tempChar;
    }
    
}

int main()
{
    char oper;
    cin >> oper;
	
	while (1)
	{
		switch (oper)
        {                
            case 'u':
                u ();                
                break;
                
            case 'o':
                o ();
                break;
                
            case 'w':
                w ();
                break;
                
            case 'k':
                return 0;
                break;               
        }
        cin >> oper;
    }

}
