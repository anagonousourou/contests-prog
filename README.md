# contests-prog

`If there is one thing that decades of computing have taught us, it must be that
discipline-oriented programming does not scale.`

This repository is for trying out languages and algorithms...

## Languages notable features

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
- https://github.com/blachlylab/dlang-static-docker
- https://github.com/adamdruppe?tab=repositories
- https://github.com/jacob-carlborg/dvm

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

### OCaml
- Sum types

### Python

- Arbitrary integer precision

### Lua 
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

https://github.com/coalton-lang/coalton


### Software characteristic

- maintainability
- resource efficiency (memory & CPU)
- productivity
- security
- reliability



### How Cognitive Biases Affect our Software Architectures • Birgitta Böckeler • YOW! 2022

#### Zero risk bias
- Security
- Avoiding Lock-in
- Premature optimization


### Subset fallacy in programming languages
- https://www.youtube.com/watch?v=XxcSvnEIUq4

## Garbage collections

- [Garbage Collection in Lua, Roberto Ierusalimschy, PUC-Rio: LiM'19 talk 7](https://www.youtube.com/watch?v=wGizKsOJQuE)

## Schema and versionning tools

- [Avro](https://avro.apache.org/docs/#schemas)
- [Protocol buffers]()
- [OpenAPI]()
- [Thrift]()

## Messaging systems




## JavaScript comparison with its alternatives

### JavaScript
- array, objects, regex literals
- string interpolation

### ClojureScript

### PureScript

### ReasonML

### ReScript

### Elm

### CoffeeScript

## Dynamism vs immutability for runtime environments
Application servers like Tomcat and TomEE enable you to add and remove capabilities to your running service by updating jars on the fly.
Similar dynamism is possible with DLLs and Shared libraries.
On the other hand images/containers let you build and immutable application and the only (proper/safe) way to add capabilities is to shutdown the old container and start a new container based on the new image with the added capability. 
The questions that comes to mind is what are the tradeoffs for each of those ways of updating a running application.

### Watchlist

- https://www.youtube.com/watch?v=57jKNEKSNWA
- https://www.youtube.com/watch?v=ufx_3_wcPuc
- https://www.youtube.com/watch?v=pdHvC8fDC5E
- https://www.youtube.com/watch?v=SqU8TZDnFFA
- https://www.youtube.com/@CurryOn
- https://www.youtube.com/watch?v=pGF2UFG7n6Y
- [Testing Lua - Roberto Ierusalimschy](https://www.youtube.com/watch?v=yU5QNKpATxk)
- [Nix + Docker, a match made in heaven](https://www.youtube.com/watch?v=WP_oAmV6C2U)
- https://www.youtube.com/@elmonlinemeetup/videos
- [All About Regular Expressions](https://www.youtube.com/watch?v=S1pseKYYd4c&list=PLcGKfGEEONaDO2dvGEdodnqG5cSnZ96W1&index=12)