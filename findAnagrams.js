/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
Intuiton:
I am  a sliding window of length p over s, while keeping a frequency map of characters needed from p.
As characters enter and leave the window, we update their counts and track how many characters have matched the required frequency (matchCount).
Whenever all character frequencies match (matchCount === map.size), the current window start index is an anagram.
T.C: O(m+n)
S.C: O(1)
 */
var findAnagrams = function (s, p) {
    // declare a map
    const map = new Map();
    const m = p.length;
    const n = s.length;
    // create the freq map for p
    for (let char of p) {
        const currCount = (map.get(char) || 0) + 1;
        map.set(char, currCount);
    }
    console.log(map);
    let matchCount = 0;
    const result = [];
    // iterate over s and see if there are any p's
    for (let i = 0; i < n; i++) {
        const incomingChar = s[i];
        // incoming
        if (map.has(incomingChar)) {
            let count = map.get(incomingChar);
            count--;
            // we found the required frequency of incoming char
            if (count === 0) matchCount++;
            map.set(incomingChar, count);
        }
        // outgoing
        if (i >= m) {
            const outGoingChar = s[i - m];
            if (map.has(outGoingChar)) {
                let count = map.get(outGoingChar);
                count++;
                if (count === 1) matchCount--;
                map.set(outGoingChar, count);
            }
        }
        if (matchCount === map.size) result.push(i - m + 1);
    }
    return result;
};