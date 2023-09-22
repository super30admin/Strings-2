// TC = O(mn)
// SC = O(1)
// Here we are using slinding window approch.
class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        
        for(int wind = 0; wind<=n-m; wind++){
            for(int i=0; i<m; i++){
                if(needle.charAt(i) != haystack.charAt(wind+i)){
                    break;
                }
                if(i==m-1){
                    return wind;
                }
            }
        }
        return -1;
    }
}