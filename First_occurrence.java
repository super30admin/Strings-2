class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) {
            return -1;
        }
        int hayStackStart =0; 
        
        while(hayStackStart <= haystack.length() - needle.length()) {
        if(haystack.charAt(hayStackStart) == needle.charAt(0)) {
            int needleP=0;
        int end =hayStackStart;
               while(haystack.charAt(end) == needle.charAt(needleP)) {
                 needleP++;
                 end++;
                 if(needleP == needle.length()) {
                    return hayStackStart;
                 }
               }
               
               }
               hayStackStart++;
               }
     return -1;
    }
}