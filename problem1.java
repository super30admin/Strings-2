// 28 Implement strStr()
// solved on leetcode
// Time complexity : O(n)
// Space complexity : O(n)

class Solution {
    public int strStr(String haystack, String needle) {
        int ptr1 = 0;
        int ptr2 = 0;
        
        int m = haystack.length();
        int n = needle.length();
        
        int[] lps  = new int[n];
                
        if(needle.length() == 0){
            return 0;
        }
        LPS(lps, needle);

        
        while(ptr1 < m){
            
            if(haystack.charAt(ptr1) == needle.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }else{
                if(ptr2 - 1>=0){
                    ptr2 = lps[ptr2 - 1];
                }else{
                    ptr1 ++;
                } 
            }
            if(ptr2 == n){
                return ptr1 - ptr2;
            }
        }
        
        return -1;
    }
    
    private void LPS(int[] lps, String needle){
        lps[0] = 0;
        int slow = 0;
        int fast = 1;
        
        while(fast < needle.length()){
            
            if(needle.charAt(slow) != needle.charAt(fast)){
                if (slow != 0){
                    slow = lps[slow - 1];
                }else{
                    lps[fast] = 0;
                    fast ++;
                }

            }else{
                slow++;
                lps[fast] = slow;
                fast++;
            }
        }
    }
}