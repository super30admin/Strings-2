// Time: O(l) l = length of s
// Space: O(1) hashmap of 26 characters

// Approach: Hashmap to track how many characters are matched.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        // unique elements whose count need to be 0
        int n = p.length();

        for (int i = 0; i < s.length(); i++) {
            // leaving element in map (pattern)
            if (i >= n && frequencyMap.containsKey(s.charAt(i - n))) {
                char leaving = s.charAt(i - n);
                frequencyMap.put(leaving, frequencyMap.get(leaving) + 1);
                // 0 -> 1 means one character in the pattern has left the window
                if (frequencyMap.get(leaving) == 1) {
                    match--;
                }
            }

            // entering element
            char c = s.charAt(i);
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) - 1);
                // one character fully matches
                System.out.println(frequencyMap.get(c));
                if (frequencyMap.get(c) == 0) {
                    match++;
                }
            }

            if (match == frequencyMap.size()) {
                res.add(i - n + 1);
            }
        }

        return res;
    }
}