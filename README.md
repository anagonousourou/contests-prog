# contests-prog

This repository is for trying out languages and algorithms...

## Notable features

To simplify what is an interesting feature worth noting, let's use `Java 17` as our baseline. We will essentially list notable features that are not available in the standard library / not the default or are harder to get in Java 17. **It is not meant to be thorough or a X vs Y comparison**. Objectives include: better understand the programming languages by writing down what I learn, summarise the tradeoffs made by each language, get an idea of what they are very good, good, bad, very bad at.

### Ballerina

- XML as first class (literals, manipulation)
- JSON & CSV functions & types built-in
- Exhaustive error handling (errors are values)
- Union types, structural typing
- Light thread
- Allow use of keyword as name when quoted `'keyword`
- No silent overflow of number arithmetics (throw runtime exception)
- Unicode characters for names



### Clojure

- No operator precedence
- Macros
- Immutability
- No silent overflow of number arithmetics (throw runtime exception)
- Transactional memory
- Operators like `+`, `*`, ... are functions
- Threading macros `->`, `->>` (aka pipe operators)
- Rationals

#### Cheatsheet
- https://clojure.org/api/cheatsheet

### C++

### D

- [UFCS](https://en.wikipedia.org/wiki/Uniform_Function_Call_Syntax) Chaining function calls through first argument and dot: `a.greet(b)` <=> `greet(a ,b)`
- Built-in `unittest` keyword for unit tests blocks
- Contract programming
- Code coverage
- Properties `a.name()` => `a.name`
- Default parameters for functions
- Import aliasing `import std.stdio : say = writeln;`
- Built-in `deprecated` keyword
- Built-in `version` keyword for dealing with variability in compilation

#### Links
- https://github.com/dlang-community/awesome-d

### Elixir

- Pipe operator `|>`

### Elm

- Pipe operators: `|>`, `<|`


### Java

### Javascript

### Julia

- Macros
- Unicode character & emojis in source code and for variable/function names
- Operators like `+`, `*`, ... are functions
- Pipe operator `|>`
- Complex numbers, rational, bigDecimals, bigInteger, matrices and operators/functions to manipulate and mix them
- Broadcasting operator `.`

#### Cheatsheet
- https://cheatsheet.juliadocs.org/

### Python

- Arbitrary integer precision

### Raku
- Gradual typing
- Contract programming with constraints
- Rationals

### Rust

- Macros

#### Links
- https://github.com/rust-unofficial/awesome-rust

### Scala


## Links

### Julia

- https://stackoverflow.com/questions/56558013/how-to-check-if-a-string-is-numeric-julia
- https://stackoverflow.com/questions/54935955/convert-regex-match-into-string
- https://stackoverflow.com/questions/72216122/how-to-check-if-a-string-is-alphanumeric
- https://stackoverflow.com/questions/29143667/whats-the-best-way-to-convert-an-int-to-a-char-in-julia#29146061
- https://stackoverflow.com/questions/40520131/convert-float-to-int-in-julia-lang#40539387
- https://stackoverflow.com/questions/35042458/how-to-fill-an-array-by-row-in-julia#35042583



If there is one thing that decades of computing have taught us, it must be that
discipline-oriented programming does not scale.








