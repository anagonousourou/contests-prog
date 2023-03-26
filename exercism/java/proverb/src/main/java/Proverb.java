class Proverb {

    private final String proverb;
    Proverb(String[] words) {
        this.proverb = createText(words);
    }

    private static String createText(String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                return stringBuilder.append(String.format("And all for the want of a %s.", words[0])).toString();
            }
            stringBuilder.append(String.format("For want of a %s the %s was lost.\n", words[i], words[i + 1]));

        }
        return stringBuilder.toString();
    }

    String recite() {
        return this.proverb;
    }

}
