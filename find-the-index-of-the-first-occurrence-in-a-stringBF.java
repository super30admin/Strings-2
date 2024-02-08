class Solution {
   //TC: O(m*n)
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int  i = 0;
        while(i <= m-n){
            if(haystack.charAt(i) == needle.charAt(0)){
                int k = i;
                int j = 0;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;
                    if(j == n) return i;
                }
            }
            i++;
        }
        return -1; 
    }
}