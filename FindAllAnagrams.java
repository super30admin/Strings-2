// Time Complexity : O(n)
// Space Complexity : O(1),
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i >= p.length()) {
                // out
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    map.put(out, map.get(out) + 1);
                    if (map.get(out) == 1) {
                        match--;
                    }
                }
            }
            // in
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    match++;
                }
            }
            if (match == map.size()) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}