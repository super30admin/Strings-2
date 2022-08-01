// Time Complexity : O(nk) where n is length of string haystack and k is length of string needle
// Space Complexity : O(1)

/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    var nlength = needle.length;
    var hlength = haystack.length;
    
    if(needle.length === 0) return 0;
    if(hlength < nlength) return -1;
    
    let hpointer = 0; 
    let npointer = 0;
    while(hpointer < hlength) {
        if(haystack.charAt(hpointer) !== needle.charAt(npointer)) {
            hpointer++;
        } else {
            let tempPointer = hpointer;
            while(haystack.charAt(tempPointer) === needle.charAt(npointer) && npointer < nlength) {
                tempPointer++;
                npointer++;
            }
            if(npointer === nlength) return hpointer;
            else {
                npointer = 0;
                hpointer++;
            }
        }
    }
    return -1;
};