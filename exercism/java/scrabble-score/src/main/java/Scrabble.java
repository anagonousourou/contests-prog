import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Scrabble {
    static final Map<Integer, Collection<Character>> scoresMapInitial = Map.ofEntries(
            Map.entry(1, Set.of('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T')),
            Map.entry(2, Set.of('D', 'G')),
            Map.entry(3, Set.of('B', 'C', 'M', 'P')),
            Map.entry(4, Set.of('F', 'H', 'V', 'W', 'Y')),
            Map.entry(5, Set.of('K')),
            Map.entry(8, Set.of('J', 'X')),
            Map.entry(10, Set.of('Q', 'Z'))
    );

    static final Map<Character, Integer> scoreMap = transform(scoresMapInitial);
    private final String word;

    Scrabble(String word) {
        this.word  = word;
    }

    int getScore() {
        return word.toUpperCase().chars().map(c -> scoreMap.getOrDefault((char) c, 0)).sum();
    }

    static <KeyType, ValueType> Map<KeyType, ValueType> transform(Map<ValueType, Collection<KeyType>> originalMap) {
        Map<KeyType, ValueType> newMap = new HashMap<>();
        originalMap.forEach(((valueType, keyTypes) ->
                keyTypes.forEach(keyType ->
                        newMap.put(keyType, valueType)
                )
        ));
        return newMap;
    }

}
