//Time Complexity: O(n + m) where n is the length of string s and m is the length of string p.
//Space Complexity: O(1) since there are 26 chars only

import java.util.*;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0)
            return new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int m = p.length();
        int n = s.length();

        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int match = 0;
        for (int i = 0; i < n; i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int cnt = map.get(in);
                cnt--;
                map.put(in, cnt);
                if (cnt == 0)
                    match++;
            }

            // out
            if (i >= m) {
                char out = s.charAt(i - m); // i-m will give us the outgoing el
                if (map.containsKey(out)) {
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out, cnt);
                    if (cnt == 1)
                        match--;
                }
            }

            if (match == map.size()) {
                result.add(i - m + 1); // i-m+1 gives us the starting index of the anagram
            }
        }

        return result;
    }
}
