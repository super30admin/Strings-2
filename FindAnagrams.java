// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        if(s == null || s.length() == 0) return result;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0;
        
        for(int i = 0; i < s.length(); i++) {
            //Incoming
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int cnt = map.get(c);
                cnt--;
                if(cnt == 0) {
                    match++;
                }
                map.put(c, cnt);
            }
            
            //Outgoing
            if(i >= p.length()) {
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)) {
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1) {
                        match--;
                    }
                    map.put(out, cnt);
                }
            }
            
            if(match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}