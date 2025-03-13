// Implement strStr() (https://leetcode.com/problems/implement-strstr/)

// Time Complexity : O(m+n)
// Space Complexity : O(1) - constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, Find hash of needle using hash1 = hash1 * k + (ch - 'a' + 1). Take a sliding window of needle size and then move single character and
 * find hash for the sliding window. If hash of needle equals sliding window hash return that index which is i-needleSize+1.
 */
// //import java.math.BigInteger;
// class Solution {
//     public int strStr(String haystack, String needle) {
//         long k = 26;
//         long hash1 = 0;
//         for(int i = 0; i < needle.length(); i++){
//             char ch = needle.charAt(i);
//             hash1 = hash1 * k + (ch - 'a' + 1);
//         }
//         int i = 0;
//         long hash2 = 0;
//         while(i<haystack.length()){
//             //out
//             if(i >= needle.length()){
//                 char out = haystack.charAt(i-needle.length());
//                 hash2 =  hash2 - (out-'a'+1) * (long)Math.pow(k, needle.length()-1);
//             }
            
//             //in
//             char in = haystack.charAt(i);
//             hash2 = (hash2 * k + (in - 'a' + 1));
//             if(hash1 == hash2) return (i-needle.length()+1);
//             i++;
//         }
//         return -1;
//     }
// }

import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        BigInteger k = BigInteger.valueOf(26);
        BigInteger hash1 = BigInteger.valueOf(0);
        for(int i = 0; i < needle.length(); i++){
            char ch = needle.charAt(i);
            hash1 = hash1.multiply(k).add(BigInteger.valueOf(ch - 'a' + 1));
        }
        int i = 0;
        BigInteger hash2 = BigInteger.valueOf(0);
        while(i<haystack.length()){
            //out
            if(i >= needle.length()){
                char out = haystack.charAt(i-needle.length());
                hash2 =  hash2.subtract(BigInteger.valueOf(out - 'a' + 1).multiply(k.pow(needle.length() - 1)));
            }
            
            //in
            char in = haystack.charAt(i);
            hash2 = hash2.multiply(k).add(BigInteger.valueOf(in - 'a' + 1));;
            if(hash1.equals(hash2)) return (i-needle.length()+1);
            i++;
        }
        return -1;
    }
}

