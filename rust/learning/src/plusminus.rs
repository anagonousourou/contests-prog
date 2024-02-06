use std::collections::{HashMap, HashSet};
use std::io::{self, BufRead};

/*
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fn plusMinus(arr: &[i32]) {
    let nb_positives = arr.iter().filter(|&&e| e > 0).count() as f64;
    let nb_negatives = arr.iter().filter(|&&e| e < 0).count() as f64;
    let nb_zeros = arr.iter().filter(|&&e| e == 0).count() as f64;
    let total = arr.len() as f64;
    println!("{:.6}", nb_positives / total);
    println!("{:.6}", nb_negatives / total);
    println!("{:.6}", nb_zeros / total);
}

fn miniMaxSum(arr: &[i32]) {
    let sum: i64 = arr.iter().map(|&x| x as i64).sum::<i64>();
    let smallest = *(arr.iter().min().unwrap()) as i64;
    let greatest = *(arr.iter().max().unwrap()) as i64;

    println!("{} {}", sum - greatest, sum - smallest);
}

fn matchingStrings(strings: &[String], queries: &[String]) -> Vec<i32> {
    let input_frequencies = frequencies(strings);
    queries
        .iter()
        .map(|e| input_frequencies.get(e).unwrap_or(&0).clone() as i32)
        .collect()
}

//https://www.hackerrank.com/challenges/one-month-preparation-kit-lonely-integer/
fn lonelyinteger(a: &[i32]) -> i32 {
    a.iter().copied().reduce(|x, y| x ^ y).unwrap_or(0)
}

//https://www.hackerrank.com/challenges/one-month-preparation-kit-two-arrays/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one
fn twoArrays(k: i32, a: &mut [i32], b: &mut [i32]) -> String {
    a.sort();
    b.sort_by(|a, b| b.cmp(a));
    for i in 0..a.len() {
        if a[i] + b[i] < k {
            return "NO".to_string();
        }
    }
    return "YES".to_string();
}

//https://www.hackerrank.com/challenges/one-month-preparation-kit-pangrams/
fn pangrams(s: &str) -> String {
    if HashSet::<char>::from_iter(s.to_ascii_lowercase().chars().filter(|&x| x != ' ')).len() == 26
    {
        "pangram".to_string()
    } else {
        "not pangram".to_string()
    }
}

// Define a generic function that takes a reference to a vector of strings and returns a hash map of strings and usize values
fn frequencies(elements: &[String]) -> HashMap<String, usize> {
    // Create an iterator from the vector reference
    elements
        .iter()
        // Fold the iterator into a hash map of frequencies
        .fold(HashMap::new(), |mut acc, e| {
            // Insert or update the element and its count in the hash map
            *acc.entry(e.clone()).or_insert(0) += 1;
            // Return the updated hash map
            acc
        })
}

pub(crate) fn frequencies_i32(elements: &[i32]) -> HashMap<i32, usize> {
    // Create an iterator from the vector reference
    elements
        .iter()
        // Fold the iterator into a hash map of frequencies
        .fold(HashMap::new(), |mut acc, e| {
            // Insert or update the element and its count in the hash map
            *acc.entry(e.clone()).or_insert(0) += 1;
            // Return the updated hash map
            acc
        })
}

fn counting_sort(arr: &[i32]) -> Vec<i32> {
    let mut occs = vec![0; 100];

    for &elt in arr {
        occs[(elt as usize)] += 1;
    }
    return occs;
}

fn diagonalDifference(arr: &[Vec<i32>]) -> i32 {
    let mut sum1 = 0;
    let mut sum2 = 0;
    for i in 0..arr.len() {
        sum1 += arr[i][i];
    }

    for i in 0..arr.len() {
        sum2 += arr[arr.len() - 1 - i][i]
    }
    return (sum1 - sum2).abs();
}

//https://www.hackerrank.com/challenges/one-month-preparation-kit-the-birthday-bar/
pub(crate) fn birthday(s: &[i32], d: i32, m: i32) -> i32 {
    let mut nb_segments = 0;
    if s.len() == 1 {
        return if s[0] == d && m == 1 { 1 } else { 0 };
    }

    for i in 0..s.len() {
        if i + (m as usize) <= s.len() && s[i..i + (m as usize)].iter().sum::<i32>() == d {
            nb_segments += 1;
        }
    }
    return nb_segments;
}

fn timeConversion(s: &str) -> String {
    let period = &s[s.len() - 2..];
    let components: Vec<&str> = s[..s.len() - 2].split(":").collect();
    let hour = components[0].parse::<i32>().unwrap();
    if period == "PM" {
        if hour == 12 {
            return s[..s.len() - 2].to_string();
        } else {
            return format!("{:02}{}", hour + 12, &s[2..s.len() - 2]);
        }
    } else {
        if hour == 12 {
            return format!("00{}", &s[2..s.len() - 2]);
        } else {
            return s[..s.len() - 2].to_string();
        }
    }
}

pub(crate) fn flipping_bits(n: i64) -> i64 {
    return (!(n as u32)) as i64;
}

fn fizzBuzz(n: i32) {
    for i in 1..n + 1 {
        if i % 15 == 0 {
            println!("FizzBuzz");
        } else if i % 5 == 0 {
            println!("Buzz");
        } else if i % 3 == 0 {
            println!("Fizz");
        } else {
            println!("{}", i);
        }
    }
}
