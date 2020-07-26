// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem is solved using bruteforce approach by finding the first occurance of needle charecter and
//traversing the needle string.

//Bruteforce Approach

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


//KMP Algorithm
// Time Complexity : O(M+N) M-->Haystack length N-->needle length
// Space Complexity : O(N)

class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.length()==0)
            return 0;
        
        vector<int> lps(needle.length());
        
        int i=1,j=0;
        lps[0] = 0;
        while(i<needle.length()){
            if(needle[i] == needle[j]){
                j++;
                lps[i] = j;
                i++;
            }
            else if(j==0 && needle[i]!=needle[j]){
                lps[i]=0;i++;
            }
            else if(j>0 && needle[i]!=needle[j]){
                j = lps[j-1];
                
            }   
        }
        
        i=0,j=0;
        while(i<haystack.length()){
            if(haystack[i] == needle[j]){
                i++;
                j++;
            }
            if(j==needle.length()){
                return i-needle.length();
            }
            if(i<haystack.length()&& j>0 && haystack[i]!=needle[j]){
                j = lps[j-1];
            }
            else if(i<haystack.length() && j==0 && haystack[i]!=needle[j]){
                i++;
            }
            
        }
        return -1;
        
        
    }
};
