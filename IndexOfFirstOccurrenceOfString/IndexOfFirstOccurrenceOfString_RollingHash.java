/* Time Complexity : O(m) 
*   m - length of source string - haystack 
*   n - length of patern string - needle */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.math.BigInteger;

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1;
        BigInteger hash1 = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);
        //hash value - needle
        for(int i = 0; i < n; i++){
            char c = needle.charAt(i);
            //hash1 = hash1 * 26 + (c - 'a' + 1);
            hash1 = hash1.multiply(k).add(BigInteger.valueOf(c - 'a' + 1));
        }

        BigInteger hash2 = BigInteger.ZERO;
        //long pow = (long) Math.pow(26, n-1);
        for(int i = 0; i < m; i++){
            //removing a char - out
            if(i >= n){
                //char out = haystack.charAt(i-n);
                //hash2 = hash2 - (out - 'a' + 1) * pow;
                hash2 = hash2.mod(k.pow(n-1));
            }
            //adding a char - in
            char in = haystack.charAt(i);
            //hash2 = hash2 * 26 + (in - 'a' + 1);
            hash2 = hash2.multiply(k).add(BigInteger.valueOf(in - 'a' + 1));
            if(hash1.equals(hash2)){
                return i - n + 1;
            }
        }
        return -1;
    }
}