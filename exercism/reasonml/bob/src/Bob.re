let isUpper = statement => {
 /* Js.Console.log(Js.String.split("", statement));*/
  String.uppercase_ascii(statement) == statement
  /*&& Js.Array.some(
       s => String.compare("a", s) <= 0 && String.compare(s, "z") <= 0,
       Js.String.split("", String.lowercase_ascii(statement)),
     );*/
  && String.exists(
      c =>
        Char.code('a') <= Char.code(Char.lowercase_ascii(c))
        && Char.code(Char.lowercase_ascii(c)) <= Char.code('z'),
      statement,
    );
};
let hey: string => string =
  statement =>
    if (String.trim(statement) |> String.length == 0) {
      "Fine. Be that way!";
    } else if (isUpper(statement)
               && String.trim(statement)
               |> String.ends_with(~suffix = "?")) {
      "Calm down, I know what I'm doing!";
    } else if (isUpper(statement)) {
      "Whoa, chill out!";
    } else if (String.trim(statement) |> String.ends_with(~suffix = "?")) {
      "Sure.";
    } else {
      "Whatever.";
    };
