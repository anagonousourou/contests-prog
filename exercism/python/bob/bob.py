def response(statement):
    if isblank(statement):
        return "Fine. Be that way!"
    if str.isupper(statement) and str.endswith(str.strip(statement), "!"):
        return "Whoa, chill out!"
    if str.isupper(statement) and str.endswith(str.strip(statement), "?"):
        return "Calm down, I know what I'm doing!"
    if str.isupper(statement):
        return "Whoa, chill out!"
    if str.endswith(str.strip(statement), "?"):
        return "Sure."
    return "Whatever."


def isblank(statement):
    return not (statement and statement.strip())