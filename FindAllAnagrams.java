
// Time Complexity : O(N+M) where N is the length of the input string s and M is the length of the pattern p.
// Space Complexity : O(1) as we are using constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
// We can use a sliding window approach to find all anagrams of p in s. 
// We maintain a frequency map of characters in p and keep track of how many characters have been matched in the current window. 
// As we expand the window, we update the frequency map and check if we have a valid anagram. If the window size exceeds the length of p, we shrink the window from the left and update the frequency map accordingly. 
// Finally, we return the list of starting indices of valid anagrams found in s.
// Sliding Window Approach

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Build frequency map
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        int required = map.size();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    match++;
                }
            }

            // Window size > p.length()
            if (right - left + 1 > p.length()) {

                char outChar = s.charAt(left);

                if (map.containsKey(outChar)) {

                    if (map.get(outChar) == 0) {
                        match--;
                    }

                    map.put(outChar, map.get(outChar) + 1);
                }

                left++;
            }

            // Valid anagram
            if (match == required) {
                result.add(left);
            }
        }

        return result;
    }
}