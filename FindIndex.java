class Solution {
    //Idea is to find index of the haystack sub string in the needle sub string 
    //by iterating over needle substring indexwise
    //Time Complexity: O(mn)
    //Space Complexity:O(1) 
    public int strStr(String haystack, String needle) {
    
     if(!haystack.contains(needle))
     {
      return -1;   
     }
     else
     {
        int needlelength = needle.length();
         int haystacklength = haystack.length();
        for(int i=0;i<haystacklength;i++)
        {
          if(haystack.substring(i,needlelength+i).equals(needle))
          {
              return i;
          }
        }
        return -1;
     }
    }
}