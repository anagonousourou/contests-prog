import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix {

    private final int[][] array2d;

    Matrix(String matrixAsString) {
        List<Integer> numbers = reSeq(Pattern.compile("\\d+"), matrixAsString).stream().map(Integer::parseInt).toList();
        int rowCount = (int) matrixAsString.chars().filter(c -> (char)c  == '\n').count() + 1;
        int columnCount = numbers.size() / rowCount;
        array2d = new int[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                array2d[i][j] = numbers.get(i * columnCount + j);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return this.array2d[rowNumber - 1].clone();
    }

    int[] getColumn(int columnNumber) {
        int[] column = new int[this.array2d.length];
        for (int i = 0; i < column.length; i++) {
            column[i] = this.array2d[i][columnNumber - 1];
        }
        return column;
    }

    public static List<String> reSeq(Pattern re, String input) {
        List<String> tokens = new ArrayList<>();
        Matcher m = re.matcher(input);

        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }
}
