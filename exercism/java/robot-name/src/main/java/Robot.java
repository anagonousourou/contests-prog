import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class Robot {
    static Random random = new Random(47L);
    private String name;
    private static final Set<String> usedNames = new HashSet<>();
    public Robot(){
        this.name = getRandomName();
    }

    static char getRandomUpperCaseLetter(){
       return (char) random.nextInt( 'A',  'Z' + 1);
    }
    static char getRandomDigit(){
        return (char) random.nextInt( '0',  '9' + 1);
    }

    public String getName() {
        return name;
    }
    public void reset(){
        this.name = getRandomName();
    }

    static String getRandomName(){
        StringBuilder stringBuilder;
        do {
            stringBuilder = new StringBuilder();
            for (int i = 0; i < 2; i++) {
                stringBuilder.append(getRandomUpperCaseLetter());
            }
            for (int i = 0; i < 3; i++) {
                stringBuilder.append(getRandomDigit());
            }
        }while (usedNames.contains(stringBuilder.toString()));

        usedNames.add(stringBuilder.toString());

        return stringBuilder.toString();
    }
}
