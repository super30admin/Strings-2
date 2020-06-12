//Time complexity : O(m+n) (Haystack + needle)
//Space Complexity: O(n) (KMP array for needle)
//Runs successfully on leetcode
//No problem

//Here we will be matching each character of haystack and needle
//If one of the character doesnot match, we will be using the KMP array we created and move to that index

import java.util.Arrays;


public class Strings_2_Problem_1_strStr {
    public int strStr(String haystack, String needle) {

        if(needle.length() == 0) return 0;

        int[] lps = new int[needle.length()];
        Arrays.fill(lps,0);
        lps[0] = 0;
        int slow = 0;
        int fast = 1;
        char[] need = needle.toCharArray();
        while(fast<lps.length)
        {
            if(need[slow] == need[fast])
            {
                lps[fast] = slow + 1;
                slow++;
                fast++;
            }
            else if(slow > 0 && need[slow] != need[fast])
            {
                slow = lps[slow - 1];
            }
            else if(slow == 0 && need[slow]!=need[fast])
            {
                lps[fast] = 0;
                fast++;
            }
        }

        int i = 0;
        int j = 0;

        while(i<haystack.length())
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }
            if(j == needle.length())
            {
                return i - needle.length();
            }
            else if(i < haystack.length() && j>0 && haystack.charAt(i) != needle.charAt(j))
            {
                j = lps[j-1];
            }
            else if(i < haystack.length() && j==0 && haystack.charAt(i) != needle.charAt(j))
            {
                i++;
            }

        }

        return -1;

    }
}
