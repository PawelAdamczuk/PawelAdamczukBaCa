//Pawel Adamczuk
//This is an implementation of a few simple, recursive algorithms, including Horner polynomial algorithm and calculating of binomial coefficient.

using namespace std;

int wielomian (int n, int* a, int x)
{
    if (n == 0)
        return *a;
    else
        return ( *a + x * wielomian (n - 1, a + 1, x));
}

long long newton (int n, int k)
{
    int result = 0;
    
    if (k > 33 or n > 33)
        result = -1;
    else
        if (n < k)
            result = 0;
        else
            if (k == 0 or k == n)
                result = 1;
            else
                if (n <= k)
                    result = newton (n, n - k);
                else
                    result = newton(n - 1, k - 1) * n / k;
                
            return result;      
}

int* maximum (int n, int* t)
{
    int* result = t;
    
    if (n <= 0 or t == 0)
        result = 0;
    else
        if (n == 1)
            result = t;
        else
            if (*t >= *(maximum (n - 1, t + 1)))
                result = t;
            else
                result = maximum (n - 1, t + 1);
    
    return result;
}
