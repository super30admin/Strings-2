/*
Approach - Pattern Mathcing Algo - Robin Karp / Rolling Hash
Time Complexity - O(M+N)
Space Complexity - O(1)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
import java.math.BigInteger;
public class Implement_StrStr_LC_28 {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        BigInteger hashNeedle = BigInteger.ZERO; //hash for needle
        BigInteger k = BigInteger.valueOf(26); //because 26 chars

        for(int i=0 ; i < n; i++) { //calculating hash for needle
            char ch = needle.charAt(i); //hash * 26 + (incomingChar - 'a' +1)
            //hashP = hashP * 26 +(ch-'a' +1);
            hashNeedle = hashNeedle.multiply(k).add(BigInteger.valueOf(ch-'a' +1));
        }
        BigInteger hashHaystack = BigInteger.ZERO;
        for(int i = 0; i < m; i++) { //calculating hash for haystack
            if(i >= n) { //outgoing character
                hashHaystack = hashHaystack.mod(k.pow(n-1));
            }
            char ch = haystack.charAt(i); //incoming
            hashHaystack = hashHaystack.multiply(k).add(BigInteger.valueOf(ch-'a' +1));
            if(hashHaystack.equals(hashNeedle)) return i - n+1;
        }
        return -1;
    }
}

/*
Brute Force
Time Comeplexity - O(M*N)
Space Comeplexity - O(1)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
class Solution1 {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int i = 0;
        int n = haystack.length();
        while(i <= n-m) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
                int j = 0;
                while(haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                    if(j == m) {
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
}