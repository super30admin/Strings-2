// Time complexity - O(mn)
// Space complexity - O(1)

// Brute force using pointers

class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int n = haystack.length();
        int m = needle.length();
        if(m==0) return 0;
        while(i < n){
            int j = 0;
            int temp = i;
            while(temp < n && j < m){
                if(haystack.charAt(temp) != needle.charAt(j)) break;
                j++;
                temp++;
            }
            if(j == m) return i;
            i++;
        }
        return -1;
    }
}
