// Time Complexity : O(s)
// Space Complexity : O(1) -> 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p.length() > s.length()) {
            return new ArrayList<>();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int match = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1); // creating the hashmap
        }
        for (int i = 0; i < s.length(); i++) {
            char incoming = s.charAt(i); // incoming character
            if (map.containsKey(incoming)) {
                int cnt = map.get(incoming); // current count, ie how many of this character is needed to complete the anagram in our current window
                cnt--;
                if (cnt == 0) { // we have the required number of characters for our anagram
                    match++;
                }
                map.put(incoming, cnt); 
            }
            if (i >= p.length()) {
                char outgoing = s.charAt(i - p.length());
                if (map.containsKey(outgoing)) {
                    int cnt = map.get(outgoing);
                    cnt++;
                    if (cnt == 1) {
                        match--;
                    }
                    map.put(outgoing, cnt);
                }
            }
            if (map.size() == match) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}