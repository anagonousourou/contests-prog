use wasm_bindgen::prelude::*;

//#[wasm_bindgen]
pub fn score(x: f64, y: f64) -> usize {
    let distance = (x.powf(2.0) + y.powf(2.0)).sqrt();
    if distance > 10.0 {
        return 0;
    } else if distance > 5.0 {
        return 1;
    } else if distance > 1.0 {
        return 5;
    } else {
        return 10;
    }
}

//#[wasm_bindgen]
pub fn is_leap(year: u32) -> bool {
    if year % 400 == 0 {
        return true;
    }
    if year % 100 == 0 {
        return false;
    }
    return year % 4 == 0;
}

//#[wasm_bindgen]
pub fn square(s: u32) -> u64 {
    if 1 <= s && s <= 64 {
        return 2_u64.pow(s - 1);
    }
    return 0;
}

//#[wasm_bindgen]
pub fn total() -> u64 {
    return 2_u64.pow(64) - 1;
}

pub fn square_root(x: i32) -> i32 {
    return (x as f32).sqrt() as i32;
}

#[wasm_bindgen]
pub fn steps(n: i32) -> i32 {
    if n <= 0 {
        return -1;
    }
    let mut count = 0;
    let mut m = n as u64;
    while m != 1 {
        if m % 2 == 0 {
            m = m / 2;
        } else {
            m = 3 * m + 1
        }
        count = count + 1;
    }
    
    return count;
}

//https://stackoverflow.com/questions/61904135/decoding-wasm-webassembly-files#61907506
#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn it_works() {
        let result = steps(12);
        assert_eq!(result, 9);
    }
}
