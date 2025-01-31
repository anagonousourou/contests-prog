use std::{cmp, fmt::format};

use crate::plusminus;

/**
 * https://www.codewars.com/kata/5899dc03bc95b1bf1b0000ad
 */
fn invert(values: &[i32]) -> Vec<i32> {
    return values.iter().map(|x| -x).collect();
}

fn string_to_number(s: &str) -> i32 {
    return s.parse::<i32>().unwrap();
}

//https://www.codewars.com/kata/53b138b3b987275b46000115/solutions/rust
fn compare_versions(version1: &str, version2: &str) -> bool {
    let parts1: Vec<i32> = version1
        .split(".")
        .map(|x| x.parse::<i32>().unwrap())
        .collect();
    let parts2: Vec<i32> = version2
        .split(".")
        .map(|x| x.parse::<i32>().unwrap())
        .collect();

    let l = usize::max(parts1.len(), parts2.len());
    for i in 0..l {
        if parts1.get(i).unwrap_or(&0) > parts2.get(i).unwrap_or(&0) {
            return true;
        } else if parts1.get(i).unwrap_or(&0) < parts2.get(i).unwrap_or(&0) {
            return false;
        }
    }
    return true;
}

//https://www.codewars.com/kata/59f11118a5e129e591000134/train/rust
fn repeats(arr: &Vec<i32>) -> i32 {
    let mut sum = 0;
    let freqs = plusminus::frequencies_i32(arr);
    for (key, value) in freqs {
        if value == 1 {
            sum += key;
        }
    }
    return sum;
}

// https://www.codewars.com/kata/51f2d1cafc9c0f745c00037d/train/rust
fn solution(word: &str, ending: &str) -> bool {
    return word.ends_with(ending);
}

// https://www.codewars.com/kata/554b4ac871d6813a03000035/train/rust
fn high_and_low(numbers: &str) -> String {
    let mut nbs = numbers
        .split_ascii_whitespace()
        .map(|x| x.parse::<i32>().unwrap())
        .collect::<Vec<i32>>();
    nbs.sort();
    return format!("{} {}", nbs.last().unwrap(), nbs.first().unwrap());
}

// https://www.codewars.com/kata/5626b561280a42ecc50000d1/train/rust
fn sum_dig_pow(a: u64, b: u64) -> Vec<u64> {
    return (a..=b)
        .filter(|x| {
            x.to_string()
                .char_indices()
                .map(|(i, c)| u64::pow(c.to_digit(10).unwrap() as u64, (i + 1) as u32))
                .sum::<u64>()
                == *x
        })
        .collect();
}

// https://www.codewars.com/kata/5648b12ce68d9daa6b000099
fn number(bus_stops: &[(i32, i32)]) -> i32 {
    return bus_stops.iter().fold(0, |acc, stop| acc + stop.0 - stop.1);
}

fn is_prime(x: i64) -> bool {
    if x <= 1 {
        return false;
    }

    for i in 2..=f64::sqrt(x as f64) as i64 {
        if x % i == 0 {
            return false;
        }
    }
    return true;
}

// https://www.codewars.com/kata/578aa45ee9fd15ff4600090d

/**
[7, 1]  =>  [1, 7]
[5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */
fn sort_array(arr: &[i32]) -> Vec<i32> {
    let mut arr_copy = Vec::from(arr);
    let mut odds = (&arr_copy)
        .into_iter()
        .filter(|x| **x % 2 == 1)
        .map(|x| *x)
        .collect::<Vec<i32>>();
    odds.sort();

    let mut odd_index = 0;
    let mut all_index = 0;
    while all_index < arr_copy.len() {
        if arr_copy[all_index] % 2 == 1 {
            arr_copy[all_index] = odds[odd_index];
            odd_index += 1;
            all_index += 1;
        } else {
            all_index += 1;
        }
    }

    return arr_copy;
}

// https://www.codewars.com/kata/557cd6882bfa3c8a9f0000c1/train/rust
fn get_age(age: &str) -> u32 {
    return age
        .split_ascii_whitespace()
        .next()
        .map(|x| x.parse::<u32>().unwrap())
        .unwrap();
}

// https://www.codewars.com/kata/57a0556c7cb1f31ab3000ad7/train/rust
fn make_upper_case(s: &str) -> String {
    return s.to_uppercase();
}

// https://www.codewars.com/kata/5a2be17aee1aaefe2a000151/train/rust
fn slice_plus_slice(xs: &[i32], ys: &[i32]) -> i32 {
    return xs.iter().sum::<i32>() + ys.iter().sum::<i32>();
}

// https://www.codewars.com/kata/57a0885cbb9944e24c00008e/train/rust
fn remove_exclamation_marks(input: &str) -> String {
    return input.replace("!", "");
}

// https://www.codewars.com/kata/578553c3a1b8d5c40300037c
fn binary_slice_to_number(slice: &[u32]) -> u32 {
    return slice
        .iter()
        .enumerate()
        .map(|(idx, value)| (*value) * u32::pow(2, (slice.len() - 1 - idx) as u32))
        .sum::<u32>();
}

//
fn get_char(c: i32) -> char {
    char::from_u32(c as u32).unwrap()
}

// https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/train/rust
fn high(input: &str) -> &str {
    return input
        .split_ascii_whitespace()
        .enumerate()
        .max_by(|&(xpos, x), &(ypos, y)| {
            (u32::cmp(&word_score(x), &word_score(y))).then(usize::cmp(&xpos, &ypos).reverse())
        })
        .unwrap()
        .1;
}

fn word_score(word: &str) -> u32 {
    return word
        .chars()
        .map(|c| (c as u32) - ('a' as u32) + 1)
        .sum::<u32>();
}


// https://www.codewars.com/kata/58223370aef9fc03fd000071

// https://www.codewars.com/kata/54a91a4883a7de5d7800009c/train/rust
