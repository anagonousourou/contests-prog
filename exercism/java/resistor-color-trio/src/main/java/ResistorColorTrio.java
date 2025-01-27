import java.util.Map;

class ResistorColorTrio {
  private static final Map<String, Integer> matches = Map.of(
          "black", 0,
          "brown", 1,
          "red", 2,
          "orange", 3,
          "yellow", 4,
          "green", 5,
          "blue", 6,
          "violet", 7,
          "grey", 8,
          "white", 9
  );

  String label(String[] colors) {
    String result = matches.get(colors[0]).toString() + matches.get(colors[1]).toString()
            + "0".repeat(matches.get(colors[2]));
    long value = Long.parseLong(result);
    if (value != 0 && result.endsWith("0".repeat(9))) {
      return "%d gigaohms".formatted(value / 1_000_000_000);
    } else if (value != 0 && result.endsWith("0".repeat(6))) {
      return "%d megaohms".formatted(value / 1_000_000);
    } else if (value != 0 && result.endsWith("0".repeat(3))) {
      return "%d kiloohms".formatted(value / 1_000);
    } else {
      return "%d ohms".formatted(value);
    }
  }
}
