// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Rabin karp hashing to assign a unique value to strings
// Use sliding window to find hash value
// check if it matches required string hash

import java.math.BigInteger;

class Solution {
    public int strStr(String haystack, String needle) {

        int hl = haystack.length();
        int nl = needle.length();

        BigInteger k = BigInteger.valueOf(26); //for 26 chars
        BigInteger hash = BigInteger.ZERO; 
        BigInteger match = BigInteger.ZERO;

        if(hl < nl) return -1;

        // Rolling hash - assigns unique hash value to a string
        for(int i=0;i<nl;i++){
            match = match.multiply(k).add(BigInteger.valueOf(needle.charAt(i)-'a'+1));
        }

        // System.out.println(match.toString());

        // in and out char sliding window
        for(int i =0;i<hl;i++){

            //out char - correcting hash
            // 123 -> 23
            if(i>=nl){
                char out = haystack.charAt(i-nl);
                hash = hash.subtract(
                    BigInteger.valueOf(out-'a'+1).multiply(k.pow(nl-1))
                );
            }
            
            //in char
            char in = haystack.charAt(i);
            hash = hash.multiply(k).add(BigInteger.valueOf(in-'a'+1));

            // System.out.println(hash.toString());

            //return index
            if(hash.equals(match)) return i-nl+1;
        }

        return -1;
    }
}