/**
 * Time Complexity - O(m+n)
 * Space Complexity - O(n)  // n = length of pattern string
 */

class Solution {
    public int strStr(String haystack, String needle) {

        if(haystack == null || needle== null || haystack.length() < needle.length())
            return -1;
        else if(needle.length() ==0)
            return 0;

        int[] lps = computeLPS(needle);

        int i =0, j =0;

        while(i < haystack.length()){

            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length()){
                    return i-j;
                }
            }else{

                if(j==0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }
        return -1;
    }

    private int[] computeLPS(String pattern){

        int[] LPS = new int[pattern.length()];

        LPS[0] = 0;

        int i=1, j=0;

        while(i < pattern.length()){

            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                LPS[i] = j;         // assign index of next character
                i++;
            }else{

                if(j==0){
                    LPS[i] =0;
                    i++;
                }else{
                    j = LPS[j-1]; // backtrack to previous matching prefix
                }
            }
        }
        return LPS;
    }
}