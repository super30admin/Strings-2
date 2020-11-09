/*
TC: O(H) H - haystack length. To create a reference hash - O(N)
SC: O(N) array of length needle.

1. Create an array longest prefix suffix. 
2. Match the char in haystack with char in needle. 

*/

public class KMPPatternMatch {
        public int strStr(String haystack, String needle) {
            
            if(needle == null || needle.length() == 0) return 0;
            if(needle.length() > haystack.length()) return -1;

            int[] lps = lps(needle);
            int i = 0, j = 0, n = haystack.length(), m = needle.length();

            while(i < n){
                if(haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                }
                if(j == m) return i - j;
                if(i < n && haystack.charAt(i) != needle.charAt(j)){
                    if(j > 0){
                        j = lps[j - 1];
                    }else{
                        i++;
                    }
                }
            }
            return -1;
          
        }

        private int[] lps(String needle){
            int j = 0, i = 1;

            int[] lps = new int[needle.length()];
            lps[0] = 0;

            while(i < needle.length()){
                if(needle.charAt(i) == needle.charAt(j)){
                    lps[i] = ++j;
                    i++;
                }else{
                    if(j > 0){
                        j = lps[j - 1];
                    }else{
                        lps[i] = j;
                        i++;
                    }
                }
            }
            return lps;
        }
        public static void main(String[] args){
            KMPPatternMatch kmp = new KMPPatternMatch();
            System.out.println(kmp.strStr("helolla","ll"));
            
    
        }
}
