//Time comp: O(n)
//Space comp: O(1)
//approach: iterate through haystack and check if needle is substring of haystack
class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int n=haystack.length();
        int l=needle.length();
        while(i<=n-l){
            if(haystack.substring(i,i+l).equals(needle)){
                return i;
            }
            i++;
        }
        return -1;
    }
}
