let rec digits_of_number = n =>
  if (n < 10) {
    [
      n // base case: return a list with one digit
    ];
  } else {
    let rest = digits_of_number(n / 10); // recursive call: get the digits of n / 10
    let last = n mod 10; // get the last digit of n
    List.append(rest, [last]); // append the last digit to the rest of the digits
  };

let validate: int => bool =
  n => {
    let length = String.length(string_of_int(n));
    digits_of_number(n)
    |> List.map(s =>
         int_of_float(float_of_int(s) ** float_of_int(length))
       )
    |> List.fold_left((a, b) => a + b, 0) == n;
  };
