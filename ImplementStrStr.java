// Time Complexity: O(n + m) n is length of haystack, m is length of needle
// Space Complexit: O(m)

public class ImplementStrStr {
    public int strStr(String haystack, String needle)
    {
        if(needle == null || needle.length() == 0)
            return 0;
         int m = haystack.length(), n = needle.length();
        // make a LPS array of needle 
        int [] LPS = makeLPS(needle);
        
        int i = 0 , j = 0;

        // i is ptr in haystack and always moves fwd
        // j is ptr in needle and moves back and fwd based on where the mistmatch happens
        // The index where j needs to be moved incase mistmatch occurs is given by LPS array
        while(i < m)
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
                if(j == n) // we found all the needle values
                    return i - n; // i is pos in haystack and we have moved it ahead to len of needle
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j> 0)
            {
                j = LPS[j-1];
            }
            else
                i++;
        }
        
        return -1;
    }
    
    //make a LPS array using sliding window
    // always increase the size of window for prefix matching
    // if match found move ahead both i and j ahead i.e increase window blindly as all smaller window size have been matched already and updated in LPS
    // if ma 
    private int[] makeLPS(String needle)
    {
        int [] LPS = new int[needle.length()];
        LPS[0] = 0; // by basic concept starting char of len 1 cannot have prefix and suffix less than size 1
        int j = 0, i = 1;
        while(i < needle.length())
        {
            if(needle.charAt(i) == needle.charAt(j))
            {

                j++; // val of j tells the max prefix len of matching chars till i
                LPS[i] = j;// for str of len i, no of matching chars will be equal to j eg : aa i = 0 j = 1
                i++; // move i to next char
            }
            else if(needle.charAt(i) != needle.charAt(j) && j >0)
            {
                j = LPS[j-1]; // move j back to previous match i.e reduce window size
                
            }
            else if(needle.charAt(i) != needle.charAt(j) && j == 0) // do not try substring of len less than 1
            {
                LPS[i] = 0 ;
                i++;
            }
        }
        return LPS;
    }
}
