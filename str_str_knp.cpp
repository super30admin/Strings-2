// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//1. Create an LPS array for the prefix and suffox calculation
//2. Iterate throught lps array and string to finish the string comparison in one pass
//3. Return -1 if we cannot find the pattern

class Solution {
public:
    int strStr(string haystack, string needle) {
        //edge
        if(haystack.length()==0 && needle.length()==0) return 0;
        if(haystack.length()==0 || haystack.length() < needle.length()) return -1;
        if(needle.length()==0) return 0;
        
        //logic
        vector<int> lps(needle.length(),0);
        lps_creation(needle, lps); //creating largest prefix-suffix for the pattern.
        int j=0;int i=0;
        //check the pattern wrt the string
        while(i<haystack.length()){
            //characters are equal
            if(haystack[i] == needle[j]) {
                j++; i++;
            }else if(haystack[i] != needle[j] && j>0) {
                j = lps[j-1];
            } else if(haystack[i] != needle[j] && j==0){
                j=0; i++;
            }
            if(j==needle.length()) return (i-j);
        }
        
        return -1;
    }
    
    void lps_creation(string needle,vector<int> & lps){
        int i=1, j=0;
        //3 cases to consider to get lps
        while(i<needle.length()){
            //1.Both characters equal : if condition
            if(needle[i]==needle[j]){
                j++; lps[i] = j; i++;
            }
            //2.Both characters not equal and iterate back to get the first match : while loop
            else if(needle[i]!=needle[j] && j>0){
                j = lps[j-1];
            }
            //3.Both characters not equal and back iteration is not possible : if condition
            else if (needle[i]!=needle[j] && j==0){
                lps[i] = 0;i++;
            }
            
        }
        
        return;
    }
};
