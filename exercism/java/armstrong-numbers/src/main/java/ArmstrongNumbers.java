

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int numberOfDigits = String.valueOf(numberToCheck).length();
        return String.valueOf(numberToCheck).chars().map(Character::getNumericValue).mapToLong(i -> (long) Math.pow(i, numberOfDigits)).sum() == numberToCheck;
    }

}
