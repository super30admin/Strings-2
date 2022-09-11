// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0;
        for(int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            // in char
            if(map.containsKey(in)) {
                int count = map.get(in);
                count--;
                if(count == 0) {
                    match++;
                }
                map.put(in, count);
            }
            // out char
            if(i >= p.length()) {
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    if(count == 1) {
                        match--;
                    }
                    map.put(out, count);
                }
            }
            
            if(map.size() == match) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}