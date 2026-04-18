pub fn square(s: u32) -> u64 {
    if 1 <= s && s <= 64{
        return u64::pow(2, s-1);
        
    }else{
        panic!();
    }
    
}

pub fn total() -> u64 {
    return u64::pow(2, 64) - 1;
}
