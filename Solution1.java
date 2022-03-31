class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = getLPSArray(needle);
        int hIndex = 0;
        int nIndex = 0;
        
        while(hIndex < haystack.length() && nIndex < needle.length()){
            char hChar = haystack.charAt(hIndex);
            char nChar = needle.charAt(nIndex);
            
            if(hChar==nChar){
                ++hIndex;
                ++nIndex;
            }else{
                if(nIndex==0){
                    ++hIndex;
                }else{
                    nIndex = lps[nIndex-1];
                }
            }
        }
        
        if(nIndex==needle.length()){
            return hIndex - needle.length();
        }else{
            return -1;
        }
    }
    
    private int[] getLPSArray(String needle){
        int[] lps = new int[needle.length()];
        int left = 0;
        int right = 1;
        
        while(right < needle.length()){
            char lchar = needle.charAt(left);
            char rchar = needle.charAt(right);
            
            if(lchar==rchar){
                lps[right] = left + 1;
                ++left;
                ++right;
            }else{
                if(left==0){
                    ++right;
                }else{
                    left = lps[left-1];
                }
            }
        }
        
        return lps;
    }
}
