// Time Complexity: O(m + n)
// Space Complexity: O(1)
// Robin Kar Rolling Algorithm

import java.math.BigInteger;

class Solution {
    public int strStr(String haystack, String needle) {
        BigInteger hash = BigInteger.valueOf(0);
        BigInteger needlehash = BigInteger.valueOf(0);
        int n = needle.length();
        BigInteger t = BigInteger.valueOf(26);

        for(int i=0; i< n; i++){
            needlehash = needlehash.multiply(t).add(BigInteger.valueOf (needle.charAt(i) - 'a' + 1));
        }

        for(int i=0; i< haystack.length(); i++){

            if(i >= n){
                char c = haystack.charAt(i-n);
                hash = hash.subtract(BigInteger.valueOf((c - 'a' + 1)).multiply(t.pow(n-1)));
            }
            hash = hash.multiply(t).add(BigInteger.valueOf ((haystack.charAt(i) - 'a' + 1)));
            if(hash.equals(needlehash)) return i - n + 1;

        }
        return -1;
    }
}