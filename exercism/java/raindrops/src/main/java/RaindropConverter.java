import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RaindropConverter {

    String convert(int number) {
        if (Stream.of(3, 5, 7).noneMatch(p -> number % p == 0)) {
            return String.valueOf(number);
        }
        return Stream.of(Map.entry(3, "Pling"), Map.entry(5, "Plang"), Map.entry(7, "Plong"))
                .filter(raindrop -> number % raindrop.getKey() == 0)
                .map(Map.Entry::getValue).collect(Collectors.joining());
    }

}
