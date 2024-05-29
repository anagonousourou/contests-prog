use std::collections::{HashMap, HashSet};

use crate::plusminus;

//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/submissions/1199417194/
pub fn replace_elements(arr: Vec<i32>) -> Vec<i32> {
    let mut current_max = -1;
    let mut arr_clone = arr.clone();
    for i in (0..arr.len()).rev() {
        let tmp = arr[i];
        arr_clone[i] = current_max;
        current_max = i32::max(tmp, current_max);
    }

    return arr_clone;
}

//https://leetcode.com/problems/find-the-k-beauty-of-a-number/submissions/1199471711/
pub fn divisor_substrings(num: i32, k: i32) -> i32 {
    let num_str = num.to_string();
    return num_str
        .as_str()
        .split("")
        .filter(|s| !s.is_empty())
        .collect::<Vec<&str>>()
        .windows(k as usize)
        .map(|digits| digits.join(""))
        .map(|subtr| subtr.parse::<i32>())
        .filter(|n| n.is_ok() && n.clone().unwrap() != 0 && num % n.clone().unwrap() == 0)
        .count() as i32;
}

//https://leetcode.com/problems/robot-return-to-origin/description/

pub fn judge_circle(moves: String) -> bool {
    let movesMap = moves
        .split("")
        .map(|x| String::from(x))
     // Fold the iterator into a hash map of frequencies
     .fold(HashMap::new(), |mut acc, e| {
         // Insert or update the element and its count in the hash map
         *acc.entry(e.clone()).or_insert(0) += 1;
         // Return the updated hash map
         acc
     });
    return movesMap.get(&"U".to_string()).copied().unwrap_or(0)
        == movesMap.get(&"D".to_string()).copied().unwrap_or(0)
        && movesMap.get(&"L".to_string()).copied().unwrap_or(0)
            == movesMap.get(&"R".to_string()).copied().unwrap_or(0);
}

// https://leetcode.com/problems/reverse-prefix-of-word/?envType=daily-question&envId=2024-05-01

pub fn reverse_prefix(word: String, ch: char) -> String {
    match word.find(ch) {
        Some(bound) => {
            let prefix: String = word.as_str()[..bound + 1].chars().rev().collect();

            return format!(
                "{}{}",
                prefix,
                word.as_str().chars().skip(bound + 1).collect::<String>()
            );
        }
        None => return word,
    }
}

// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/submissions/1247098391/?envType=daily-question&envId=2024-05-02

pub fn find_max_k(nums: Vec<i32>) -> i32 {
    let mut mynums = nums.clone();
    mynums.sort_by_key(|k| -k.abs());

    for i in 0..nums.len() - 1 {
        if mynums[i] == -mynums[i + 1] {
            return mynums[i].abs();
        }
    }
    return -1;      
}

// https://leetcode.com/problems/add-digits/description/
pub fn add_digits(num: i32) -> i32 {
    if num >= 10 {
        return add_digits(
            num.to_string()
                .chars()
                .map(|d| d.to_digit(10).unwrap() as i32)
                .sum::<i32>(),
        );
    }
    return num;
}

pub fn add_digits_improved(num: i32) -> i32 {
    if num < 10 {
        return num;
    } else {
        return add_digits(num / 10 + num % 10);
    }
}

// https://en.wikipedia.org/wiki/Digital_root
// https://leetcode.com/problems/add-digits/submissions/1267278230/
pub fn add_digits_constant_runtime(num: i32) -> i32 {
    if num == 0 {
        return 0;
    } else {
        return 1 + (num - 1) % 9;
    }
}

// https://leetcode.com/problems/calculate-digit-sum-of-a-string/description/
// https://leetcode.com/problems/calculate-digit-sum-of-a-string/submissions/1267294090/
fn digit_sum_internal(s: String, k: usize) -> String {
    if s.len() <= k {
        return s;
    } else {
        let mut i = 0;
        let mut result = String::from("");

        while i < s.len() {
            let part = s
                .chars()
                .skip(i)
                .take(k)
                .map(|d| d.to_digit(10).unwrap())
                .sum::<u32>()
                .to_string();
            result.push_str(&part);
            i = i + k;
        }

        return digit_sum_internal(result, k);
    }
}
pub fn digit_sum(s: String, k: i32) -> String {
    return digit_sum_internal(s, k as usize);
}

// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/submissions/1267320425/
pub fn get_lucky(s: String, k: i32) -> i32 {
    let mut tmp = s
        .chars()
        .map(|c| (c as u8) - ('a' as u8) + 1)
        .map(|c| c.to_string())
        .collect::<Vec<String>>()
        .join("");

    for _i in 0..k {
        if tmp.len() < 2 {
            return tmp.parse::<i32>().unwrap();
        } else {
            tmp = tmp
                .chars()
                .map(|c| c.to_digit(10).unwrap() as u64)
                .sum::<u64>()
                .to_string();
        }
    }
    return tmp.parse::<i32>().unwrap();
}

// https://leetcode.com/problems/count-integers-with-even-digit-sum/description/
// https://leetcode.com/problems/count-integers-with-even-digit-sum/submissions/1267342057/
pub fn count_even(num: i32) -> i32 {
    return (1..num + 1)
        .filter(|i| {
            i.to_string()
                .chars()
                .map(|c| c.to_digit(10).unwrap() as u64)
                .sum::<u64>()
                % 2
                == 0
        })
        .count() as i32;
}

// https://leetcode.com/problems/sort-array-by-parity/
// https://leetcode.com/problems/sort-array-by-parity/submissions/1267356809/
pub fn sort_array_by_parity(nums: Vec<i32>) -> Vec<i32> {
    let mut mynums = nums.clone();
    mynums.sort_by_key(|k| if k % 2 == 0 { 0 } else { 1 });
    return mynums;
}

// https://leetcode.com/problems/count-largest-group/
// https://leetcode.com/problems/count-largest-group/submissions/1268728015/
pub fn count_largest_group(n: i32) -> i32 {
    let mut groups: HashMap<u32, Vec<i32>> = HashMap::new();
    for i in 1..=n {
        let digits_sum = i
            .to_string()
            .chars()
            .map(|c| c.to_digit(10).unwrap())
            .sum::<u32>();
        groups.entry(digits_sum).or_insert_with(Vec::new).push(i);
    }
    let largest_size = groups.values().map(|g| g.len()).max().unwrap();
    return groups.values().filter(|g| g.len() == largest_size).count() as i32;
}

// https://leetcode.com/problems/capitalize-the-title/
// https://leetcode.com/problems/capitalize-the-title/submissions/1268741874/
pub fn capitalize_title(title: String) -> String {
    return title
        .split_ascii_whitespace()
        .map(|word| {
            if word.len() <= 2 {
                return word.to_lowercase();
            }
            let (first, last) = word.split_at(1);
            return format!("{}{}", first.to_uppercase(), last.to_lowercase());
        })
        .collect::<Vec<String>>()
        .join(" ");
}

// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/submissions/1268748815/
pub fn average(salary: Vec<i32>) -> f64 {
    let mut salary_copy = salary.clone();
    salary_copy.sort();
    return salary_copy
        .into_iter()
        .skip(1)
        .take(salary.len() - 2)
        .map(|x| x as i64)
        .sum::<i64>() as f64
        / (salary.len() - 2) as f64;
}

// https://leetcode.com/problems/count-the-number-of-special-characters-i/
pub fn number_of_special_chars(word: String) -> i32 {
    let mut seen = HashSet::new();
    let mut count = 0;
    for letter in word.chars() {
        if !seen.contains(&letter) {
            seen.insert(letter);
            if letter.is_ascii_lowercase() && seen.contains(&letter.to_ascii_uppercase()) {
                count += 1;
            } else if letter.is_ascii_uppercase() && seen.contains(&letter.to_ascii_lowercase()) {
                count += 1;
            }
        }
    }
    return count;
}

// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
pub fn count_k_difference(nums: Vec<i32>, k: i32) -> i32 {
    let mut count = 0;
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            if (nums[i] - nums[j]).abs() == k {
                count += 1;
            }
        }
    }
    return count;
}

// https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/submissions/1268778868/
pub fn average_value(nums: Vec<i32>) -> i32 {
    let result = nums
        .into_iter()
        .filter(|x| x % 6 == 0)
        .fold((0, 0), |acc, e| (acc.0 + e, acc.1 + 1));
    return if result.1 == 0 {
        0
    } else {
        result.0 / result.1
    };
}
