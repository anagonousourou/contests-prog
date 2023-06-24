# Returns the acronym of the given phrase.
#
# + phrase - a string
# + return - the acronym
function abbreviate(string phrase) returns string {
    string:RegExp r = re `\s+|-|_`;
    var initials = r.split(phrase).filter(token => token.trim().length() > 0).'map(token => token.toUpperAscii().substring(0,1));
    return string:'join("",...initials);
}
