//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
//Logic- Brute force algo comparing each and every character in needle with haystack by iterating over each of the elements.
class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length() == 0){
            
            return 0;
        }
        
        int hay = 0;
        int need = 0;
        int result = -1;
        while(hay < haystack.length() &&  haystack.length()- hay + 1 >= needle.length()){
            
            char c1 = haystack.charAt(hay);
            char c2 = needle.charAt(need);
            
            if(c1 == c2){
                int temp = hay;
                while(need < needle.length() && hay < haystack.length() && haystack.charAt(hay) == needle.charAt(need)){
                    
                    hay ++;
                    need ++;
                }
                if(need == needle.length()) {
                   // System.out.println("hitting");
                    result = temp;
                    return result;
                }
                else{
                    
                    hay = temp;
                    need = 0;
                }
            }
            
             hay ++;
        }
        return result;
    }
}