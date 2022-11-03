// Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

// Time Complexity : O(n)
// Space Complexity : O(p)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function (s, p) {
    if (s.length < p.length)
        return [];

    let map = new Map();
    for (let i = 0; i < p.length; i++) {
        let ch = p[i];
        if (!map.has(ch)) {
            map.set(ch, 1);
        } else {
            map.set(ch, map.get(ch) + 1);
        }
    }
    let match = 0;
    let ans = [];
    for (let i = 0; i < s.length; i++) {
        // Incoming to sliding window
        if (map.has(s[i])) {
            let count = map.get(s[i]) - 1;
            map.set(s[i], count);
            if (count === 0)
                match++;
        }
        if (i >= p.length) {
            // Outgoing o sliding window
            let index = i - p.length;
            if (map.has(s[index])) {
                let count = map.get(s[index]) + 1;
                map.set(s[index], count);
                if (count === 1)
                    match--;
            }
        }
        if (match === map.size) {
            ans.push(i - p.length + 1);
        }
    }
    return ans;
};
