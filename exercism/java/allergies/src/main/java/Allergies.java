import java.util.Arrays;
import java.util.List;

public class Allergies {
    private final int score;
    public Allergies(int score){
        this.score = score;
    }
    public boolean isAllergicTo(Allergen allergen){
        return (score & allergen.getScore()) == allergen.getScore();
    }

    public List<Allergen> getList(){
        return Arrays.stream(Allergen.values()).filter(this::isAllergicTo).toList();
    }
}
