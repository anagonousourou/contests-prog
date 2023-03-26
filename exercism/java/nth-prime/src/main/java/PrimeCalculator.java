import java.util.stream.IntStream;

class PrimeCalculator {

    int nth(int nth) {
        return IntStream.iterate(2, i -> i + 1).filter(PrimeCalculator::isPrime)
                .skip(nth - 1L).findFirst().getAsInt();
    }

    public static boolean isPrime(long n) {
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
