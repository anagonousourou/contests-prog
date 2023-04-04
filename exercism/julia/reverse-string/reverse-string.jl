using Unicode
const TEST_GRAPHEMES = true
myreverse(phrase) = phrase |> graphemes |> collect |> reverse |> join