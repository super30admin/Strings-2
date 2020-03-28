/*

Passed All Test Cases 

Big O 
Time-> O(N), N is lenght of string s 
Space-> O(1)

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //edge case
        if(s.length() < p.length()) return new ArrayList<>() ; 
        
        //frequency arrays for p and s 
        int [] cfp = new int[26] ; 
        int [] cfs = new int[26] ; 
        
        //adding frequency of chars in p 
        for (int i = 0 ; i < p.length() ; i++) {
            char add = p.charAt(i) ; 
            cfp[add - 'a']++ ; 
        }
        
        //using two pointers to get sliding window
        int start = 0 , end = 0 ; 
        
        //ArrayList to store answers 
        ArrayList<Integer> ans = new ArrayList<>() ; 
        
        while(end < s.length()) {
            char check = s.charAt(end) ;
            cfs[check - 'a']++ ; 
            
            //when length of window is larger
            if(end - start + 1 > p.length()) {
                char remove = s.charAt(start++) ; 
                cfs[remove - 'a']-- ;  
            }
            
            //when both arrays are equal
            if(Arrays.equals(cfs, cfp))
                ans.add(start) ; 
            
            end++ ; 
        }
        
        return ans ; 
    }
}