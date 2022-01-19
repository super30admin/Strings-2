// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We use Hashmap and sliding window to solve this
// we put the characters and their frequency in the string s in the hashmap
// Then we iterate over the string order and for each character we check the frequency 
// We increment the match variable, if it reaches the size same as the hashmap then we add the index in the result

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() == 0 || s == null || p == null || p.length() == 0)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int count = map.get(in);
                count--;
                map.put(in, count);
                if (count == 0) {
                    match++;
                }
            }
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
                result.add(i - p.length() + 1);

        }
        return result;
    }
}