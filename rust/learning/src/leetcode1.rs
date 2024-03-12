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
