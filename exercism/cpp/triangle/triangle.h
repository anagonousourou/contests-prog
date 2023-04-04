#if !defined(TRIANGLE_H)
#define TRIANGLE_H

namespace triangle
{
    namespace flavor
    {
        const short equilateral = 1;
        const short isosceles = 2;
        const short scalene = 3;
    }
    short kind(double side1, double side2, double side3);

} // namespace triangle

#endif // TRIANGLE_H