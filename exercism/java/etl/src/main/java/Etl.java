import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> newMap = new HashMap<>();
        old.forEach(((valueType, keyTypes) ->
                keyTypes.forEach(keyType ->
                        newMap.put(keyType.toLowerCase(), valueType)
                )
        ));
        return newMap;
    }
}
