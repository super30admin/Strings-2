// Time Complexity : O(n*m) n is haystack length, m is needle length
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    int strStr(string haystack, string needle) {
        
        int idx = -1;
        int i, j;
        int flag;
        
        // Zero length condition
        if(needle.size() == 0)
            return 0;
        
        // Needle size greater than haystack
        if(needle.size() > haystack.size())
            return -1;
        
        // Traverse through the haystack
        for(i = 0; i < haystack.size()-needle.size()+1; i++)
        {
            // Start matching process if first character matches
            if(haystack[i] == needle[0])
            {
                flag = true; j = 0;
                
                while(j < needle.size())
                {
                    // Compare if needle matching the haystack substring
                    if(needle[j] != haystack[i+j])
                    {
                        flag = false; break;
                    }          
                    j++;
                }
                
                // Return the first matching index
                if(flag == true)
                    return i;
            }
        }
        
        // No match condition
        return -1;
    }
};