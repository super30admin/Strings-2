/*
Problem - Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Approach - We compute a base-26 hash of the needle using BigInteger to prevent overflow.
We roll a BigInteger hash window over the haystack and subtract the outgoing character's contribution when needed.
If the rolling hash matches needle's hash, we return the starting index.
Time Complexity - O(m+n)
Space Complexity - O(1)
 */
import java.math.BigInteger;

public class FirstOccuranceOfAString {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n == 0) return 0;
        if(m<n) return -1;
        BigInteger base =  BigInteger.valueOf(26);
        BigInteger pHash = BigInteger.ZERO;
        BigInteger posFac = base.pow(n);
        // hash needle
        for(int i = 0; i < n; i++) {
            char ch = needle.charAt(i);
            BigInteger cur = BigInteger.valueOf(ch - 'a'+1);
            pHash = pHash.multiply(base).add(cur);
        }
        BigInteger cur = BigInteger.ZERO;
        // rolling hash over haystack
        for(int i = 0; i < m; i++) {
            char ch = haystack.charAt(i);
            BigInteger inVal = BigInteger.valueOf(ch - 'a'+1);
            cur = cur.multiply(base).add(inVal);
            if(i>=n){
                char out = haystack.charAt(i-n);
                BigInteger outVal = BigInteger.valueOf(out-'a'+1);
                cur = cur.subtract(posFac.multiply(outVal));
            }
            if(i>=n-1 && cur.equals(pHash)){
                if (haystack.substring(i - n + 1, i + 1).equals(needle)) { //substring check to avoid hash collisions
                    return i - n + 1;
                }
            }
        }
        return -1;
    }
}
