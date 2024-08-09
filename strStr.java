// TC: O(m-n), sc:O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        while(i<=m-n){
            if(haystack.charAt(i)==needle.charAt(0)){
                int k =i;
                int j=0;
                while(haystack.charAt(k)==needle.charAt(j)){
                    j++;
                    k++; 
                    if(j==n){
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
}