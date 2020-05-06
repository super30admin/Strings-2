// 28.
// time - O(n + m), n -> length of haystack and m -> length of needle
// space - O(m)
class Solution {
    public int strStr(String haystack, String needle) {
        //edge
        if(needle.length() == 0)
        {
            return 0;
        }
        int[] lps = LPSBuilder(needle); //lps[] of needle
        int i = 0; //i iteartes through haystack(original string)
        int j = 0; //j iterates through pattern
        while(i < haystack.length())
        {
            char chJ = needle.charAt(j);
            char chI = haystack.charAt(i);
            if(chI == chJ) //similar to brute force, increase both i and j if corresponding characters are same
            {
                i++;
                j++;
            }
            if(j == needle.length()) //return the index in haystack as pattern is a substring of haystack
            {
                return i - needle.length();
            }
            else if(chI != chJ && j > 0) //j goes backwards by lps[j - 1] steps
            {
                j = lps[j - 1];
            }
            else if(chI != chJ && j == 0) //i increments
            {
                i++;
            }
        }
        return -1; //pattern is not present in string
    }
    
    //time - O(m^2) - m is length of pattern
    //space - O(m) - for the lps[]
    private int[] LPSBuilder(String pattern) {
        //each index in lps[] has lps of substring of pattern from 0 to index
        int[] LPS = new int[pattern.length()];
        LPS[0] = 0; //if pattern is only single character, LPS = 0
        
        int j = 0;
        int i = 1;
        while(i < pattern.length())
        {
            char chJ = pattern.charAt(j); 
            char chI = pattern.charAt(i);
            if(chJ == chI)
            {
                j++;
                LPS[i] = j;
                i++;
            }
            //eg - aaac   lps[] so far = [0,1,2,-]
            //       ji - prefix = aaa suffix = aac
            //trying a shorter prefix and suffix combo aa, ac
            //                                          j   i still not equal
            //a,c
            //j i still not equal and j hits 0 in the next iteration
            //now lps[i] = lps[3] = 0 and i becomes 4 (case 3)
            else if(chJ != chI && j > 0)
            {
                j = LPS[j - 1];
            }
            else //chJ != chI && j == 0
            {
                LPS[i] = 0;
                i++;
            }
        }
        return LPS;
    }
}
