import java.util.HashSet;
import java.util.Set;

public class NaturalNumber {

    private final int n;

    public NaturalNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.n = n;
    }

    public Classification getClassification() {
        if (n == 1) {
            return Classification.DEFICIENT;
        }
        int aliquotSum = getDivisors(n).stream().mapToInt(e -> e).sum();
        if (aliquotSum < n) {
            return Classification.DEFICIENT;
        } else if (aliquotSum == n) {
            return Classification.PERFECT;
        }
        return Classification.ABUNDANT;
    }

    /**
     * @param n a positive integer
     * @return the divisors of n
     */
    static Set<Integer> getDivisors(int n) {
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (n / i != n) {
                    divisors.add(n / i);
                }

            }
        }
        return divisors;
    }
}
