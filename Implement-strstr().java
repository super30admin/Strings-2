/*
    Time Complexity : O(m*n)
    Space Complexity : O(1)
*/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int m=haystack.length();
        int n=needle.length();
        int i=0; int j=0;
        while(i<m){
            if(haystack.charAt(i) == needle.charAt(j)){
                int temp=i;
                while(temp < m && j<n){
                    if(haystack.charAt(temp) == needle.charAt(j)){
                        j++; temp++;   
                    } else {
                        break;
                    }
                }
                if(j==n){
                    return i;
                }
            }
            j=0;i++;
        }
        return -1;
    }
}

