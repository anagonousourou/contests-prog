public class Bob {


    public String hey(String statement) {
        if (statement.trim().isEmpty()) {
            return "Fine. Be that way!";
        } else if (capital(statement) && statement.trim().endsWith("?")) {
            return "Calm down, I know what I'm doing!";
        } else if (capital(statement)) {
            return "Whoa, chill out!";
        } else if (statement.trim().endsWith("?")) {
            return "Sure.";
        } else {
            return "Whatever.";
        }
    }


    public static boolean capital(String statement) {
        return statement.chars().filter(Character::isLetter).allMatch(Character::isUpperCase)
                && statement.chars().anyMatch(Character::isLetter);
    }
}

        

          