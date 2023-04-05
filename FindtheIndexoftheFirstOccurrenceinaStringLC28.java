class Solution {
    
    
    //Time Complexity: LPS-> O(n), n = length of needle
    //                  Matching strStr -> O(m) m = length of hayStack
    //                  Overall -> O(m)
    //Space Complexity: O(n) => because of the creating lps array
    
    public int strStr(String haystack, String needle) {
        
        if(needle.length() > haystack.length()) return -1;
        
        int[] lps = getlpsArr(needle);//getting the lps array
        
        int hIndex = 0;     //haystack pointer
        int nIndex = 0;     //needle pointer
        
        while(hIndex<haystack.length()){
            
            char hChar = haystack.charAt(hIndex);
            char nChar = needle.charAt(nIndex);
            
            //case 1
            if(hChar == nChar){
                hIndex++;
                nIndex++;
                
                if(nIndex == needle.length()) return hIndex - needle.length();
            
            }
            else{
                //case 2
                if(nIndex == 0){
                    hIndex++;
                }
                else{   //case 3
                    nIndex = lps[nIndex-1];
                }
            }
        }
        return -1;
    }
    
    
    
    private int[] getlpsArr(String needle){
        
        int[] lps = new int[needle.length()];
        
        int start = 0;
        int end = 1;
        
        while(end < needle.length()){
            
            char lChar = needle.charAt(start);
            char rChar = needle.charAt(end);
            
            //case 1
            if(lChar == rChar){         //if both chars are equal
                
                start++;                //start gives me the length of the longest prefix window
                lps[end] = start;       //store the longest length where prefix and suffix would be same
                end++;   
            }
            else{                       //if both chars are not equal
                
                //case 2
                if(start != 0){         //and start is not at zero, then check where we can get longest prefix and suffix considering the new end element
                    start = lps[start-1];
                }
                else{   //case 3
                    lps[start] = 0;     //if start is already at zero, means prefix and suffix would be not similar for any length
                    end++;
                }  
            }
        }
        return lps;
    }
    
    
    
    
    
    //Time Complexity: O(m*n), m = length of haystack, n = length of needle
    //Space Complexity: O(1)
    
//     public int strStr(String haystack, String needle) {
     
//         int m = haystack.length();
//         int n = needle.length();
        
//         if(n > m) return -1;
        
//         int hPointer = 0;
//         int nPointer = 0;
        
//         while(hPointer < m - n + 1){
            
//             if(haystack.charAt(hPointer) == needle.charAt(nPointer)){
                
//                 int k = hPointer;
                
//                 while(haystack.charAt(k) == needle.charAt(nPointer)){
                    
//                     k++;
//                     nPointer++;
                    
//                     if(nPointer == n){
//                         return hPointer;
//                     }
//                 }
//                 nPointer = 0;
//             }
//             hPointer++; 
//         }
//         return -1;
//     }
}
