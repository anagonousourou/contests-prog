// Day 1 part 1
pub(crate) fn sum_matching(numbers: &str) -> u32 {
    let mut sum = 0;
    let digits = numbers.chars().collect::<Vec<char>>();
    for i in 0..digits.len() {
        if digits[i] == digits[(i + 1) % digits.len()] {
            sum += digits[i].to_digit(10).unwrap();
        }
    }
    return sum;
}

// Day 1 part 2
pub(crate) fn sum_matching_part2(numbers: &str) -> u32 {
    let mut sum = 0;
    let digits = numbers.chars().collect::<Vec<char>>();
    for i in 0..digits.len() {
        if digits[i] == digits[(i + digits.len() / 2) % digits.len()] {
            sum += digits[i].to_digit(10).unwrap();
        }
    }
    return sum;
}

// Day 2 part 1
pub(crate) fn checksum(lines: Vec<String>) -> i32 {
    return lines
        .iter()
        .filter(|l| !l.trim().is_empty())
        .map(|l| l.trim())
        .map(|l| {
            l.split_whitespace()
                .map(|word| word.parse::<i32>().unwrap())
                .max()
                .unwrap()
                - l.split_whitespace()
                    .map(|word| word.parse::<i32>().unwrap())
                    .min()
                    .unwrap()
        })
        .sum();
}

// Day 2 part 2
pub(crate) fn checksum_part2(lines: Vec<String>) -> i32 {
    return lines
        .iter()
        .filter(|l| !l.trim().is_empty())
        .map(|l| l.trim())
        .map(|l| {
            let numbers = l
                .split_whitespace()
                .map(|word| word.parse::<i32>().unwrap())
                .collect::<Vec<i32>>();
            for i in 0..numbers.len() {
                for j in i + 1..numbers.len() {
                    if numbers[i] % numbers[j] == 0 || numbers[j] % numbers[i] == 0 {
                        return i32::max(numbers[i], numbers[j]) / i32::min(numbers[i], numbers[j]);
                    }
                }
            }
            return 0;
        })
        .sum();
}
