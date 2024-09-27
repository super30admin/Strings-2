class Solution {
    public int strStr(String haystack, String needle) {
        // haystack - bigger string
        // needle - smaller string

        int hLength = haystack.length();
        int nLength = needle.length();
        int windowStart = 0;
        for(; windowStart < hLength - nLength + 1; windowStart++) {
          // for each window, check whether is there any character match or not  
          for(int i = 0; i < nLength; i++) {
                if(haystack.charAt(windowStart + i) != needle.charAt(i)){
                    break;
                }

                // i reached the end of needle string, we got a match
                if(i == nLength - 1) {
                    return windowStart;
                }
            }
        }

        return -1;
    }
}
