// O(m + n) time, O(1) space since only 26 chars

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>(); // char : freq map
        List<Integer> ans = new ArrayList<>();
        int n = p.length();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);

            if (map.containsKey(in)) {
                int freq = map.get(in);
                freq--;
                map.put(in, freq);

                if (freq == 0) {
                    match++;
                }
            }

            if (i >= n) {
                char out = s.charAt(i-n);

                if (map.containsKey(out)) {
                    int freq = map.get(out);
                    freq++;
                    map.put(out, freq);

                    if (freq == 1) {
                        match--;
                    }
                }
            }

            if (match == map.size()) {
                ans.add(i-n+1);
            }
        }
        
        return ans;
    }
}