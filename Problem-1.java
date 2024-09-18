// Time Complexity : O(mn) brute force, O(n) optimal solution.
// Space Complexity : O(1) but possibly loss of precision because of integer value.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        long hashM = 0;
        long ml = (long) Math.pow(26, m - 1);
        for(int i = 0;i < m ; i ++){
            hashM = hashM * 26 + needle.charAt(i) - 'a' + 1;
        }

        long curHash = 0;
        for(int i =0; i < n; i ++){
            //out
            if(i >= m){
                char out = haystack.charAt(i - m);
                curHash = curHash % (ml * (out - 'a' + 1));
                // curHash = curHash % ml;
            }

            //in
            char in = haystack.charAt(i);
            curHash = curHash * 26 + in - 'a' + 1;

            if(curHash == hashM){
                return i - m + 1;
            }
       }
        return -1;
    }

    public int strStrBF(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                int k = i;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;
                    if(j == needle.length()){
                        return i;
                    }
                }
            }
            i++;
            j = 0;
        }
        return -1;
    }
}