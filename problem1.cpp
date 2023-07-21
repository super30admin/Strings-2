/*
Time complexity: O(m+n)
Space complexity: O(m)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    vector<int> calc(string pat, int m)
    {
        vector<int> lps(m,0);
        int i=1, j=0;
        while(i<m){
            if(pat[i]==pat[j]){
                j++;
                lps[i++]=j;
            }
            else{
                if(j) j=lps[j-1];
                else lps[i++]=0;
            }
        }
        return lps;
    }
    int strStr(string haystack, string needle) {
        int n=haystack.length(), m=needle.length();
        if(m==0) return 0;
        vector<int> lps = calc(needle, m);
        int i=0,j=0;
        while(i<n && j<m){
            if(haystack[i]==needle[j]){
                i++;
                j++;
            }
            if(j==m) return i-j;
            else if(i<n && j<m && haystack[i]!=needle[j]){
                if(j) j=lps[j-1];
                else i++;
            }
        }
        return -1;
    }
};