let getWithDefault = (mydict, key, y) => {
  switch (Js.Dict.get(mydict, key)) {
  | Some(x) => x
  | None => y
  };
};
let reseq = phrase => {
  let wordRegex = [%re "/\\w+'\\w+|\\w+/g"];
  let break = ref(false);
  let actualWords: array(string) = [||];
  while (!break.contents) {
    switch (Js.Re.exec_(wordRegex, phrase)) {
    | Some(x) => Js.Array.push(Js.Re.matches(x)[0], actualWords)
    | None =>
      break := true;
      0;
    };
  };
  Array.to_list(actualWords);
};

let wordCount: string => Js.Dict.t(int) =
  phrase => {
    // Split the phrase into words by punctuation and whitespace
    // Create an empty dictionary to store the word counts
    let counts = Js.Dict.empty();
    // Iterate over the words and update the counts
    reseq(phrase)
    |> List.iter(word => {
         // Convert the word to lowercase
         let word = String.lowercase_ascii(word);
         // Get the current count of the word or zero if not found
         let count = getWithDefault(counts, word, 0);
         // Increment the count by one and set it in the dictionary
         Js.Dict.set(counts, word, count + 1);
       });
    // Return the dictionary of word counts
    counts;
  };
