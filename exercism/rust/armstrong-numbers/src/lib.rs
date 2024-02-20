pub fn is_armstrong_number(num: u32) -> bool {
    return num.to_string().chars().map(|c| c.to_digit(10).unwrap())
    .map(|i|  u64::pow(i as u64, num.to_string().len() as u32)).sum::<u64>() == num.into();
}
