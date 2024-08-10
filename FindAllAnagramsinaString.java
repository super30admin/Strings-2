// Time Complexity: O(m + n)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int count = map.get(in) - 1;
                map.put(in, count);
                if (count == 0)
                    match++;
            }

            if (i - p.length() >= 0) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    int count = map.get(out) + 1;
                    map.put(out, count);
                    if (count == 1)
                        match--;
                }
            }

            if (match == map.size())
                result.add(i - p.length() + 1);
        }

        return result;

    }
}