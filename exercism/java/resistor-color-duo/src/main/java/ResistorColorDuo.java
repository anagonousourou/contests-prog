import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ResistorColorDuo {
    private static final List<String> COLORS = List.of("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white");
    private static int colorCode(String color) {
        return COLORS.indexOf(color);
    }
    int value(String[] colors) {
        return Integer.parseInt(Arrays.stream(colors).limit(2).map(ResistorColorDuo::colorCode).map(String::valueOf).collect(Collectors.joining()));
    }
}
