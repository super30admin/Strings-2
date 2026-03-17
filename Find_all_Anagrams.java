/*
Approach: (1) store the freq of characters of p in HashMap
(2) slide a window of size n over s. when a charcater enters a window decrease its frequency in the map, when it leaves map, increase its freq count.
(3) maintain a match counter that increases when a character's freq becomes
0 and decrease when it moves away from 0
(4) When match == map.size(), all character frequencies match the pattern, so the current window start index is an anagram.
 */

/*
Time: O(m), m is is length of s
Space: O(k), k = no. of unique characters in p.
 */


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();

        if (m < n) return result;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        for (int i = 0; i < m; i++) {
            char in = s.charAt(i);

            // Add incoming character
            if (map.containsKey(in)) {
                int freq = map.get(in);
                freq--;
                map.put(in, freq);
                if (freq == 0) match++;
            }

            // Remove outgoing character (when window exceeds size n)
            if (i >= n) {
                char out = s.charAt(i - n);
                if (map.containsKey(out)) {
                    int freq = map.get(out);
                    if (freq == 0) match--; // losing a full match
                    freq++;
                    map.put(out, freq);
                }
            }

            // If all chars match, record starting index
            if (match == map.size()) {
                result.add(i - n + 1);
            }
        }

        return result;
    }
}