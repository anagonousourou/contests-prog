#include "two_fer.h"
#include <string>
#include <sstream>
using namespace std;
namespace two_fer
{
    string two_fer(string name)
    {
        ostringstream ss;
        ss << "One for " << name << ", one for me.";
        return ss.str();
    }

} // namespace two_fer

