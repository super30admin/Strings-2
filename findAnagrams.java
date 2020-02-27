// Time Complexity : O(n) where n is the length of the string s 
// Space Complexity : O(1) because size of hashmap is fixed to 26
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Sliding window approach

class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || s.length() < p.length()) return ans; 
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                map.put(in, map.get(in) - 1);
                if (map.get(in) == 0) match++;
            }
            if (i >= p.length()) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    map.put(out, map.get(out) + 1);
                    if (map.get(out) == 1) match--;
                }
            }
            if (match == map.size()) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }
}