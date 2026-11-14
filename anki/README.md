# Leetcode — Anki review deck

Deck created from the `contests-prog` LeetCode solutions, generated with the `anki-creator` CLI
(`anki_creator.py add … --create-decks`, via the AnkiConnect API).

## Deck tree

```
Leetcode
├── Theory (83 cards)
│   ├── 01 Complexity (5)
│   ├── 02 Arrays, Prefix Sums & Hashing (7)
│   ├── 03 Two Pointers & Sliding Window (7)
│   ├── 04 Strings & String Matching (5)
│   ├── 05 Stacks & Queues (5)          ← incl. monotonic stack / monotonic deque
│   ├── 06 Linked Lists (4)
│   ├── 07 Binary Trees & BST (7)
│   ├── 08 Heaps & Tries (5)
│   ├── 09 Graph Traversal (6)
│   ├── 10 Union-Find (Disjoint Sets) (3)
│   ├── 11 Sorting & Greedy (6)
│   ├── 12 Binary Search (5)
│   ├── 13 Dynamic Programming (7)
│   ├── 14 Bits, Math & Combinatorics (8)
│   └── 15 Advanced Structures (3)      ← segment tree, Fenwick, binary lifting
└── Reflexes (30)                       ← "problem shape → technique"
```

113 cards total. Note type: `Basique` (`Recto` / `Verso`), same convention as `Interview::Algorithms`,
with the source cited at the bottom of every answer and a "From your own solutions" line when a
concrete solved problem illustrates the concept.

## What counts as "actually solved"

A problem is included in the deck only if its solution file in
`Java/codingame/src/main/java/com/spa/leetcode` contains a **LeetCode submission link**
(`leetcode.com/problems/<slug>/submissions/<id>`), i.e. evidence that a submission was actually
made — not just a file that exists.

The submission links were verified against the account (`p-sourou`, 740 solved problems): every
file that had none and whose problem is solved received the real submission URL, so the deck now
rests on **609 problems** with a genuine accepted submission in the repository.

| | problems |
|---|---|
| solved in the LeetCode account | 740 |
| of those, with a Java solution file in the repo | 609 |
| files with no accepted submission (attempted / stub only) | 45 |

Topics never exercised by a confirmed solve are excluded from the deck — topological sort,
Dijkstra / weighted shortest paths, interval merging/scheduling, knapsack, Floyd cycle detection,
RPN evaluation, k-way merge (monotonic deque is kept only because `CountSubarraysWithFixedBounds`
is confirmed).

## Sources

Every card cites one of:

* Esparza Alba & Ruiz Leal, *Algorithms for Competitive Programming* (2021) — data structures,
  sorting, divide & conquer, DP, graphs, number theory (cited with printed page numbers).
* Kulikov & Pevzner, *Learning Algorithms Through Programming and Puzzle Solving* — Big-O rules,
  greedy proofs, master theorem, binary search, DP (cited with page numbers).
* Dürr & Vie, *Competitive Programming in Python* (Cambridge University Press, 2021) — strings,
  KMP / Rabin–Karp, prefix sums, sliding window, graphs, intervals, trees (cited by section).
* Chatterjee, Guleria & Kiao, *Binary Tree Problems* (2021) — binary tree theory.
* Khamies, *How to Solve Algorithm Problems* (2023) — two pointers, BFS/DFS, backtracking,
  linked-list patterns.
* cp-algorithms.com — Disjoint Set Union, Minimum Stack/Queue, KMP, String Hashing, Segment Tree,
  Fenwick Tree, LCA binary lifting.
* Wikipedia — *All nearest smaller values* (the monotonic stack, with its linear algorithm).

The books are the ones available in `anki-creator/books`; the web pages are the canonical
references for the few structures the books do not cover.

## Re-importing

```bash
cd "D:/Nouveau dossier/anki-creator"
python anki_creator.py test
python anki_creator.py add ../path/to/leetcode_deck.json --create-decks
```

The JSON uses `"type": "Basique"` with `Recto`/`Verso` fields; decks are created automatically.
