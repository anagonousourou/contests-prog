import java.util.HashMap;
import java.util.Map;

class RotationalCipher {

    static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    final String cipherAlphabet;
    private final Map<Character, Character> alphabetToCipher = new HashMap<>();

    RotationalCipher(int shiftKey) {
        shiftKey = shiftKey % 26;
        this.cipherAlphabet = alphabet.substring(shiftKey) + alphabet.substring(0, shiftKey);
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetToCipher.put(alphabet.charAt(i), cipherAlphabet.charAt(i));
        }
    }

    String rotate(String data) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if(Character.isUpperCase(data.charAt(i))){
                result.append(Character.toUpperCase(
                        alphabetToCipher.get(Character.toLowerCase(data.charAt(i)))));
            }
            else{
                result.append(
                        alphabetToCipher.getOrDefault(Character.toLowerCase(data.charAt(i)),data.charAt(i)));
            }
        }
        return result.toString();
    }

}
