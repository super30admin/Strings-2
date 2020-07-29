//Time complexity=O(m *n) length of the strings
//Space complexity=O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n == 0)return 0;
        int i = 0;
        int j = 0;
        while(i< m - n + 1){
            if(haystack.charAt(i) == needle.charAt(j)){
                int temp = i;
                while(temp < m && j < n){
                    if(haystack.charAt(temp) == needle.charAt(j)){
                        j++;
                        temp++;
                    }else{
                        break;
                    }
                }
                if(j == n){
                    return i;
                }
            }
            j = 0;
            i++;
        }
        return -1;
    }
}