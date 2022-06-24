// Space - O(1)
//ctime - O(m+n)
class Solution {
    public int strStr(String haystack, String needle) {
        
        int n = haystack.length();
        int m = needle.length();
        int i =0;
        int j =0;
        while(i<= n-m){
            if(haystack.charAt(i) == needle.charAt(j)){
                int k =i;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;
                    if(j ==m) return i;
                }
                   j=0;
            }
            i++;
         
        }
        return -1;
    }
}