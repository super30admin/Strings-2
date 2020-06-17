class StrString {

    /**
     * Time Complexity : O(MN) where M is length of haystack and N is of needle
     * Space Complexity : O(1)
     * 
     * Approach:
     * Find the substring of needle's length in haystack and check if it's equal to needle.
     */
    public int strStr(String haystack, String needle) {
        
        int N = needle.length(), H = haystack.length();
        if(N == 0)
            return 0;
        
        for(int i=0; i<H-N+1; i++) {
            if(haystack.substring(i, i+N).equals(needle)) {
                return i;
            }
        }
        
        return -1;
        
//         int ret = haystack.indexOf(needle);
            
//         if(needle.equals(""))
//             return 0;
//         return ret;
    }
}