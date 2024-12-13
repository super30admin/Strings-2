// Approach : using two pointer approach.one pointer on haystack and other pointer on needle. As the pointer on
// source moves we check source character with character at needle if it matches then proceed else move the pointer on needle
// back to 0 and the pointer on haystack gets incremented by 1 (for this we need to  store of the starting initally so if mismatch happens we can go back there and increment by 1.
// Time : O(m*n)
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        int i = 0; // ptr1 in the haystack
        while(i<=m-n){
            int j =0;
            if(haystack.charAt(i)==needle.charAt(j)){
                int k = i; // using k we iterate and i remains as starting index
                while(haystack.charAt(k)==needle.charAt(j)){
                    j++;
                    k++;
                    if(j==n) return i; // starting index
                }
            } 
            i++;
        }

        return -1;
    }
}