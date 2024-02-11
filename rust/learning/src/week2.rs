use crate::plusminus;



fn sockMerchant(n: i32, ar: &[i32]) -> i32 {
    let freqs = plusminus::frequencies_i32(ar);
    let mut nb_pairs = 0;
    for (_key, value) in freqs {
        nb_pairs += value / 2;
    }
    
    return nb_pairs as i32;
}

fn maxMin(k: i32, arr: &mut[i32]) -> i32 {
    arr.sort();

    let mut unfairness = i32::MAX;
    for i in  0..arr.len() - 1 {
    
        if i + (k as usize) -1 < arr.len() &&  arr[i + (k as usize) - 1] - arr[i] < unfairness {
            unfairness = arr[i + (k as usize) - 1] - arr[i];
        }
    }

    return unfairness;
}