
use std::collections::{HashMap, HashSet};
use std::io::{self, BufRead};

/*
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fn plusMinus(arr: &[i32]) {
    let nb_positives = arr.iter().filter(|&&e| e > 0).count() as f64;
    let nb_negatives = arr.iter().filter(|&&e| e < 0).count() as f64 ;
    let nb_zeros = arr.iter().filter(|&&e| e == 0).count() as f64;
    let total = arr.len() as f64;
    println!("{:.6}", nb_positives/total);
    println!("{:.6}", nb_negatives/total);
    println!("{:.6}", nb_zeros/total);
}

fn miniMaxSum(arr: &[i32]) {
    let sum:i64 =  arr.iter().map(|&x| x as i64).sum::<i64>();
    let smallest = *(arr.iter().min().unwrap()) as i64;
    let greatest = *(arr.iter().max().unwrap()) as i64;

    println!("{} {}", sum - greatest, sum - smallest);
}

fn matchingStrings(strings: &[String], queries: &[String]) -> Vec<i32> {
    let input_frequencies = frequencies(strings);
    queries.iter().map(|e| input_frequencies.get(e).unwrap_or(&0).clone() as i32).collect()
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
   if HashSet::<char>::from_iter(s.to_ascii_lowercase().chars().filter(|&x|  x != ' ')).len() == 26 { "pangram".to_string() } else {"not pangram".to_string()}
}

// Define a generic function that takes a reference to a vector of strings and returns a hash map of strings and usize values
fn frequencies (elements: &[String]) -> HashMap <String, usize> {
// Create an iterator from the vector reference
    elements.iter()
// Fold the iterator into a hash map of frequencies
        .fold(HashMap::new(), |mut acc, e| {
// Insert or update the element and its count in the hash map
            *acc.entry(e.clone()).or_insert(0) += 1;
// Return the updated hash map
            acc
        })
}



