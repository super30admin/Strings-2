//Time Complexity: O((m - n + 1) * n) worst case ≈ O(mn) (for each start in haystack you may compare up to n chars).
//Space Complexity: O(1) auxiliary.

//For each start index i from 0 to m - n, if haystack[i] == needle[0], compare forward with pointers k (haystack) and j (needle).
//If you match all n characters (j == n), return i; on a mismatch, reset j = 0 and try next i.
//If no start works, return -1.

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1;
        int i =0, j=0;
        while(i <= m-n){
            if(haystack.charAt(i) == needle.charAt(j)){
                int k = i;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;
                    if(j ==n){
                        return i;
                    }
                }
                j =0;

            }
            i++;
        }
        return -1;
    }
}