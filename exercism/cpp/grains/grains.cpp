#include "grains.h"

namespace grains
{

    unsigned long long square(unsigned int square)
    {
        return 1ULL << (square - 1);
    }
    unsigned long long total()
    {
        unsigned long long t = 0;
        for (unsigned int i = 1; i <= 64; i++)
        {
            t+= square(i);
        }
        return t;   
    }
} // namespace grains
