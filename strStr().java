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

/*

KMP Algorithm 

Passed All Test Cases 

Big O 
 Time-> O(M + N), where M is length of haystack and N is length of needle
 space will be O(N), where N is length of the needle.

*/ 


//using KMP algorithm 
class Solution {
    public int strStr(String haystack, String needle) {
        //edge case 
        if(needle == null || needle.length() == 0) return 0 ; 
        
        int h = haystack.length() ; 
        int n = needle.length() ; 
        
        //this is the longest proper prefix sufix array for the string needle 
        int [] lpps = getLpps(needle, n) ;
        
        //pointers used to check matching of the both strings 
        int i = 0 , j = 0 ; 
        while ( i < h) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                
                //keep increasing the pointers until we found a char that does not match 
                i++ ; 
                j++ ; 
                
                //if we hit the end of the needle length, then return the starting index 
                if (j == n) 
                    return i - j ; 
                } else { //when the characters are not equal 
                    if(j == 0) { //if j is at 0, we simply increase i
                        i++ ; 
                    } else
                    { 
                        j = lpps[j - 1] ;  //we get the next character to be checked in needle with char in haystack from lpps array
                    }
                }
            }
        
        //nothing found, we return -1 
        return -1 ; 
        
        }
    
    //this computes the longest proper prefix sufix array for the string that needs to be searched 
    private int [] getLpps(String needle, int n) {
        
        //resultant array to be returned 
        int [] ans = new int[n] ; 
        
        //since the first character has no proper prefix/sufix 
        ans[0] = 0 ; 
        
        //pointers used in calculating lpps array
        int i = 1 ; 
        int j = 0 ; 
        
        //till the i pointer is less than the length of the string to be searched 
        while (i < n) {
            
            //when the char at i and j are same 
            if(needle.charAt(i) == needle.charAt(j)) {
                j++ ; 
                ans[i] = j ; 
                i++ ; 
            }else {
                //if j is 0, then put the ans[i] as 0 since no prefix/sufix found so len is 0
                if(j == 0) {
                    ans[i] = j ; 
                    i++ ; 
                } else {
                    //resetting the value of the j
                    j = ans[j - 1] ; 
                }
            }
        }
        
        //returning the resultant answer 
        return ans ;     
    }
    
}