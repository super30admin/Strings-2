// Time Complexity : O(m+n)
// Space Complexity :O(n) hash value depends on n as how large it would be
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Was not aware of how to use biginteger. Had to lookup


// Your code here along with comments explaining your approach
import java.math.BigInteger;
//Rabin Karp Algorithm
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        //Null check
        if(n>m) return -1;
        BigInteger hash = BigInteger.ZERO;
        BigInteger t = BigInteger.valueOf(26);
        //Get the hash value of needle
        for(int i=0; i<n; i++){
            char c = needle.charAt(i);
            hash = hash.multiply(t).add(BigInteger.valueOf(c - 'a' + 1)) ;
        }

        
        BigInteger hash2 = BigInteger.ZERO;
        //Get the hash value of strings in haystack and compare it with needle hashvalue
        //According to Rabin Karp algorithm, we do not have to go through the whole substring for the hash value. Just process the incoming and outgoing character to get the hash value
        for(int i=0; i<m; i++){
            if(i>=n){
                hash2 = hash2.mod(t.pow(n-1));
            }
            char b = haystack.charAt(i);
            hash2 = hash2.multiply(t).add(BigInteger.valueOf(b - 'a' + 1)) ;
            if(hash.equals(hash2)) return i-n+1;
        }
        return -1;
    }
}