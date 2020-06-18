//Time Complexity: O(Length of Haystack)
//Space Complexity: O(Length of Needle)
class Solution {
    public int strStr(String haystack, String needle) {
        //lets make a lps array first
        if(needle.length() == 0)
            return 0;
        int ans = -1;
        int m = haystack.length();
        int n = needle.length();
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        int len = 0;
        int i=1;
        while(i < n){
            if(needle.charAt(i) == needle.charAt(len)){
                len++;
                lps[i] =len;
                i++;
            }
            else{
                if(len!=0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = len;
                    i++;
                }
            }
        }
        i = 0;
        int j = 0;
        while( i < m){
            if(needle.charAt(j) == haystack.charAt(i)){
                i++;
                j++;
            }
            if(j == n){
                ans = (i-j);
                j = lps[j - 1];
                return ans;
            }
            else if(i < m && needle.charAt(j) != haystack.charAt(i)){
                if(j != 0){
                    j = lps[j-1];
                }
                else
                    i = i + 1;
            }
        }
        return ans;
    }
}