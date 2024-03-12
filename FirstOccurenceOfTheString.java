// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        // return helperBruteForce(haystack,  needle);
        return helperRollingHash(haystack,  needle);
    }

    //TC: O(n + m)
    //SC: O(1)
    public int helperRollingHash(String haystack, String needle) {
         int result = -1;

        int n = needle.length();
        int m = haystack.length();

         if(n > m) {
            return result;
        }

        // double hashP = 0;
        BigInteger hashP = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);

        for(int i = 0; i < n; i++) {
            char in = needle.charAt(i);
            // hashP = hashP * 26 + (in - 'a' + 1);
            hashP = hashP.multiply(k).add(BigInteger.valueOf(in - 'a' + 1));
        }

        // double hashH = 0;
        // double oK = Math.pow(26, n-1);

        BigInteger hashH = BigInteger.ZERO;
        BigInteger ok = k.pow(n-1);
        for(int i = 0; i< m; i++) {
            //out

            if(i >= n) {
                char out = haystack.charAt(i-n);
                // hashH = hashH - oK * (out - 'a' + 1);
                hashH = hashH.subtract(ok.multiply(BigInteger.valueOf(out - 'a' + 1)));
            }

            //in
            char in = haystack.charAt(i);
            // hashH = hashH * 26 + (in - 'a' + 1);
            hashH = hashH.multiply(k).add(BigInteger.valueOf(in - 'a' + 1));
            // System.out.println("hashH: " + hashH + "    hashP: " + hashP);
            if(hashH.equals(hashP)) {
                return (i - n + 1);
            }
        }

         return result;
    }

    //TC: O(n * m)
    //SC: O(1)
    public int helperBruteForce(String haystack, String needle) {
        int result = -1;

        int n = needle.length();
        int m = haystack.length();
        if(n > m) {
            return result;
        }
        int i = 0; 

        while(i < m - n) {
            char h = haystack.charAt(i);
            char ne = needle.charAt(0);
            if(h == ne) {
                int j = 0;
                int k = i;
                while(haystack.charAt(k++) == needle.charAt(j++)) {
                    if(j == n) {
                        return i;
                    }
                }
            } 
            i++;
        }
        return result;
    }
}