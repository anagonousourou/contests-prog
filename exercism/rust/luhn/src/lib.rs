/// Check a Luhn checksum.
pub fn is_valid(code: &str) -> bool {
    let credit_card_number = code
        .trim()
        .replace(" ", "")
        .chars()
        .rev()
        .collect::<String>();

    if credit_card_number.len() <= 1 {
        return false;
    }

    let mut s = 0;
    let mut i = 0;
    for digit in credit_card_number.chars() {
        if !digit.is_digit(10) {
            return false;
        }
        if i % 2 == 1 {
            let mut digit_value = digit.to_digit(10).unwrap() * 2;
            digit_value = if digit_value > 9 {
                digit_value - 9
            } else {
                digit_value
            };
            s += digit_value;
        } else {
            s += digit.to_digit(10).unwrap();
        }
        i += 1;
    }
    return s % 10 == 0;
}
