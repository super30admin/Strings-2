// Time Complexity : O(n+m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sl = s.length(); int pl = p.length();
        if (sl == 0 || pl > sl) return result;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < pl; i++) {
            char pChar = p.charAt(i);
            map.put(pChar, map.getOrDefault(pChar, 0) + 1);
        }

        int match = 0;
        for (int i = 0; i < sl; i++) {
            // incoming char
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                map.put(in, map.get(in) - 1);
                if (map.get(in) == 0) {
                    match++;
                }
            }

            // outgoing char
            if (i >= pl) {
                char out = s.charAt(i - pl);
                if (map.containsKey(out)) {
                    map.put(out, map.get(out) + 1);
                    if (map.get(out) == 1) {
                        match--;
                    }
                }
            }

            if (match == map.size()) {
                result.add(i - pl + 1);
            }
        }
        return result;
    }
}
