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

//https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/submissions/1280297992/?envType=daily-question&envId=2024-05-27
pub fn special_array(nums: Vec<i32>) -> i32 {
    for x in 0..nums.len() + 1 {
        if x == nums.iter().filter(|i| **i as usize >= x).count() {
            return x as i32;
        }
    }
    return -1;
}

// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/submissions/1280361977/
pub fn is_possible_divide(nums: Vec<i32>, k: i32) -> bool {
    if (nums.len() as i32) % k != 0 {
        return false;
    }
    let mut nums_copy = nums.clone();
    nums_copy.sort();

    let mut i = 0;
    let mut current = 0;
    let mut current_group_size = 0;
    loop {
        println!("nums {:?}", nums_copy);
        while i < nums_copy.len()
            && (nums_copy[i] == 0 || (current != 0 && nums_copy[i] == current))
        {
            i += 1;
        }
        if i == nums_copy.len() && current_group_size > 0 && current_group_size < k {
            //pas assez pour un groupe
            println!("pas assez pour un group");
            return false;
        } else if nums_copy.len() == i && current_group_size == 0 {
            // on a atteint la find sans rien ajouter au groupe
            return true;
        } else if current_group_size != k
            && nums_copy.len() > i
            && current != 0
            && current + 1 != nums_copy[i]
        {
            // pas consecutif
            println!(
                "pas consecutif current={}, group_size={}, i ={}",
                current, current_group_size, i
            );
            return false;
        } else if nums_copy.len() > i && current_group_size < k {
            // on ajoute un element au groupe
            current = nums_copy[i];
            nums_copy[i] = 0;
            current_group_size += 1;
        } else if current_group_size == k {
            // on a fini de former un groupe
            i = 0;
            current = 0;
            current_group_size = 0;
        } else {
            println!("Cas non géré {} {} {}", current, current_group_size, i);
        }
    }
}

// https://leetcode.com/problems/continuous-subarray-sum/?envType=daily-question&envId=2024-06-08
// this version timeout
pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
    let mut prefix_sums = vec![0; nums.len() + 1];

    for i in 1..prefix_sums.len() {
        prefix_sums[i] = prefix_sums[i - 1] + nums[i - 1];
    }

    for i in 0..prefix_sums.len() {
        for j in i + 2..prefix_sums.len() {
            if j < prefix_sums.len() && (j - i >= 2) && (prefix_sums[j] - prefix_sums[i]) % k == 0 {
                return true;
            }
        }
    }

    return false;
}

// https://leetcode.com/problems/continuous-subarray-sum/submissions/1281300259/?envType=daily-question&envId=2024-06-08
// Copilot version
pub fn check_subarray_sum_faster(nums: Vec<i32>, k: i32) -> bool {
    let mut map = HashMap::new();
    map.insert(0, -1);
    let mut sum = 0;

    for (i, &num) in nums.iter().enumerate() {
        sum += num;
        let modulus = sum % k;

        if let Some(&index) = map.get(&modulus) {
            if i as i32 - index >= 2 {
                return true;
            }
        } else {
            map.insert(modulus, i as i32);
        }
    }

    false
}

// https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/1282526394/
pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
    let mut prefix_sums = vec![0; nums.len() + 1];

    for i in 1..prefix_sums.len() {
        prefix_sums[i] = prefix_sums[i - 1] + nums[i - 1];
    }

    for i in 0..prefix_sums.len() {
        prefix_sums[i] = modulo(prefix_sums[i], k);
    }

    let modulus_frequencies = prefix_sums.iter().fold(HashMap::new(), |mut acc, e| {
        *acc.entry(e.clone()).or_insert(0) += 1;
        acc
    });

    //[0, -1 , 1, 10]

    return modulus_frequencies
        .values()
        .filter(|v| **v >= 2)
        .map(|v| (v * (v - 1)) / 2)
        .sum();
}

fn modulo(a: i32, b: i32) -> i32 {
    // assume b is positive
    let mut r = a % b;
    if r >= 0 {
        return r;
    }
    while r < 0 {
        r += b;
    }
    return r;
}

// https://leetcode.com/problems/sum-of-square-numbers/submissions/1290928629/
pub fn judge_square_sum(c: i32) -> bool {
    let sqrt_c = f64::sqrt(c as f64) as i32;
    for i in 0..=sqrt_c {
        if is_square(c - (i * i)) {
            return true;
        }
    }
    return false;
}
fn is_square(c: i32) -> bool {
    return f64::sqrt(c as f64).fract() == 0.0;
}
