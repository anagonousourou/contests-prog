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
    let parts1: Vec<i32> = version1.split(".").map(|x| x.parse::<i32>().unwrap()).collect();
    let parts2: Vec<i32> = version2.split(".").map(|x| x.parse::<i32>().unwrap()).collect();
    
    let l = usize::max(parts1.len(), parts2.len());
    for i in 0..l{
        if parts1.get(i).unwrap_or(&0) > parts2.get(i).unwrap_or(&0) {
            return true;
        }
        else if parts1.get(i).unwrap_or(&0) < parts2.get(i).unwrap_or(&0){
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
        if value == 1{
            sum += key;
        }  
    }
    return sum;
}
