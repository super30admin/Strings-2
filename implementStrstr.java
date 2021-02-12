/* time complexity O(n^2)
space complexity O(1)
approach: iterate over the haystack and find characters of needle in it if a mismatch occurs reset it to next element*/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)return 0;
        int n=needle.length(); int h=haystack.length();
        int i=0;
        while(i<h){
            if(needle.charAt(0)==haystack.charAt(i)){
                int temp=i;
                int j=0;
                while(temp<h && needle.charAt(j)==haystack.charAt(temp)){
                    temp++;j++;
                    if(j==n) return i;
                }
            }
            i++;
        }
        return -1;
    }
}