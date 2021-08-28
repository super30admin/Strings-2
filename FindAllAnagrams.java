// Time Complexity : O(m + n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int match = 0;
        if(s == null || s.length() == 0 || p == null || p.length() == 0) return result;
        for(int i = 0; i < p.length(); i++)  {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                map.put(in, count);
                if(count == 0)
                    match++;
            }
            if(i >= p.length()) {
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    map.put(out, count);
                    if(count == 1)
                        match--;
                }
            }
            if(match == map.size())
                result.add(i - p.length() + 1);
        }

        return result;
    }
}