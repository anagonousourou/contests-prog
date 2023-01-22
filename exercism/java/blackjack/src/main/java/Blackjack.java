import java.util.Map;

public class Blackjack {

    static Map<String, Integer> cardsValues = Map.ofEntries(
            Map.entry("ace", 11),
            Map.entry("two", 2),
            Map.entry("three", 3),
            Map.entry("four", 4),
            Map.entry("five", 5),
            Map.entry("six", 6),
            Map.entry("seven", 7),
            Map.entry("eight", 8),
            Map.entry("nine", 9),
            Map.entry("ten", 10),
            Map.entry("jack", 10),
            Map.entry("queen", 10),
            Map.entry("king", 10)

    );

    public int parseCard(String card) {
        return Blackjack.cardsValues.getOrDefault(card, 0);
    }

    public boolean isBlackjack(String card1, String card2) {
        return this.parseCard(card2) + this.parseCard(card1) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (!isBlackjack) {
            return "P";
        } else {
            if (dealerScore != 11 && dealerScore != 10) {
                return "W";
            } else {
                return "S";
            }
        }
    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore >= 17) {
            return "S";
        } else if (handScore <= 11) {
            return "H";
        } else if ((12 <= handScore && handScore <= 16)) {
            if (dealerScore >= 7) {
                return "H";
            } else {
                return "S";
            }

        }
        return null;
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the
    // cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls
    // the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
