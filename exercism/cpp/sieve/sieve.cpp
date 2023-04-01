#include "sieve.h"
#include <vector>
#include <cmath>
using namespace std;

namespace sieve
{
    vector<int> primes(int maxPrime)
    {
        maxPrime = maxPrime + 1;
        vector<int> primesNumbers = vector<int>();
        vector<bool> sieve = vector<bool>(maxPrime, true);
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i < sqrt(maxPrime); i++)
        {
            if (sieve[i])
            {
                for (int j = i * i; j < maxPrime; j = j + i)
                {
                    sieve[j] = false;
                }
            }
        }
        for (int i = 0; i < (int)sieve.size(); i++)
        {
            if(sieve[i]){
                primesNumbers.push_back(i);
            }
            
        }
        
        return primesNumbers;
    }

} // namespace sieve
