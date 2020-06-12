package s30Coding;
//Time Complexity :- O(m+n) where m is length of haystack string and n is length of needle string
//Space Complexity :- O(n) where n is length of needle string
//LeetCode

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
        int m = haystack.length(); int n  = needle.length();
        if(n == 0) return 0;
        int i =0; int j = 0;
        int[] lps = lps(needle, n);
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
            }
            if(j == n ) return i - n;
            else if( i < m && j >0 && haystack.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            }else if(i < m && j ==0 && haystack.charAt(i) != needle.charAt(j)){
                    i++;
                }
            
        }
        return -1;
    }
    private int[] lps(String needle, int n){
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1; int j =0;
        while(i < n){
            if(needle.charAt(i)== needle.charAt(j)){
                j++; lps[i] = j; i++;
            } else if(j> 0 && needle.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            } else if(j == 0 && needle.charAt(i) != needle.charAt(j)){
                lps[i] = 0; i++;
            }
        }
        return lps;
    }
}
