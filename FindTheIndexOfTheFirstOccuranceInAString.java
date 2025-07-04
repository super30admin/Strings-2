//Time Complexity: O(m*n)
//Space Complexity: O(1)

//Solution: Using pointers 
class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int i = 0;
        int m = haystack.length();
        
        while(i <= m - n){
            if(haystack.charAt(i) == needle.charAt(0)){
                int k = i;
                int j=0;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;
                    if(j == n){
                        return i;
                    }
                } 
            }
            i++;
        }
        return -1;
    }
}

//Time Complexity: O(m+n)
//Space Complexity: O(1)
//Solution: Using Robin Karp Algorithm - Using this algo we are able to catch exact patterns, no anagrams or other pattern of string would be catched

import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        if(n > m)
            return -1;
        BigInteger hash = BigInteger.ZERO; //hash for pattern
        BigInteger k = BigInteger.valueOf(26);
        for(int i=0; i<n; i++){
            char c = needle.charAt(i);
            hash = hash.multiply(k).add(BigInteger.valueOf(c-'a'+1));
            //The expression (c - 'a' + 1) is a common way to convert a lowercase letter c into a number from 1 to 26, where:a->1, b->2 ..z->26
        }

        BigInteger hash2 = BigInteger.ZERO; //hash for source
        for(int i=0; i<m; i++){
            if(i>=n){
                //outgoing character, then reduce its contribution
                hash2 = hash2.mod(k.pow(n-1));
            }
            //incoming character,then add its contribution
            char b = haystack.charAt(i);
            hash2 = hash2.multiply(k).add(BigInteger.valueOf(b - 'a' +1));

            if(hash.equals(hash2))
                return i-n+1;
        }
        return -1;
    }
}