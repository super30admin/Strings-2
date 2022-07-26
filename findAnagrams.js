// Time Complexity : O(n) where n is length of string s
// Space Complexity : O(1) constant because at most only 26 chars

/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
 var findAnagrams = function(s, p) {
    let sArray = new Array(26).fill(0);
    let pArray = new Array(26).fill(0);
    let slength = s.length;
    let plength = p.length;
    let result = [];
    if(slength < plength) return result;
    for(let curr of p){
        pArray[curr.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }
    console.log(pArray);
    for(let i = 0; i < slength; i++) {
        sArray[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        if(i >= plength) {
            sArray[s.charCodeAt(i-plength) - 'a'.charCodeAt(0)]--;
        }
        if(JSON.stringify(sArray)==JSON.stringify(pArray)) {
            result.push(i-plength + 1);
        }
    }
    return result;
};