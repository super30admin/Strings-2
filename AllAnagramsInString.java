import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 438. Find All Anagrams in a String
 * Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class AllAnagramsInString {
    /**
     * Sliding window solution where we maintain a hashmap of char frequency map of p string. Now slide the window of
     * m chars which is length of p and process incoming and outgoing characters by updating the map keys for only those
     * characters which are present in the match. For incoming reduce and for outgoing increase the char frequency
     * if anytime frequency becomes 0 marks a character match found by incrementing
     * match counter; and whenever char frequency in map becomes 1 or -1 reduce match count. For all sliding windows where
     * match becomes the size of the freq map (basically sliding window has all the chars from p string as anagram) we
     * register the start of that window in our result list
     *
     * TC: O(m + n)
     * SC: O(1) max 26 lower case characters in map
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int m = p.length();

        for (char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        //incoming char
        for (int i = 0; i < n; i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int count = map.get(in);
                count--;
                map.put(in, count);

                if (count == 0) { //from 1 to 1
                    match++;
                }
                if (count == -1) { //from 0 to -1
                    match--;
                }
            }

            //outgoing char
            if (i >= m) {
                char out = s.charAt(i - m);
                if (map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    map.put(out, count);

                    if (count == 1) { //from 0 to 1
                        match--;
                    }
                    if (count == 0) { //from -1 to 1
                        match++;
                    }
                }
            }

            //after processing both incoming and outgoing chars
            if (match == map.size()) {
                result.add(i - m + 1);
            }
        }

        return result;
    }
}
