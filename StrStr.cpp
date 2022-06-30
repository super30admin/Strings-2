// Time Complexity : O(n + m) 
// Space Complexity : O(n)
//              where n : length of needle string
//                    m : length of haystack string
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* KMP Algorithm:-
 * Build LPS array using needle:- 
 *  Use two pointers i and j. i pointer iterates over the needle string.
 *  If char pointed by i and j is same then increement j pointer, update lps[i] with j value and increement i.
 *  If not same and j != 0 then simply reset j value to lps[i - 1].
 *      else set lps[i] = 0 and increment i.
 * 
 * Use this LPS array to find needle in haystack :-
 *  Use pointer i and j, i pointes to haystack and j pointes to needle.
 *  Compare the char pointed by i and j, if same then increment both pointers, and if j reaches end of string retun i - n.
 *  Else if char doesn't match and j > 0 then reset j to lps[j - 1].
 *  Else if char doesn't match and j == 0 then reset j to 0. 
 */

class Solution {
public:
    int strStr(string haystack, string needle) {
        if (needle.empty())
            return 0;
    
        int n = needle.size();
        int m = haystack.size();
        
        int lpsArray[n];
        lps(needle, lpsArray);
        
        int i = 0, j = 0;
        
        while (i < m)
        {
            if (haystack[i] == needle[j])
            {
                i++;
                j++;
                
                if (j == n)
                {
                    return i - n;
                }
            }
            else if (haystack[i] != needle[j] && j > 0)
            {
                j = lpsArray[j - 1];
            }
            else
            {
                i++;
            }
        }
        return -1;
    }
    
    void lps(string& needle, int lps[]) 
    {
        int n = needle.size();
        lps[0] = 0;
        int i = 1;
        int j = 0;
        
        while (i < n)
        {
            if (needle[i] == needle[j])
            {
                j++;
                lps[i] = j;
                i++;
            }
            else if (needle[i] != needle[j] && j > 0)
            {
                j = lps[j - 1];
            }
            else
            {
                lps[i] = 0;
                i++;
            }
        }
    }
};