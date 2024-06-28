// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(m<n) return -1;
        int i=0; // haystack
        int j =0; // needle
        int[] lps = lps(needle);
        while(i<m){
            if(needle.charAt(j)==haystack.charAt(i)){
                i++; j++;
                if(j==n){
                    return i-n;
                }
            }else if(needle.charAt(j)!=haystack.charAt(i)&& j>0){
                j = lps[j-1];
            }else if(needle.charAt(j)!=haystack.charAt(i)&& j==0){
                i++;
            }
        }
        return -1;
    }

        private int[] lps(String needle){
                int j = 0;
                int n = needle.length();
                int[] lps = new int[n];
                int i=1;
                while(i<n){
                    if(needle.charAt(j)==needle.charAt(i)){
                        j++;
                        lps[i] = j;
                        i++;
                    }else if(needle.charAt(j)!=needle.charAt(i)&& j>0){
                        j = lps[j-1];
                    }
                    else if(needle.charAt(j)!=needle.charAt(i)&&j==0){
                        lps[i] = 0;
                        i++;
                    }
                }
                return lps;
        }

}
