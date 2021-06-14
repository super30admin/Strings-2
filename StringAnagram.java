// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      List<Integer> result = new ArrayList<>();
      if (s == null || s.length() == 0)
        return result;
  
      HashMap<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < p.length(); i++) {
        char c = p.charAt(i);
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
  
      int i = 0, match = 0;
      while (i < s.length()) {
        char c = s.charAt(i);
        // incoming
        if (map.containsKey(c)) {
          int count = map.get(c);
          count -= 1;
          if (count == 0)
            match++;
          map.put(c, count);
        }
        // outgoing
        if (i >= p.length()) {
          char outgoing = s.charAt(i - p.length());
          if (map.containsKey(outgoing)) {
            int count = map.get(outgoing);
            count++;
            if (count > 0)
              match--;
            map.put(outgoing, count);
          }
  
        }
        // matched
        if (match == map.size()) {
          result.add(i - p.length() + 1);
        }
        i++;
      }
      return result;
    }
  } 