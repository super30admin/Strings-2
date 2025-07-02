// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach: Robin Karp / rolling hash algorithm. Compute custom hash for needle string by mapping characters from a-z to 1-27
// and choosing a base = 26. Hash is computed similar to place value of numbers with chosen base. Now iterate through string haystack
// compute hash for window of size = needle. If hash matches needle hash return starting index, else update hash by removing contributon
// from char leaving the window and adding the incoming character 

import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        BigInteger hash = BigInteger.ZERO;
        int m = needle.length(), n = haystack.length();
        int place = 26;
        for(int i=0;i<m;i++){
            char curr = needle.charAt(i);
            hash = hash.multiply(BigInteger.valueOf(place));
            hash = hash.add(BigInteger.valueOf(curr - 'a' +1));
        }
        BigInteger hashs = BigInteger.ZERO;
        for(int i=0;i<n;i++){
            char curr = haystack.charAt(i);
            if(i>=m){
                char prev = haystack.charAt(i-m);
                BigInteger prevMap = new BigInteger((prev-'a'+1)+"");
                hashs = hashs.subtract(prevMap.multiply(BigInteger.valueOf(place).pow(m-1)));
            }
            hashs = hashs.multiply(BigInteger.valueOf(place));
            hashs = hashs.add(BigInteger.valueOf(curr - 'a' +1));
            if(hashs.equals(hash)){
                return i-m+1;
            }
        }
        return -1;
    }
}