(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (first deck))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (first (rest deck)))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (assoc (assoc deck 0 (second-card deck)) 1 (first-card deck)))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (vector (first-card deck) (if (empty? (rest deck)) nil (vec (rest deck)))))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (if (empty? deck) face-cards (concat (vector (first-card deck)) face-cards (get (discard-top-card deck) 1))))
