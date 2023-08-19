// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Using Rabin Karp Algorithm
// We will use rolling hash function to calculate the hash value of the pattern. 
// Find all possible substrings of the given string and check if its hash value is equal to the patterns hash value.
// To calculate the hash value of any character we multiply the previous hash with 26 and add the value of the character with it. Value of character is the position of that character amongst all the alphabets. Eg: a is 1, b is 2

class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        long phash=0l;
        //find the hashvalue of the pattern
        for(int i=0;i<n;i++)
        {
            char c=needle.charAt(i);
            phash= phash * 26+(c-'a'+1);
        }

        long chash=0l;
        long nl=(long) Math.pow(26,n);

        for(int i=0;i<m;i++)
        {
            char in=haystack.charAt(i);
            //incoming
            chash=chash* 26 + (in-'a'+1);


            //outgoing
            //if the length of the characters has exceeded the length of the pattern string, only then there will be an out going character
            if(i>=n) 
            {
                
                char out=haystack.charAt(i-n);
                chash=chash - (out-'a' + 1) * nl;
            }

            if(chash==phash)
            {
                return i-n+1;
            }
        }
        System.out.print(m);
        return -1;
    }
}





//Using pointers
class Solution {
    public int strStr(String haystack, String needle) {
        int i=0, j=0, k=0;
        int m=haystack.length();
        int n=needle.length();

        if(m<n) return -1;
        while(i<=m-n)
        {
            if(haystack.charAt(k)==needle.charAt(j))
            {
                k++;
                j++;
            }
            else
            {
                i++;
                k=i;
                j=0;
            }

            if(j==n)
            {
                return k-n;
            }
        }
        return -1;
    }
}