// Using KMP Algo 
// TC: O(mn)
// SC: O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int m = haystack.length();
        int n = needle.length();
        int j = 0;
        int[] lps = lps(needle);
        while(i < m){
            if(needle.charAt(j) == haystack.charAt(i)){
                i++;
                j++;
                if(j == n) return i-n;
            }    
            else if(j>0) {
                j = lps[j - 1];
            }    
            else if(j == 0) {
                i++;
            }    
        }
        return -1;
    }

    private int[] lps(String needle){
        int j = 0;
        int n = needle.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1;
        while(i < n){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }    
            else if(j>0) {
                j = lps[j - 1];
            }    
            else if(j == 0) {
                lps[i] = 0; 
                i++;
            } 
        }
        return lps;
    }
}



// Using robin karo algo
// TC: O(n+m)
// SC: O(1)


// We will use rolling hash function to calculate the hash value of the pattern. 
// Find all possible substrings of the given string and check if its hash value is equal to the patterns hash value.

import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if( n > m){
            return -1;
        }
        BigInteger hash = BigInteger.ZERO;
        BigInteger t = BigInteger.valueOf(26);
        for (int i = 0; i<n; i++){
            char c = needle.charAt(i);
            hash = hash.multiply(t).add(BigInteger.valueOf(c - 'a'+1));

        }
        BigInteger hash2 = BigInteger.ZERO;
        for ( int i =0; i<m; i++){
            if(i>=n){
                hash2=hash2.mod(t.pow(n-1));

            }
            char b = haystack.charAt(i);
            hash2 = hash2.multiply(t).add(BigInteger.valueOf(b - 'a' +1));
            if(hash.equals(hash2)) return i-n+1;


        }
        return -1;
    }

    
}