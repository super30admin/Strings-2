//TC - O(n)
//SC - O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0){
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();
        char ch = needle.charAt(0);
        for(int i = 0; i < n; i++){
            if(haystack.charAt(i) == ch){
                if(i + needle.length() <= haystack.length() && haystack.substring(i, i + needle.length()).equals(needle)){
                    return i;
                }
            }

        }
  
            

        
       return -1; 
    }
}
