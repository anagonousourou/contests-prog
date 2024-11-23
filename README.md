# contests-prog

`If there is one thing that decades of computing have taught us, it must be that
discipline-oriented programming does not scale.`
Andrei Alexandrescu

`Civilization advances by extending the number of important operations which we can perform without thinking about them`
Alfred North Whitehead

This repository is for trying out languages and algorithms...


## Problem solving notes

Strategies to solve problems:
- sort input
- binary search
- translate into graph problem
- sliding window
- prefix/suffix arrays
- 

### Algorithms
- Evaluate Reverse Polish Notation


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
- Software Transactional Memory buit-in
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

#### Links
- [Elm and finding your right path, with Evan Czaplicki](https://www.youtube.com/watch?v=qtoeLN3nrTg)
- [Elm: Build Elegant UIs the Functional Way](https://www.youtube.com/watch?v=_Hq8bofP5jY)


### Java

#### Links
- [97 Things Every Java Prog. Should Know](https://www.youtube.com/watch?v=YAXGU2J7XjM)

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
- Result(Ok, Err) and Option(Some, None) built-in


#### Links
- https://github.com/rust-unofficial/awesome-rust

### Scala


## Links

## Interesting Technologies
- DuckDB
- Splunk
- Grafana
- Kubernetes
- [OpenTelemetry](https://www.youtube.com/watch?v=jC1icupHlMs)

### Julia

- https://stackoverflow.com/questions/56558013/how-to-check-if-a-string-is-numeric-julia
- https://stackoverflow.com/questions/54935955/convert-regex-match-into-string
- https://stackoverflow.com/questions/72216122/how-to-check-if-a-string-is-alphanumeric
- https://stackoverflow.com/questions/29143667/whats-the-best-way-to-convert-an-int-to-a-char-in-julia#29146061
- https://stackoverflow.com/questions/40520131/convert-float-to-int-in-julia-lang#40539387
- https://stackoverflow.com/questions/35042458/how-to-fill-an-array-by-row-in-julia#35042583

https://github.com/coalton-lang/coalton

### Roc-lang
- https://www.roc-lang.org
- [Introduction to Roc Programming Language by Richard Feldman](https://www.youtube.com/watch?v=7R204VUlzGc)


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

- [Rapid Web Productivity in Elm - Single Page Apps & More • Christopher Biggs • YOW! 2019](https://www.youtube.com/watch?v=Vp9oy1OYT4U)

### CoffeeScript

## Dynamism vs immutability for runtime environments
Application servers like Tomcat and TomEE enable you to add and remove capabilities to your running service by updating jars on the fly.
Similar dynamism is possible with DLLs and Shared libraries.
On the other hand images/containers let you build and immutable application and the only (proper/safe) way to add capabilities is to shutdown the old container and start a new container based on the new image with the added capability. 
The questions that comes to mind is what are the tradeoffs for each of those ways of updating a running application ?
- https://blog.frankel.ch/monkeypatching-java/

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
- https://www.youtube.com/watch?v=ucTfG6nLr7Y
- [So You Think You Know Git](https://www.youtube.com/watch?v=aolI_Rz0ZqY)
- [So You Think You Know Git 2](https://www.youtube.com/watch?v=Md44rcw13k4)
- [The next big Thing - Andrei Alexandrescu](https://youtube.com/watch?v=tcyb1lpEHm0)
- [Better Code Reviews FTW! - Tess Ferrandez-Norlander - NDC London 2024](https://www.youtube.com/watch?v=VuG4QhA89es)
- [Code Review, you said? - Venkat Subramaniam](https://www.youtube.com/watch?v=OLp4yecQp2Y)
- [Things I learned after a decade of writing code generators](https://www.youtube.com/watch?v=TQXmmBiB2bk)
- [Flow: the worst software development approach in history by Sander Hoogendoorn & Kim Van Wilgen](https://www.youtube.com/watch?v=FahSLxZrsCs)
- [Backwards Compatible- Lessons from a Quarter Century in Software - Anjuan Simmons](https://www.youtube.com/watch?v=ucTfG6nLr7Y)
- [CppCon 2015: Andrei Alexandrescu “Declarative Control Flow"](https://www.youtube.com/watch?v=WjTrfoiB0MQ&t=2s)
- [Types are like the Weather, Type Systems are like Weathermen - Matthias Felleisen](https://www.youtube.com/watch?v=XTl7Jn_kmio)
- [Java's Hidden Gems: Tools and Libraries by Johan Janssen](https://www.youtube.com/watch?v=ABm0KhsZJ0c)
- [11 Crazy Things I Didn't Know You Could Do With Java Until I Got My Java 11 Certification](https://www.youtube.com/watch?v=J3dqRwNQONE)
- [](https://www.youtube.com/watch?v=BaUrpq_7KMk)
- [Seven Ways to Fail at Microservices](https://www.youtube.com/watch?v=nEO4eAr2AGE)
- [Full Stack Dart](https://www.youtube.com/watch?v=tkmpt28UhyY)
- [Why Distributed Systems Are Hard](https://www.youtube.com/watch?v=w9GP7MNbaRc)
- [Design Patterns Revisited in Modern Java by Venkat Subramaniam](https://www.youtube.com/watch?v=V7iW27F9oog)
- [Programming with ServiceLoader API in Java - Venkat Subramaniam](https://www.youtube.com/watch?v=4mT7qPMLkYE)
- [Designing Applications with Functional Programming Constructs - Venkat Subramaniam](https://www.youtube.com/watch?v=FROze1XrBb4)
- [The Power and Practicality of Immutability by Venkat Subramaniam](https://www.youtube.com/watch?v=FQERMVABRrQ)
- [How to Approach Refactoring - Venkat Subramaniam](https://www.youtube.com/watch?v=oZ6LLooOoqE)
- [Optional - The Mother of All Bikesheds by Stuart Marks](https://www.youtube.com/watch?v=Ej0sss6cq14)
- [10,000 Java performance tips over 15 years - what did I learn? by Jack Shirazi](https://www.youtube.com/watch?v=OYpTn0nWKR4)
- [JUnit 5's Best Features by Kenneth Kousen](https://www.youtube.com/watch?v=vwtAiawChho)
- [“Wouldn’t it be cool…” and other bad design approaches - Billy Hollis - NDC London 2023](https://www.youtube.com/watch?v=GGUqyb6mzDw)
- [Don’t Build a Distributed Monolith - Jonathan "J." Tower - NDC London 2023](https://www.youtube.com/watch?v=p2GlRToY5HI)
- [Autonomous microservices don't share data. Period. - Dennis van der Stelt - NDC Porto 2023](https://www.youtube.com/watch?v=_UN50hNZlx4)
- [Six Little Lines of Fail - Jimmy Bogard](https://www.youtube.com/watch?v=VvUdvte1V3s)
- [Lies Developers Tell Themselves - Billy Hollis - NDC Porto 2023](https://www.youtube.com/watch?v=rySTB112z6w)
- ["The Mess We're In" by Joe Armstrong](https://www.youtube.com/watch?v=lKXe3HUG2l4)
- [Domain Modeling Made Functional - Scott Wlaschin - KanDDDinsky 2019](https://www.youtube.com/watch?v=2JB1_e5wZmU)
- [Refactoring to Immutability - Kevlin Henney](https://www.youtube.com/watch?v=APUCMSPiNh4)
- [Keynote: Gang of None? Design Patterns in Elixir - José Valim | ElixirConf EU 2024](https://www.youtube.com/watch?v=agkXUp0hCW8)
- [Scott Wlaschin — Railway oriented programming](https://www.youtube.com/watch?v=fYo3LN9Vf_M)
- [Scott Wlaschin - Coding Like Frankenstein](https://www.youtube.com/watch?v=d2yLsBn_Lz0)
- [Reinventing the Transaction Script - Scott Wlaschin](https://www.youtube.com/watch?v=USSkidmaS6w)
- [Four Languages from Forty Years Ago - Scott Wlaschin](https://www.youtube.com/watch?v=mRwHZTNGdoY)
- [The Functional Programmer's Toolkit - Scott Wlaschin](https://www.youtube.com/watch?v=Nrp_LZ-XGsY)
- [How Netflix Really Uses Java](https://www.youtube.com/watch?v=BaUrpq_7KMk)
- [Livebook & Elixir: Where AI, Web & Concurrency Meet • José Valim • YOW! 2023](https://www.youtube.com/watch?v=pas9WdWIBHs)
- [FPGA Microservices: Ultra-Low Latency with Off-The-Shelf Hardware • Conrad Parker • YOW! 2016](https://www.youtube.com/watch?v=8MW0RN1IsWY)



### Readlist
- https://planetscale.com/blog/the-problem-with-using-a-uuid-primary-key-in-mysql
- https://en.wikipedia.org/wiki/Fallacies_of_distributed_computing


### Tools list
- https://witeboard.com/
- https://devdocs.io/
- https://cyberchef.org
- https://www.emathhelp.net/en/calculators/discrete-mathematics/boolean-algebra-calculator/
- https://calculis.net/combinaison
