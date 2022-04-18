class Solution {
    public int strStr(String haystack, String needle) {
   
        int[] lps = getLpsArr(needle);
        int hIndex = 0 , nIndex=0;
        while(hIndex < haystack.length() && nIndex<needle.length())
        {
            char hChar = haystack.charAt(hIndex);
            char nChar = haystack.charAt(nIndex);
            
            if(hChar == nChar)
            {
                ++hIndex;
                ++nIndex;
            }
            else
            {
                if(nIndex == 0)
                {
                    ++hIndex;
                }
                else
                {
                    nIndex = lps[nIndex-1];
                }
            }
         
        }
        
           if(nIndex == needle.length()) //match
            {
                return hIndex-needle.length();
            }
       else
       {return -1;}
    }
    
    private int[] getLpsArr(String needle)
    {
        int[] lps = new int[needle.length()];
        
       // lps[0] = 0;
        
        int left = 0 , right =1;
        
        while(right < needle.length())
        {
            char lChar = needle.charAt(left);
            char rChar = needle.charAt(right);
            
            if(lChar  == rChar)
            {
                lps[right] = left + 1;
                ++left;
                ++right;
            }
            else
            {
                if (left == 0)
                {
                    ++right;
                }
                else
                {
                    left = lps[left -1];
                }
            }
        }
        
        return lps;
    }
}
