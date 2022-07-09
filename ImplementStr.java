// Time Complexity : O(m) ; length pf haystack
// Space Complexity : O(n) ; To create lps array of needle length
// Did this code successfully run on Leetcode : Yes

public class ImplementStr {

    public int strStr(String haystack, String needle) {

        if(needle.length() == 0) return 0;

        int m = haystack.length();
        int n = needle.length();

        int[] lps = lps(needle);
        int i=0; //source
        int j=0; //needle

        while(i < m){
            //case1
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == n) return i-n;
            }else{
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++; //magic of KMP Algo - not resetting i
                }
            }
        }
        return -1;
    }

    private int[] lps(String needle){
        int[] lps = new int[needle.length()];
        //always
        lps[0] = 0;

        int j=0, i=1;
        while(i < needle.length()){
            //char at incoming prefix window == chat at incoming suffic window
            if(needle.charAt(i) == needle.charAt(j)){
                j++; //expand prefic window
                lps[i] = j;
                i++;
            }else{
                if(j != 0){ //look for smaller window
                    j = lps[j-1];
                }else{
                    lps[i] = 0; // no common window
                    i++; //move on
                }
            }
        }

        return lps;
    }

}
