let raindrops: int => string = (n) => {

    let result =  if(n mod 3 == 0) "Pling" else "";
    let result =  result ++ if(n mod 5 == 0) "Plang" else "";
    let result =  result ++ if(n mod 7 == 0) "Plong" else "";
    
    if(String.length(result) == 0) string_of_int(n) else result;
}