class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle == null ||  needle.length() == 0) return 0;
        
        int n = haystack.length();
        int m = needle.length();
        
        int[] LPS = calc_lps(needle);
        
        int i = 0;
        int j = 0;
        
        while (i < n){
            char char_i = haystack.charAt(i);
            char char_j = needle.charAt(j);
            
            if (char_i == char_j){
                i++;
                j++;
            }
            if (j == m){
                return i-j;
            }else if (char_i != char_j && j > 0){
                j = LPS[j-1];
            } else if (char_i != char_j && j == 0){
                i++;
            }
        }
       return -1; 
    }
    
    private int[] calc_lps(String p){
        int[] LPS = new int[p.length()];
        
        int j = 0;
        int i = 1;
        
        while (i < p.length()){
            
            char ch_i = p.charAt(i);
            char ch_j = p.charAt(j);
            
            if (ch_i == ch_j){
                j++;
                LPS[i] = j;
                i++;
            }else if (ch_i != ch_j && j>0){
                j = LPS[j-1];
            }else if (ch_i != ch_j && j==0){
                LPS[i] = 0; 
                i++;
            }
        }
        
        return LPS;
    }
}