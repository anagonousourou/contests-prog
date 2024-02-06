mod plusminus;
mod week2;

use std::env;
use std::fs::File;
use std::io::{self, BufRead, Write};

fn main() {
    println!("{}", plusminus::flipping_bits(1)) ;
}
