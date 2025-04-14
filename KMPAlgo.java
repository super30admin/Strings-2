// Time Complexity :O(m+n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class KMPAlgo {
        int[] lps;
        public int strStr(String haystack, String needle) {
            int n = needle.length();
            this.lps = new int[n];
            lpsCalc(needle);
            int i =0; int j=0;
            while(i < haystack.length()){
                if(haystack.charAt(i) == needle.charAt(j)){
                    i++; j++;
                    if(j==n) return i-j;
                } else if(haystack.charAt(i) != needle.charAt(j) && j>0){
                    j = lps[j-1];
                }else {
                    i++;
                }
            }
            return -1;
        }

        private void lpsCalc(String needle){
            int j =0; int i=1;
            int n= needle.length();

            while(i< n){
                if(needle.charAt(i)==needle.charAt(j)){
                    j++;
                    lps[i]=j;
                    i++;
                }else if(needle.charAt(i)!= needle.charAt(j) && j>0){
                    j= lps[j-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
}

