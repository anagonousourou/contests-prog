use std::collections::{HashMap, HashSet};

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let mut anagrams  = HashSet::new();
    
    for i in 0..possible_anagrams.len(){
        if word.to_lowercase() != possible_anagrams[i].to_lowercase() && frequencies(word) == frequencies(possible_anagrams[i]) {
            anagrams.insert(possible_anagrams[i]);
        }
    }
    return anagrams;
}

fn frequencies(word: &str) -> HashMap<String, usize> {
    // Create an iterator from the vector reference
    word.split("").filter(|s| !s.is_empty())
        // Fold the iterator into a hash map of frequencies
        .fold(HashMap::new(), |mut acc, e| {
            // Insert or update the element and its count in the hash map
            *acc.entry(e.to_lowercase()).or_insert(0) += 1;
            // Return the updated hash map
            acc
        })
}
