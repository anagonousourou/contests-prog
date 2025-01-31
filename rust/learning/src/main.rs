mod adventofcode2017;
mod adventofcode2018;
mod codewars;
mod leetcode1;
mod plusminus;
mod week2;

use std::fs::File;
use std::io::{self, BufRead, Write};
use std::path::Path;

fn main() -> io::Result<()>{
    // Specify the file path here
    let path = Path::new("adventofcode-inputs/2018/day2.txt");

    // Open the file in read-only mode
    let file = File::open(&path)?;

    // Create a new buffered reader for the file
    let reader = io::BufReader::new(file);

    let lines = reader.lines().map(|l| l.unwrap()).collect::<Vec<String>>();
    
    println!("Result = {}", adventofcode2018::checksum_part1(lines));
    println!("modulo {}", -1i32.rem_euclid(2));
    Ok(())
}
