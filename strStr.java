class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null){
            return 0;
        }
        
        int h_length = haystack.length();
        int n_length = needle.length();
        
        if(h_length < n_length){
            return -1;
        }
        
        for(int i = 0; i<= h_length - n_length; i++){
            int j;
            for(j = 0; j < n_length; j++){
                if(haystack.charAt(i+j)!= needle.charAt(j)){
                    break;
                }              
            }
            if(j == n_length){
                    return i;
            }
        }
        return -1;
    }
}