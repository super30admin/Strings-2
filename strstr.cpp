// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem is solved using bruteforce approach by finding the first occurance of needle charecter and
//traversing the needle string.

class Solution {
public:
    int strStr(string haystack, string needle) {

        int m = haystack.length();
        int n = needle.length();
        if(needle.length()==0)
            return 0;

        int i=0,j=0,k=0;

        while(i<m-n+1)
        {
            while(i<m-n+1 && haystack[i] != needle[0]) i++;
            k =i;
            while(k<m && j<n && haystack[k] == needle[j])
            {
                k++;
                j++;
            }
            if(j==n)
            {
                return i;
            }
            i++;
            j=0;
        }
        return -1;
    }
};
