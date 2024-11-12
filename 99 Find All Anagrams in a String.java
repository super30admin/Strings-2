// Time Complexity : O(m+n)
// Space Complexity : O(k + m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    //aesha
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int m = s.length();
        int n = p.length();
        int match = 0;
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            // in
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int freq = map.get(in);
                freq--;
                map.put(in, freq);
                if (freq == 0)
                    match++;
            }

            // out
            if (i >= n) {
                char out = s.charAt(i - n);
                if (map.containsKey(out)) {
                    int freq = map.get(out);
                    freq++;
                    map.put(out, freq);
                    if (freq == 1)
                        match--;
                }
            }

            if (match == map.size()) {
                result.add(i - n + 1);
            }
        }
        return result;
    }
}