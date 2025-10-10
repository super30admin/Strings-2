//Find the Index of the First Occurrence in a String
// Time Complexity : O(n+m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes - not all test case
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We use Rabin Karp Rolling Hash Algorithm
//We compute the hash value of needle and using sliding window of length of needle length we compute the hash value of haystack
//When doing sliding window we check the incoming char and out char ans only calculate its hash value 
//If the hash value of needle matches any of the substring hash in haystack we return its first index
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        //calculate the hash for needle
        int pHash = 0;
        int base = 26;
        int kl = (int) Math.pow(base, n - 1);
        for(int i=0;i<n;i++) {
            char pChar = needle.charAt(i);
            pHash = pHash * base + (pChar - 'a' + 1);
        }

        //calculate the hash for haystack
        int sHash = 0;
        for(int i = 0; i < m; i++) {
            //process out char
            if(i >= n) {
                char out = haystack.charAt(i - n);
                //substract its hash contibution
                sHash = sHash - (kl * (out - 'a' + 1));
            }
            //process in char
            char in = haystack.charAt(i);
            //add its contribution
            sHash = sHash * base + in - 'a' + 1;

            if(sHash == pHash) {
                return i - n + 1;
            }
        }
        return -1;
        
    }
}
