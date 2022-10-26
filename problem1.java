//Problem1 - https://leetcode.com/problems/find-all-anagrams-in-a-string/

// Time Complexity : O(n)
// Space Complexity : O(1) //Constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

public class problem1 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        int start = 0;
        int end = 0;
        int match = 0;

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            // in
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int count = map.get(in);
                count--;
                map.put(in, count);
                if (count == 0)
                    match++;
            }

            // out
            if (i >= p.length()) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    map.put(out, count);
                    if (count == 1)
                        match--;

                }
            }

            if (match == map.size())
                li.add(i - p.length() + 1);
        }
        return li;
    }
}
