use std::collections::HashMap;
use std::collections::HashSet;

pub(crate) fn resulting_frequency_part1(lines: Vec<String>) -> i32 {
    return lines
        .iter()
        .filter(|l| !l.trim().is_empty())
        .map(|l| l.trim().parse::<i32>().unwrap())
        .sum::<i32>();
}

pub(crate) fn resulting_frequency_part2(lines: Vec<String>) -> i32 {
    let changes = lines
        .iter()
        .filter(|l| !l.trim().is_empty())
        .map(|l| l.trim().parse::<i32>().unwrap())
        .collect::<Vec<i32>>();

    let mut seen = HashSet::new();
    let mut current_frequency = 0;
    for change in changes.iter().cycle() {
        current_frequency += change;
        if !seen.insert(current_frequency) {
            return current_frequency;
        }
    }
    return 0;
}

// Day 2 part 1
pub(crate) fn checksum_part1(lines: Vec<String>) -> i32 {
    let changes = lines
        .iter()
        .filter(|l| !l.trim().is_empty())
        .map(|l| char_frequencies(l))
        .collect::<Vec<HashMap<char, usize>>>();

    let mut nb_two = 0;
    let mut nb_three = 0;
    for change in changes {
        if change.values().any(|&x| x == 2) {
            nb_two += 1;
        }

        if change.values().any(|&x| x == 3) {
            nb_three += 1;
        }
    }
    return nb_three * nb_two;
}

pub(crate) fn char_frequencies(input: &str) -> HashMap<char, usize> {
    input.chars().fold(HashMap::new(), |mut acc, c| {
        *acc.entry(c).or_insert(0) += 1;
        acc
    })
}
