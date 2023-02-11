// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        if(m<n) return -1;
        
        int i = 0; // i is ptr on source
        int j = 0; // j is ptr on needle
        int [] lps = lps(needle);
        
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
                if(j == n){
                    return i-n;
                }
            }else if (haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            }else if (haystack.charAt(i) != needle.charAt(j) && j == 0){
                i++;
            } 
        }
        
        return -1;
    }
    
    private int [] lps(String needle){
        int [] result = new int[needle.length()];
        int i = 1; int j = 0;
        result[0] = 0;
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                result[i] = j;
                i++;
            }else if (needle.charAt(i) != needle.charAt(j) && j > 0){
                j = result[j-1];
            }else if (needle.charAt(i) != needle.charAt(j) && j == 0 ){
                result[i] = 0;
                i++;   
            } 
        }
        return result;
    }
}





