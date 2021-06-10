/*Approach:
Using LPS and KMP algorithm.
KMP algorithm states that : Whenever we detect a mismatch (after some matches), we already know some of the characters in the text of the next window. We take advantage of this information to avoid matching the characters that we know will anyway match.

Example: 
txt = "AAAAABAAABA" 
pat = "AAAA"

We compared first 4 A's in the window (same as naive approach), while comparing string from index 1-5, we don't need to compare all A's because we already know that they match from our previous calculation.
To know how many chars to skip, we precalculate LPS array. 

We search for common longest suffixes and prefeixes in the substrings of the pattern.
For the pattern “A  A  A  C  A  A  A  A  A  C”
lps[] is        [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]
                 j  i
                 
For the pattern “A  B  C  D  E”, 
lps[] is        [0, 0, 0, 0, 0]

For the pattern “i  s  s  i  p”,  and input string "m i s s i s s i p p i"
lps[] is        [0, 0, 0, 1, 0]                     0 1 2 3 4 5 6 7 8 9 10

match is at index 4 and not index 1.

Space complexity: O(N: length of needle)
Time complexity: O(N) (To build LPS) + O(M), we only traverese through the haystack once. 
*/

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int hayStackLength = haystack.length();
        int needleLength = needle.length();
        if(needleLength==0)
            return 0;
        int i=0; int j=0; int[] lps = calculateLongestPrefixSuffix(needle);
        while(i<= hayStackLength-1)
        {
            //at i=1 and j=0, first char matches, so we increment both i and j till i=4 and j=4, where char 'i' and 'p' mismatch
            if(haystack.charAt(i)==needle.charAt(j))
            {
                j++;
                i++;
                if(j == needleLength)
                    return i-j;
            }
            /* When char 'i' and 'p' mismatch, we need to find out how many steps to go back in needle. That is, value of j. 
            lps[j-1] = 1. So we set j to index 1, that is, pointing to char 's', skipping index 0. 
            and now, all the chars match. i would be pointing to index 9, even though last char matched at index 8, 
            because of last i++ and j would be 5 (out of bounds) but equal to length of the needle.
            So we return, 'i-j' or 'i-needleLength', which gives us index 4, where the 1st match started
            */
            else if(haystack.charAt(i)!=needle.charAt(j) && j>0)
                j=lps[j-1];
            else if(haystack.charAt(i)!=needle.charAt(j) && j==0) //first, i is incrementing and set to char 'i' in haystack
                i++;
        }
        return -1;
    }

    private int[] calculateLongestPrefixSuffix(String substring)
    {
        int i = 1; int j = 0;
        int[] lps = new int[substring.length()];
        lps[0] = 0; //for the 1st char, longest prefix/suffix is 0
        
        while(i<= substring.length()-1)
        {
            if(substring.charAt(i) == substring.charAt(j))
            {
                j++;
                lps[i] = j;
                i++;
            }
            else if(substring.charAt(i) != substring.charAt(j) && j>0)
            {
                j = lps[j-1];
            }
            else
            {
                lps[i]=0;
                i++;
            }
        }
        return lps; 
    }
}
