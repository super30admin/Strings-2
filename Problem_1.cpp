/**
 * Time complexity:
 * O(m + n) where m is the size of the pattern string and n is the
 * size of the given string. O(m) for LPS function and O(n) for searching the pattern
 */

/**
 * Space complexity
 * O(n) where n is the size of the given string
 * O(n) for LPS function and O(1) for searching the pattern
 */


/**
 * Approach:
 * KMP Algorithm
 * The advantage of this algorithm is that it reduces the TC to O(n).
 * It is based on the intution that if we find a mismatch, it means that
 * not all of the characters were different, so we do not need to macth 
 * them again.
 * 
 * LPS function: This function gives us the count of characters we can skip
 * while matching with the main string. Taking pattern string as input, it returns
 * an array that contains length of longest prefixes that also act as suffixes.
 * 
 * strStr function: With main string and pattern string as input, it uses the 
 * LPS vector returned from the LPS function to skip all those comparisons
 * which have already been done provided there was no mismatch.
 * 
 * Based on these observations we can take care of the edge cases and build our solution.
 */

// The code ran perfectly on leetcode

class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.size()==0) return 0;
        int h = haystack.size();
        int n = needle.size();
        vector<int> lps = lpsFunc(needle);
        int i = 0;
        int j = 0;
        while(i < h){
             if(haystack[i] == needle[j]){
                 i++;
                 j++;
                 if(j == n) return i - n;
             } else if(j >0 && haystack[i] != needle[j]){
                 j = lps[j-1];
             } else if( j== 0 && haystack[i] != needle[j]){
                 i++;
             }
         }
        return -1;
        
    }
    
    private:
     vector<int> lpsFunc(string needle){
         vector<int> lps(needle.size());
         lps[0]= 0;
         int j = 0;
         int i = 1;
         while(i <needle.size()){
             if(needle[i]==needle[j]){
                 j++;
                 lps[i] = j;
                 i++;
             } else if(j >0 && needle[i] != needle[j]){
                 j = lps[j-1];
             } else if (j == 0 && needle[i] != needle[j]){
                 lps[i] = j;
                 i++;
             }
         }
         return lps;
         
     }
};