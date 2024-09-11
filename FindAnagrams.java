// Problem 438. Find All Anagrams in a String
// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }
        // Create a frequency map for the characters in string 'p'
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Sliding window over string 's'
        int match = 0; // Number of matched characters
        int windowSize = p.length();
        for (int i = 0; i < s.length(); i++) {
            // In
            char inChar = s.charAt(i);
            if (map.containsKey(inChar)) {
                int count = map.get(inChar);
                count--;
                map.put(inChar, count);
                if (count == 0) {
                    match++;
                }
            }
            // Out
            if (i >= windowSize) {
                char outChar = s.charAt(i - windowSize);
                if (map.containsKey(outChar)) {
                    int count = map.get(outChar);
                    count++;
                    map.put(outChar, count);
                    if (count == 1) {
                        match--;
                    }
                }
            }
            // Check if all characters match
            if (match == map.size()) {
                result.add(i - windowSize + 1);
            }
        }
        return result;
    }
}
