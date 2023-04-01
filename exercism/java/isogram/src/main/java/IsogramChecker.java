class IsogramChecker {

    boolean isIsogram(String phrase) {
        return phrase.toLowerCase().chars().filter(Character::isLetter).count() == phrase.toLowerCase().chars().filter(Character::isLetter).distinct().count();
    }

}
