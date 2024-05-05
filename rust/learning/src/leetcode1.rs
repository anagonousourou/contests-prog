use std::collections::HashMap;

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
     let movesMap = moves.split("").map(|x| String::from(x))
     // Fold the iterator into a hash map of frequencies
     .fold(HashMap::new(), |mut acc, e| {
         // Insert or update the element and its count in the hash map
         *acc.entry(e.clone()).or_insert(0) += 1;
         // Return the updated hash map
         acc
     });
     return movesMap.get(&"U".to_string()).copied().unwrap_or(0) == movesMap.get(&"D".to_string()).copied().unwrap_or(0) 
     && movesMap.get(&"L".to_string()).copied().unwrap_or(0)  == movesMap.get(&"R".to_string()).copied().unwrap_or(0);

}

// https://leetcode.com/problems/reverse-prefix-of-word/?envType=daily-question&envId=2024-05-01

pub fn reverse_prefix(word: String, ch: char) -> String {
    match word.find(ch) {
        Some(bound) => {
            let prefix: String = word.as_str()[..bound  + 1].chars().rev().collect();

            return format!("{}{}", prefix, word.as_str().chars().skip(bound + 1).collect::<String>());
        },
        None => {
            return word
        }
    }
}

// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/submissions/1247098391/?envType=daily-question&envId=2024-05-02

pub fn find_max_k(nums: Vec<i32>) -> i32 {
    let mut mynums = nums.clone();
    mynums.sort_by_key(|k| -k.abs());

    for i in 0..nums.len() - 1{
        if mynums[i] == - mynums[i + 1]{
            return mynums[i].abs();
        }
    }
    return -1;      
}
