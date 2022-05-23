class implementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 || needle.length() == 0) return 0;
        
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        int[] lps = lps(needle);
        
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == n) return i - n;
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j - 1];
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j == 0){
                i++;
            }
        }
        
        return -1;
    }
    
    private int[] lps(String needle){
        int[] lps = new int[needle.length()];
        int i = 1;
        int j = 0;
        
        while(i < needle.length()){
            if(needle.charAt(j) == needle.charAt(i)){
                j++;
                lps[i] = j;
                i++;
            }
            else if(needle.charAt(j) != needle.charAt(i) && j > 0){
                j = lps[j - 1];
            }
            else if(needle.charAt(j) != needle.charAt(i) && j == 0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}

//time complexity O(m+n) where m and n are length of respective of 
//string of haystack and needle
//space complexity O(n) 