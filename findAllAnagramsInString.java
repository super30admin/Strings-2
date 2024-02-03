import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Creating an HashMap to store the freq of pattern and traversing the s and manipulating cnt of frequency in pattern to get
// correct no of matches

public class findAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        int st = 0;
        int end = 0;
        int match = 0;

        HashMap<Character, Integer> pattern = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pattern.put(p.charAt(i), pattern.getOrDefault(p.charAt(i), 0) + 1);
        }

        while (end < s.length()) {
            char in = s.charAt(end);
            if (pattern.containsKey(in)) {
                int cnt = pattern.get(in) - 1;
                if (cnt == 0)
                    match++;
                pattern.put(in, cnt);
            }

            if (end >= p.length()) {
                char out = s.charAt(st);
                if (pattern.containsKey(out)) {
                    int cnt = pattern.get(out) + 1;
                    if (cnt == 1)
                        match--;
                    pattern.put(out, cnt);
                }

                st++;
            }

            if (match == pattern.size())
                result.add(st);

            end++;

        }

        return result;

    }
}
