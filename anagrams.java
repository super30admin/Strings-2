// Time Complexity : O(M+N) //store p into map and iterate through s
// Space Complexity : O(N) //storing 'p' in the hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        //edge cases
        if(s == null || s.length() == 0 || p.length() > s.length()){
            return result;
        }
        
        Map<Character, Integer> pMap = new HashMap<>();
        
        //get pattern character counts
        for(char ch: p.toCharArray()){
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        
        int n = p.length();
        int match = 0;
        for(int i = 0; i <s.length(); i++){
            //in
            char in = s.charAt(i);
            if(pMap.containsKey(in)){
                
                //decrement the count
                pMap.put(in, pMap.get(in) -1);
                
                //all character count exists in the window
                if(pMap.get(in) == 0){
                    match++;
                }
            }
            //out
            if(i >= p.length()){
                char out = s.charAt(i - n);
                
                if(pMap.containsKey(out)){
                    pMap.put(out, pMap.get(out) + 1);
                    
                    //all characters not existing in window
                    if(pMap.get(out) == 1){
                        match--;
                    }
                }
            }
            
            if(match == pMap.size()){
                result.add(i - n + 1);
            }
        }
        
        return result;
    }
}