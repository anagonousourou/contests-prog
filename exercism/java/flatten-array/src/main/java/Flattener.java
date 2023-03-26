import java.util.ArrayList;
import java.util.List;

public class Flattener {
    public List<Object> flatten(Object object) {
        return Flattener.flatten(object, new ArrayList<>());
    }

    public static List<Object> flatten(Object object, List<Object> result) {
        if (object == null) {
            return result;
        }
        if (object instanceof List) {
            List<Object> objects = (List<Object>) object;
            if (objects.isEmpty()) {
                return result;
            } else {
                Flattener.flatten(first(objects), result);
                return Flattener.flatten(rest(objects), result);
            }
        } else {
            result.add(object);
            return result;
        }

    }

    public static <A> A first(List<A> input) {
        return input.get(0);
    }

    public static <A> List<A> rest(List<A> input) {
        if (input.size() <= 1) {
            return List.of();
        }
        return input.subList(1, input.size());
    }

}
