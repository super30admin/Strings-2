// Time Complexity : O(m) where n is length of haystack
// Space Complexity : O(n) where n is length of needle
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Could do simple way. But couldn't do the KMP algorithm.

class StrStr {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;

        int[]lps = lps(needle);

        while(i<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==n) return i-n;
            }
            else if(haystack.charAt(i)!=needle.charAt(j) && j>0){
                j = lps[j-1];

            }
            else if(haystack.charAt(i)!=needle.charAt(j) && j==0){
                i++;
            }
            //System.out.println(i);
        }

        return -1;
    }

    private int[] lps(String needle){
        int [] lps = new int[needle.length()];
        lps[0]=0;
        int j=0;
        int i=1;

        while(i<needle.length()){
            //case 1
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }
            else if(needle.charAt(i) != needle.charAt(j) && j>0){
                j = lps[j-1];
            }
            else if(needle.charAt(i) != needle.charAt(j) && j==0){
                lps[i]=0;
                i++;
            }
            //System.out.println(i);
        }

        return lps;
    }

    public static void main(String [] args){
        StrStr s = new StrStr();
        System.out.println(s.strStr("hello", "ll"));
    }
}