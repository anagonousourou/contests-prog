# Description
#
# + sentence - a phrase
# + return - true if the phrase is an isogram, false if not
public function isIsogram(string sentence) returns boolean {
    var lowerSentence = sentence.toLowerAscii().iterator();
    map<int> freqMap = {};
    var c = lowerSentence.next();
    while c != null {
        if c.value.toCodePointInt() >= "a".toCodePointInt() && c.value.toCodePointInt() <= "z".toCodePointInt() {
            if (freqMap.hasKey(c.value)) {
                return false;
            }
            else {
                freqMap[c.value] = 1;
            }
        }
        c = lowerSentence.next();
    }
    return true;
}
