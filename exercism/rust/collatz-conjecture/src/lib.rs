pub fn collatz(n: u64) -> Option<u64> {
    if n == 0 {
        return None;
    }
    let mut ncp = n;
    let mut nb = 0;
    while ncp != 1 {
        if ncp % 2 == 0 {
            ncp = ncp / 2;
        } else {
            let tmp = ((3 as u64).checked_mul(ncp)).and_then(|x| x.checked_add(1));
            if tmp == None{
                return None;
            }
            ncp = tmp.unwrap();
        }
        nb += 1;
    }
    return Some(nb);
}
