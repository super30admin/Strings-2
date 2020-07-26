/**
 * Brute Force: each character in haystack is checked against the starting char of needle , if matched then chk the entire needle string
 * Time: O((m-n)*n) m-length of haystack, n-length of needle
 * Space:O(1)
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0 )
            return 0;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            int ii = i, j = 0;
            while(j<needle.length() && haystack.charAt(ii) == needle.charAt(j))
            {
                ii++;
                j++;
            }
            if(j == needle.length())
                return ii-needle.length();
        }
        return -1;
    }
}

/**
 * Knuth Morris Pratt Algorithm: Generating a longest prefix suffix array for the needle string and then pattern matching such that the Time complexity is O(2m)
 * Time: O(m+n) m - length of haystack , n - length of needle string
 * Space: O(n)
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int i=0,j=0;
        if(needle == null || needle.length() == 0)return 0;
        int[] lps = lps(needle);
        while(i<haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == needle.length()) return i - needle.length();
            if(i < haystack.length() && j>0 && haystack.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            }
            if(i < haystack.length() && j==0 && haystack.charAt(i) != needle.charAt(j)){
                i++;
            }
        }
        return -1;
    }
    private int[] lps(String needle){
        int[] lps = new int[needle.length()];
        int i=1,j=0;
        while(i<needle.length()){
            //case1:
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else if(j>0 && needle.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            }else if(j==0 && needle.charAt(i) != needle.charAt(j)){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}
