//brute force solution

/*

Passed All Test Cases 

Big O 
Time-> O(M * N), M is length of haystack and N is length of needle
Space-> O(1)
*/ 
class Solution {
    public int strStr(String haystack, String needle) {
      //edge case 
        if(needle == null || needle.length() == 0) return 0 ; 
        if(needle.length() > haystack.length()) return -1 ; 
        
        for (int i = 0 ; i < haystack.length() ; i++) {
            char h = haystack.charAt(i) ; 
            //if(i > needle.length() -  1) return -1 ; 
            
            char check = needle.charAt(0) ; 
            
            if(h == check) {
                int hIndex = i ;
                int nIndex = 0 ; 
                while (nIndex < needle.length() && hIndex < haystack.length()) {
                    
                    
                    if(haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                        hIndex++ ;
                        nIndex++ ; 
                    } else
                        break ; 
                }
                if(nIndex == needle.length())
                    return i ; 
            } 
        }
        return -1 ; 
    }
}