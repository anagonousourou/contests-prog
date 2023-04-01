#include "triangle.h"
#include <stdexcept>
namespace triangle
{
    short kind(double side1, double side2, double side3)
    {

        if (side1 + side2 + side3 == 0 || side1 > side2 + side3 || side2 > side1 + side3 || side3 > side1 + side2)
        {
            throw std::domain_error("Illegal arguments");
        }
        if (side1 == side2 && side2 == side3)
        {
            return triangle::flavor::equilateral;
        }
        if (side1 == side2 || side2 == side3 || side1 == side3)
        {
            return triangle::flavor::isosceles;
        }
        return triangle::flavor::scalene;
    }
} // namespace triangle
