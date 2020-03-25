// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Only learning Rabin Karp.

/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    if (haystack == null || needle == null) return -1;
    if (!haystack.length && !needle.length) return 0;
    if (!haystack.length) return -1;
    if (!needle.length) return 0;
    
    const prime = 5;
    const needleHash = firstHash(needle, 0, needle.length, prime);
    let rollingHash = firstHash(haystack, 0, needle.length, prime);
    
    for (let i = 0; i < haystack.length - (needle.length - 1); i++) {
        if (rollingHash == needleHash && isNeedle(haystack, i, needle)) return i;
        rollingHash = nextHash(haystack, i + 1, needle.length, prime, rollingHash);
    }
    
    return -1;
};

var nextHash = function(str, index, length, prime, prevHash) {
    if (index + length > str.length) return 0;
    let newHash = (prevHash - str.charCodeAt(index - 1)) / prime;
    newHash += str.charCodeAt(index + length - 1) * Math.pow(prime, length - 1);

    return newHash;
}

var firstHash = function(str, index, length, prime) {
    let primePower = 0;
    let firstHash = 0;
    while (primePower < length) {
        firstHash += str.charCodeAt(index++) * Math.pow(prime, primePower++);
    }

    return firstHash;
}

var isNeedle = function(haystack, index, needle) {
    let needleIndex = 0;
    for (let i = index; i < needle.length; i++) {
        if (haystack[i] != needle[needleIndex++]) return false;
    }

    return true;
}
