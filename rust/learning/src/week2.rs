use crate::plusminus;



fn sockMerchant(n: i32, ar: &[i32]) -> i32 {
    let freqs = plusminus::frequencies_i32(ar);
    let mut nb_pairs = 0;
    for (_key, value) in freqs {
        nb_pairs += value / 2;
    }
    
    return nb_pairs as i32;
}