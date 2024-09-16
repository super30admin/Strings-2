class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        int i = 0;
        int j = 0;
        
        int n = haystack.length();
        int m = needle.length();
        
        if(m == 0) return 0;
        
        int [] lps = lps(needle);
        
        while(i < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
            }
            if( j == m) return i - j;
        if(i < n && haystack.charAt(i) != needle.charAt(j)){
            if(j > 0){
                j = lps[j-1];
            }else{
                i++;
            }
        }
        }
        return -1;
        
    }
    private int [] lps(String needle){
        int j = 0; int i = 1;
        int [] lps = new int [needle.length()];
        lps[0] = 0;
        
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                lps[i] = ++j;
                i++;
            }else{
                if(j == 0){
                    lps[i] = j;
                    i++;
            }else{
                j = lps[j-1];
            }
        }
    }
    return lps;
}
}

//TC: o(m+n)
//SC: o(n)
