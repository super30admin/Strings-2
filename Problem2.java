// Time Complexity : O(m+n) where m and n are the lengths of source and anagram string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Create a map of anagram chars and its number of occurrence.
 * Iterate over the source string with keeping a rolling window of length n where n is the length of anagram string
 * When the incoming character is from the anagram string, reduce its frequency by 1 in the map. If the count hits 0, then it means that all occurrences of this character is in window and increase the match count by 1.
 * When the outgoing character is from the anagram string, increase its frequency by 1 in the map. If the count hits 1, then it means that the matching character fell out of the current window and reduce the match count by 1.
 *
 * On each incoming-outgoing pair, check if the match count is equals to entries in frequency map. If it was equal, add the starting index of the window in the response
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();

        List<Integer> result = new ArrayList<>();

        if (m < n)
            return result;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int match = 0;
        for (int i = 0; i < m; i++) {
            // incoming character
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int cnt = map.get(in);
                cnt--;
                if (cnt == 0) {
                    match++;
                }
                map.put(in, cnt);
            }

            // outgoing
            if (i >= n) {
                char out = s.charAt(i - n);
                if (map.containsKey(out)) {
                    int cnt = map.get(out);
                    cnt++;
                    if (cnt == 1) {
                        match--;
                    }
                    map.put(out, cnt);
                }
            }
            if (match == map.size())
                result.add(i - n + 1);
        }

        return result;
    }
}