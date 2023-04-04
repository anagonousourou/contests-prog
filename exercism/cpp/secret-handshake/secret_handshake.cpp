#include "secret_handshake.h"
#include <vector>
#include <string>
#include <bits/stdc++.h>
using namespace std;
namespace secret_handshake
{

    vector<string> commands(int code)
    {

        vector<string> signals = vector<string>();

        if ((code & 1) == 1)
        {
            signals.push_back("wink");
        }

        if ((code & 2) == 2)
        {
            signals.push_back("double blink");
        }

        if ((code & 4) == 4)
        {
            signals.push_back("close your eyes");
        }

        if ((code & 8) == 8)
        {
            signals.push_back("jump");
        }

        if ((code & 16) == 16)
        {
            reverse(signals.begin(), signals.end());
        }

        return signals;
    }

} // namespace secret_handshake
