// Implement strStr() (https://leetcode.com/problems/implement-strstr/)

// Time Complexity : O(mn)
// Space Complexity : O(m)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function (haystack, needle) {
    if (haystack === null || needle === null || needle.length === 0 || haystack.length === 0 || needle.length > haystack.length)
        return -1;

    // Keep track of all occurences of 1st character
    let occurences = [];
    for (let i = 0; i < haystack.length; i++) {
        if (haystack[i] === needle[0])
            occurences.push(i);
    }

    // Check for all occurences of 1st char and needle
    for (let i = 0; i < occurences.length; i++) {
        let index = occurences[i];
        let j = 0;
        for (; j < needle.length; j++) {
            if (haystack[index] !== needle[j]) {
                break;
            }
            index++;
        }
        if (j === needle.length)
            return occurences[i];
    }

    return -1;
};
