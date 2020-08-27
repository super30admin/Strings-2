
class Solution {
	//Approach: Sliding Window 
	//1. Here, the lps array will be craeted which is the longest prefix suffix array using the needle with the help of lps function.
	//2. Now we will iterate stirng s with the i pointer and p with j pointer. 
	//3. if there is a match between the characters we will proceed moving both pointers, if no match - j will fall back according to the position we obtain from lps array.
	//4. Hence i will not be movin back and j will be moving front and back accordingly, trying to find the needle. 
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0 || needle.equals(haystack) )
        {
            return 0;
        }
        if(needle.length() > haystack.length())
            return -1;
        int[] lps = lps(needle);
        int i=0,j=0;
        int m = haystack.length(), n = needle.length();
        while( i < m)
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
                if(j == n) 
                {
                    return i - n;
                }
            }else if(i < m && j > 0 && haystack.charAt(i) != needle.charAt(j) )
            {
                j = lps[j-1];
            }else if(i<m && j == 0 && haystack.charAt(i) != needle.charAt(j))
            {
                i++;
            }
        }
        return -1;
    }
    private int[] lps(String needle)
    {
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        int j = 0; int i=1;
        while(i < needle.length())
        {
            //case 1
            if(needle.charAt(i) == needle.charAt(j))
            {
                j++;
                lps[i] = j;
                i++;
            }else if(needle.charAt(i) != needle.charAt(j) && j > 0)//case 2
            {
                j = lps[j-1];
            }else if(needle.charAt(i) != needle.charAt(j) && j == 0)//case 3
            {
                lps[i] = 0;
                i++;
            } 
        }
        
        return lps;
    }
}
//Time Complexity : O(n) asymptotically - iterating over haystack and over needle  total - O(m + n)  
//Space Complexity : O(n) for lps array creation  
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: Brute force
//Iterate over haystack and for any character that matches starting char of needle, check if it could be needle with temp and j pointer over haystack and needle.

class Solution1 {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0 || needle.equals(haystack) )
        {
            return 0;
        }
        if(needle.length() > haystack.length())
            return -1;
        
        int i=0, j=0; int n = needle.length();int m = haystack.length();    
        while(i < haystack.length())
        {
            if(needle.charAt(j) == haystack.charAt(i))
            {
                int temp = i;
                while(temp < m && j < n && needle.charAt(j) == haystack.charAt(temp))
                {
                    temp++;
                    j++;    
                }
                if(j == n)
                {
                    return i;
                }
                j=0;
            }
            i++;  
        }
        return -1;
    }
}
//Time Complexity : O(m * n) m - haystack length and n - needle length
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Ye
//Any problem you faced while coding this :