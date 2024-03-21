
//Brute force
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : maintain a window and keep checking if current window is equal to pattern.

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if( m < n ) return -1;

        int i = 0; // haystack start ptr;

        while(i <= m-n){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = 0; //needle ptr
                int k = i; //haystack ptr

                while(haystack.charAt(k) == needle.charAt(j)){
                    j++; k++;

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

//Rabin-Karp algorithm
// Time Complexity : O(m), m will always be bigger than n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Rabin-Karp algorithm for string pattern matching. keeping in account positions of the character for finding exact match.



import java.math.BigInteger;class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if( m < n ) return -1;

        //Find Hashcode of needle
        BigInteger hashN = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26); // 26 characters of alphabet

        for(int i = 0 ; i < n ; i++){
            char c = needle.charAt(i);
            hashN = hashN.multiply(k).add(BigInteger.valueOf(c - 'a' + 1)); // doing +1 because we don't want to have value of a 0 rather 1.
        }

        //Finding HashN in haystack
        BigInteger hashH = BigInteger.ZERO;
        for(int i = 0 ; i < m ; i++){

            

            //outoing character in window
            if(i >= n){
            // char out = haystack.charAt(i-n);
                //decrease contribution of out character
                hashH = hashH.mod(k.pow(n-1));
            }

            //incoming character in window
            char in = haystack.charAt(i);
            hashH = hashH.multiply(k).add(BigInteger.valueOf(in - 'a' + 1));

            //found the occurence
            if(hashN.equals(hashH)){
                return i-n+1;
            }
            
        }
        return -1;
    }
}