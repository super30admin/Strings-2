// Time Complexity : O(m+n)
// Space Complexity : O(n) -> LPS array 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*Approach:
1) we use the Longest prefix Suffix (LPS)
2) Longest prefix in string aabc is abc (all characters excluding the last character)
                                    a->aa->aab
3) Longest suffix in string aabc is abc (all characters excluding the start character)
                                    c-> bc-> abc

4) Thus initially we compute the LPS of the needle string and create a LPS array
5) Once we do so, we compare it with haystack with pointers j and i respectively
6) Once we see a mismatch, we bring back the j pointer to j-1 and start comparing again with i.
7) if there is a match we increment i and j till i reaches end of string haystack
8) In this fashion we can achieve a compleixty of O(m+n) from O(N^2)
*/

class ImplementStrStrUsingKMP {
    public int strStr(String haystack, String needle) {
        
       if(needle==null || needle.length()==0)
           return 0;
        
        int m = haystack.length();
        int n = needle.length();
        
        int i=0, j=0;
        
        int lps[] = lps(needle);
        
        while(i<m)
        {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
                
                if(j==n)
                {
                    return i-n;
                }
            }
            else if(haystack.charAt(i)!=needle.charAt(j) && j>0)
            {
                j=lps[j-1];
                
            }
            else
            {
                i++; // if there is mismatch but j==0
            }
        }
        
        return -1;
    }
    
    public int[] lps(String needle)
    {
        int[] lps = new int[needle.length()];
        
        int i=1; // suffix
        int j=0; // prefix
         
        while(i<needle.length()) // exploring till end of length
        {
            if(needle.charAt(i)==needle.charAt(j)) // when chars match eg: aa
            {
                j++;
                lps[i]=j;
                i++;
                
            }
            else if(needle.charAt(i)!=needle.charAt(j) && j>0) // when chars do not match
            {
                // take j back and again compare with i and j for matches
                j= lps[j-1];
                
                
            }
            else
                 if(needle.charAt(i)!=needle.charAt(j) && j==0)
                 {
                     // thus we didnt find a match 
                     // j==0 that means it has already come back and we cant increment as we havent found a match thus to not miss out other matches we just increment i
                     lps[i]=0;
                     i++;
                     
                 }
            
        }
        
        return lps;
    }
}