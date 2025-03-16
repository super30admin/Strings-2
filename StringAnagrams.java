// Time Complexity : O(n) where n is the no of chatcters in the string.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<p.length(); i++)
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
        int pattern_len = p.length();
       
        int match = 0;
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            //in
            if(map.containsKey(c))
            {
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0)
                    match++;
            }
            
            //out
            if(i >= pattern_len)
            {
                char temp = s.charAt(i - pattern_len);
                if(map.containsKey(temp))
                {
                    map.put(temp, map.get(temp)+1);
                    if(map.get(temp) == 1)
                        match--;
                }
            }
            
            if(match == map.size())
                result.add(i-pattern_len+1);
        }
        return result;
    }
}