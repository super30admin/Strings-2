/**
TC - O(N), SC-O(1)
 */
class Solution {
    public int strStr(String haystack, String needle) {
       int hlength = haystack.length();
       int nlength = needle.length();
       int j=0;
       for(int i=0;i<hlength;i++){
        if(haystack.charAt(i)==needle.charAt(j)){
            j++;
        }
        else{
            i=i-j;
            j=0;
        }
        if(j==nlength){
            return i-j+1;
        }
       }
       return -1;
        
    }
}
