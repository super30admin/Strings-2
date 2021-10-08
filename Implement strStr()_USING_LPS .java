// Time Complexity :O(m) m = length of Pattern 
// Space Complexity : O(m) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// find the lps ( longest common prefix and suffix) for each element of pattern ( string to be find into source string)
// now put i at 0th index of source string and j at 0th index of pattern string
//  if char[i] == char[j] keep inc i and j until j == m(length of pattern) and return i-m;
// if char[i] != char[j and j >0 then move j backward such that j = lps[j-1]
// if char[i] !=char[j] and j ==0 then move ith index by 1;

// IMPORTANT how would we form the lps array of pattern string :--
 // 1. take i = 1 ; j =0 and lps[0] =0;
 // 2. now run loop for patterns length 
// we may face below three conditions 
 //if char[i] == char[j] then inc j (i.e j++) set lps[i] = j and inc i(i.ei++)
// if char[i] != char[j and j >0 then move j backward such that j = lps[j-1]
// if char[i] !=char[j] and j ==0 then  set lps[i] =0 and move ith index by 1;


class Solution {
    public int strStr(String haystack, String needle) {
      
        if(needle.equals(""))
            return 0;
       
        int i=0; int j =0;
     
        int[] lps =  lps( needle);
        while(i < haystack.length())
        {
            if(haystack.charAt(i)== needle.charAt(j))
            {
                i++; j++; 
                if(j==needle.length())
                {
                    return i - needle.length();
                }
            }
            else  if(haystack.charAt(i) != needle.charAt(j) && j >0)
            {
                j = lps[j-1];
            }
            else  if(haystack.charAt(i) != needle.charAt(j) && j == 0)
            {
                i++;
            }
            
        }
        
     return -1;
    }
    
    private int[] lps(String needle)
    {
        int[] lpsArr = new int[needle.length()];
        int m = needle.length();
        int j = 0; 
        int i =1;// note:  i should be set at 1;
        lpsArr[0] =0; // Note :lps at index 0 would be 0
        while(i<m)
        {
            if(needle.charAt(i) == needle.charAt(j) )
            {
                j++;
                lpsArr[i] =j;
                i++;
            }
            else if(needle.charAt(i) != needle.charAt(j) && j >0 )
            {
                j = lpsArr[j-1];
            }
            else  if(needle.charAt(i) != needle.charAt(j) && j ==0 )
            {
                lpsArr[i] =0;
                i++;
            }
        }
        
        return lpsArr;
    }
}