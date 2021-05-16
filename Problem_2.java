//Time Complexity:O(n*n)
//Space Complexity:O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        int n =haystack.length(), m=needle.length();
        for(int i=0;i<n-m+1;i++){
            if(needle.equals(haystack.substring(i,m+i))) return i;
        }
        return -1;
    }
}