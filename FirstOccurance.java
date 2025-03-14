
// Time Complexity : O(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Robin Karp
 */

import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        if(n>m) return -1;
        BigInteger hash=BigInteger.ZERO;
        BigInteger k= BigInteger.valueOf(26);
        for(int i=0;i<n;i++){
            char c=needle.charAt(i);
            hash=hash.multiply(k).add(BigInteger.valueOf(c-'a'+1));
        }
        BigInteger hash2=BigInteger.ZERO;
        for(int i=0;i<m;i++){
            if(i>=n){
                //out
                hash2=hash2.mod(k.pow(n-1));
            }
            char in=haystack.charAt(i);
            hash2=hash2.multiply(k).add(BigInteger.valueOf(in-'a'+1));
            if(hash.equals(hash2)) return i-n+1;
        }
        return -1;
    }
}




