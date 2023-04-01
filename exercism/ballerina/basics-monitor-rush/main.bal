type Request record {|
   	// The key must be read-only.
    readonly int cubicle;
|};
function allocateCubicles(int[] requests) returns int[] {
    // Write your code here
    table<Request> key(cubicle) m = table [];
    foreach var i in requests {
        m.put({cubicle: i});
    }
    return m.keys().sort("ascending");
}
