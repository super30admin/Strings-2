// time complexity: O(N)
// space complexity: O(N)

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int start = 0;
        int end = 0;
        int len = 0;
        List<Integer> res = new ArrayList<Integer> ();
        HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
        
        for(char c: p.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(end = 0; end < s.length(); end++)
        {
            char c = s.charAt(end);
            if (map.containsKey(c))
            {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                {len++;}
            }
            if (len == map.size())
            {
                res.add(start);
                // len = 0;
            }
            if (end >= p.length() - 1)
            {
                char strt = s.charAt(start);
                if (map.containsKey(strt))
                {
                    if (map.get(strt) == 0)
                    {len--;}
                    map.put(strt, map.get(strt) + 1);
                }
                start++;
            }
        }
        return res;
        
    }
}