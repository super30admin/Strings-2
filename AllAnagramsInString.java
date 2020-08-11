// Time Complexity : O(n) --> where n is the length of the main string(s)
// Space Complexity : O(m) --> where m is the length of the pattern string(p)
// Did this code successfully run on Leetcode (438): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        // edge case
        if (p == null || p.length() == 0) return result;
        
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            // incoming character
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int count = map.get(in);
                count--;
                if (count == 0) match++;
                map.put(in, count);
            }
                
            // outgoing character
            if (i >= p.length()) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    if (count == 1) match--;
                    map.put(out, count);
                }
            }
            if (match == map.size()) result.add(i - p.length() + 1);
        }
        return result;
    }
} 