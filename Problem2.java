// Time Complexity : O(n) where n is length of s
// Space Complexity : O(1) as we can have at worst for p string => 26 letters, 26 is constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        Map<Character, Integer> pMap = new HashMap<>();
        
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0)+1);
        }
        
        int window = 0;
        int match = 0;
        
        while (window < s.length()) {
            
            // incoming
            char inChar = s.charAt(window);
            
            if (pMap.containsKey(inChar)) {
                int freq = pMap.get(inChar);
                
                freq--;
                
                pMap.put(inChar, freq);
                
                if (freq == 0) {
                    match++;
                }
            }
            
            // outgoing
            if (window >= p.length()) {
                
                char outChar = s.charAt(window - p.length());
                
                if (pMap.containsKey(outChar)) {
                    
                    int freq = pMap.get(outChar);
                    
                    freq++;
                    
                    pMap.put(outChar, freq);
                    
                    if (freq == 1) {
                        match--;
                    }
                }
            }
            
            if (match == pMap.size()) {
                ans.add(window - p.length() + 1);
            }
            
            window++;
        }
        return ans;
    }
}
