/**
 * Implement the solution in this function
 *
 * @param {number} n The number of item in the sequence.
 * @returns {string} The n-th number in the look-and-say seequence.
 */
function lookAndSay(n) {
    return _inner(n);
}

function lookAndSayPrivate(nstring){
    let str='';
    let prev=null;
    let characterCount = 0;
    
    for(let digit of nstring){
        if(prev === null){//first digit
            characterCount = 1;
            prev = digit;
        }
        else{
            if(digit === prev){//sameSequence
                characterCount+=1;
            }else{//newSequence
                str +=`${characterCount}${prev}`;
                prev = digit;
                characterCount=1;
            }
        }
    }
    str +=`${characterCount}${prev}`;

    return str;
}

function _inner(n){
    if(n===1){
        return '1';
    }
    else if(n==2){
        return '11';
    }
    else if(n==3){
        return '21';
    }
    else if(n==4){
        return '1211';
    }
    else if(n===5){
        return '111221';
    }else{
        return lookAndSayPrivate(_inner(n-1))
    }
}

console.log(lookAndSay(7));