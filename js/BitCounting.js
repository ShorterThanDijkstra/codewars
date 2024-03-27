// https://www.codewars.com/kata/526571aae218b8ee490006f4/solutions/javascript
const countBits = function (n) {
    let count = 0;
    let bigN = BigInt(n);
    while (bigN > 0) {
        if ((bigN & 1n) === 1n) {
            count += 1;
        }
        bigN = bigN >> 1n;
    }
    return count;
};

