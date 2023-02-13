// Time Complexity : O(M+N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindAllAnagramsString {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                map.put(in, map.get(in) - 1);
                if (map.get(in) == 0) {
                    match++;
                }
            }
            if (i - p.length() >= 0) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    map.put(out, map.get(out) + 1);
                    if (map.get(out) == 1) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i + 1 - p.length());
            }
        }
        return result;
    }
}