import java.util.Comparator;
import java.util.List;
import java.util.Random;

class DnDCharacter {
    private static final Random random = new Random(47L);

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int wisdom;
    private final int charisma;
    private final int hitpoints;
    private final int intelligence;


    public DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.charisma = ability(rollDice());
        this.constitution = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.intelligence = ability(rollDice());

        this.hitpoints = modifier(constitution) + 10;
    }

    int ability(List<Integer> scores) {
        return scores.stream().sorted(Comparator.reverseOrder()).limit(3).mapToInt(Integer::intValue).sum();
    }

    List<Integer> rollDice() {
        return random.ints(4, 1, 7).boxed().toList();
    }

    int modifier(int input) {
        return (int) Math.floor((double) (input - 10) / 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }
}
