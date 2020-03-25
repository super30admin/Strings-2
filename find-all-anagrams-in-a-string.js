// Time Complexity : O(N + M) where N and M are the lengths of S and P
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
    if (!s || !s.length) return [];
    
    const pCount = new Array(26).fill(0);
    const sCount = new Array(26).fill(0)
    const result = [];
    let windowLeftPointer = 0;
    for (const letter of [...p]) {
        let letterIndex = letter.charCodeAt(0) - 97;
        pCount[letterIndex]++;
    }
    for (let i = 0; i < s.length; i++) {
        let letterIndex = s[i].charCodeAt(0) - 97;
        sCount[letterIndex]++;
        if (i >= p.length) {
            let leftLetterIndex = s[windowLeftPointer++].charCodeAt(0) - 97;
            sCount[leftLetterIndex]--;
        }
        if (isEqualArrays(sCount, pCount)) result.push(i - p.length + 1);
    }
    
    return result;
};

var isEqualArrays = (arr1, arr2) => {
    for (let i = 0; i < arr1.length; i++) {
        if (arr1[i] != arr2[i]) return false;
    }
    return true;
}
