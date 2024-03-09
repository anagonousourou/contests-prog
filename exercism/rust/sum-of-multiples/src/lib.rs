pub fn sum_of_multiples(limit: u32, factors: &[u32]) -> u32 {
    return (1..limit).into_iter().filter(|i| factors.iter().any(|s| *s != 0_u32 && i % s == 0)).sum();
}
