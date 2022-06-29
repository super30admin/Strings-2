//Time Complexity : O(mn)
//Space Complexity : O(mn)
class Solution {
    public int strStr(String haystack, String needle) {
        //source pointer
        int i = 0;
        //pattern pointer
        int j = 0;
        int m = haystack.length();
        int n = needle.length();
        while(i <= m-n){
            //if we have first match at i index with j 
            //new pointer k at i
            if(haystack.charAt(i) == needle.charAt(j)){
                int k = i;
                //if both chars are equal
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++;j++;
                    if(j == n) return i;
                }
                j=0;
            }
            i++;
        }
      return -1;
    }
}
    