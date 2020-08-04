//Time Complexity : O(N)
//Space Complexity : O(1)
//Did it run on leetcode  : yes
class Solution {
    public int strStr(String haystack, String needle) {
        
        int n = needle.length();
        if(needle == null || n == 0)
            return 0;
        
        
        int[] lps = getLPS(needle);
        int[] lps = getLPS(needle);
        int i = 0; 
        int j = 0 ;
        while( i < haystack.length()){
            if(haystack.charAt(i) ==  needle.charAt(j))
            {
                i++;
                j++;
            }
            if(j == needle.length())
                return i - n;
            
             if(i < haystack.length() && (j > 0 && haystack.charAt(i) != needle.charAt(j)))
             {
                 
                 j = lps[j-1];     
              }
              
              if( i < haystack.length() && (j == 0 &&  haystack.charAt(i) != needle.charAt(j))) 
               {
                   i++;
               }   
        }
        return -1;
     
    }
 
    private int[] getLPS(String needle){
        
        int slow = 0;
        int fast = 1 ;
        int[] lps = new int[needle.length()];
      //  lps[0] = 0;
        while(fast < needle.length()){
            if(needle.charAt(slow) ==  needle.charAt(fast)){
                slow++;
                lps[fast] = slow;
                fast++;
                
            }
            else if(slow > 0 && needle.charAt(slow) != needle.charAt(fast)){
                
                slow = lps[slow-1];
                
            }
            else if(slow == 0 && needle.charAt(slow) != needle.charAt(fast)){
                
                fast++;
            }   
        }
        return lps;
        
        
    }
    
    
}
    
    
    
    
    
    


