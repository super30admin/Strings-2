class Solution {
    public int strStr(String haystack, String needle) {
        int i=0, j=0, k=0;
        int m = haystack.length();
        int n = needle.length();
        while(i <= m-n){
            if(haystack.charAt(i) == needle.charAt(0)){
                k = i;
                j = 0;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++; j++;
                    if(j == n){
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
}

/**
 * 
 * The KMP algorithm is best for pattern finding problems in Strings. 
  One Brute Force, Is forming SubStrings and comparing every letter of substring with pattern and returning the starting index if it's true. 
 * 
 */