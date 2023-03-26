import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Triangle {

    private final double side1;
    private final double side2;
    private final double side3;



    Triangle(double side1, double side2, double side3) throws TriangleException {
        if(!isTriangle(side1, side2,side3)){
            throw  new TriangleException();
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    boolean isEquilateral() {
        return side1 == side2 && side1 == side3;
    }

    boolean isIsosceles() {
        return side1 == side2 || side1 == side3 || side2 == side3 ;
    }

    boolean isScalene() {
       return !isIsosceles();
    }

    boolean isTriangle(double side1, double side2, double side3) {
        if (Stream.of(side1, side2, side3).anyMatch(s -> s <= 0)) {
            return false;
        }
        return side1 <= side2 + side3 && side2 <= side1 + side3 && side3 <= side1 + side2;
    }


}
