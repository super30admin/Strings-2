/**
Time Complexity : O(N*M)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int strStr(String haystack, String needle) 
    {
        
        int lengthHayStack = haystack.length();
        int needleLength = needle.length();
        
        if(needleLength > lengthHayStack)
            return -1;
        
        if(needleLength == lengthHayStack)
            return haystack.equals(needle) ? 0 : -1;
        
        
        for(int i= 0; i < lengthHayStack - needleLength + 1; i++)
        {
            int j = 0;
            for(j =0; j < needleLength; j++)
            {
                if(haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            
            if(j == needleLength)
                return i;
        }
        
        return -1;
        
    }
}