//TC - O(n);
//SC - O(1);
//LC -28

class Solution {
    public int strStr(String haystack, String needle) {
        
        if(haystack.length()==0 || haystack==null || needle==null||needle.length()==0) return 0;
        
        if(haystack.length()<needle.length()) return -1;

        
        int n = haystack.length();
        int m = needle.length();
        
        for(int i=0;i<n;i++){
            if(n-i<m) return -1;
            
            if(haystack.charAt(i)!=needle.charAt(0)) continue;
            
            if(haystack.substring(i,i+m).equals(needle)) return i;
        }
        
        return -1;
    }
}