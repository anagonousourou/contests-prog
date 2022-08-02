function president(votes) {
    let counts = new Map()
    for (let vote of votes) {
        if (counts.has(vote)) {
            counts.set(vote, counts.get(vote) + 1)
        } else {
            counts.set(vote, 1);
        }
    }
    let president = null;
    let maxVotes = null;
    counts.forEach((v, k) => {
        if (maxVotes === null) {
            maxVotes = v;
            president = k
        }
        else if (v > maxVotes) {
            maxVotes = v;
            president = k;
        }
    })
    return president;
}


 let r= president([
    3,
    2,
    1,
    3,
    2,
    2,
    1,
    2,
    2
])

console.log(r)