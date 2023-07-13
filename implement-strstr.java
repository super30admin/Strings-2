//using rolling hash method
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m) return -1;
       long k = 26l;
       long kn =(long)Math.pow(k,n);
       long needleHash = 0;
       //find the hash of needle
       for(int i=0; i<n; i++){
           char c = needle.charAt(i);
           needleHash = needleHash*k + (c-'a'+1);
       }
       long curHash = 0;
       //using sliding window to find the hash of haystack
       for(int i=0; i<m; i++){
           char in = haystack.charAt(i);
           curHash = curHash*k + (in-'a'+1);
           if(i>=n){
               char out = haystack.charAt(i-n);
               curHash = curHash -(out-'a'+1)*kn;
           }
           if(curHash == needleHash){
               return i-n+1;
           }
       }
       return -1;
    }
}