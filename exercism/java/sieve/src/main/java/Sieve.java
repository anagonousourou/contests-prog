import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {
    private final int maxPrime;
    Sieve(int maxPrime) {
        this.maxPrime = maxPrime + 1;
    }

    List<Integer> getPrimes() {
        boolean[] sieve = new boolean[this.maxPrime];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i < Math.sqrt(this.maxPrime); i++) {
            if(sieve[i]){
                for (int j = i*i; j < this.maxPrime;  j = j+ i) {
                    sieve[j] = false;
                }
            }
        }
        return IntStream.range(2, this.maxPrime).filter(i -> sieve[i]).boxed().collect(Collectors.toList());
    }
}
