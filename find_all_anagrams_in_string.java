// Time Complexity : O(n + m) where n is length of s and m is length of p
// Space Complexity : O(k) where k is number of unique characters in p
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a Sliding Window with a HashMap storing character frequencies of the pattern string p.
// As the window moves, we decrease count for incoming characters and increase count for outgoing characters while tracking fully matched characters.
// Whenever the number of matched characters equals the number of unique characters in p, we record the starting index of the anagram.

class Solution {

    public List<Integer> findAnagrams(
        String s,
        String p
    ) {

        // edge case
        if (s.length() < p.length()) {

            return new ArrayList<>();
        }

        int m = p.length();

        List<Integer> result =
            new ArrayList<>();

        // frequency map of p
        HashMap<Character, Integer> map =
            new HashMap<>();

        // build frequency map
        for (int i = 0; i < m; i++) {

            char ch = p.charAt(i);

            map.put(
                ch,
                map.getOrDefault(ch, 0) + 1
            );
        }

        // number of fully matched characters
        int match = 0;

        for (int i = 0; i < s.length(); i++) {

            // incoming character
            char in = s.charAt(i);

            if (map.containsKey(in)) {

                int count = map.get(in);

                count--;

                // exact frequency matched
                if (count == 0) {

                    match++;
                }

                map.put(in, count);
            }

            // outgoing character
            if (i >= m) {

                char out =
                    s.charAt(i - m);

                if (map.containsKey(out)) {

                    int count =
                        map.get(out);

                    count++;

                    // character no longer fully matched
                    if (count == 1) {

                        match--;
                    }

                    map.put(out, count);
                }
            }

            // valid anagram found
            if (match == map.size()) {

                result.add(i - m + 1);
            }
        }

        return result;
    }
}