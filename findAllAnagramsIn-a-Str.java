// Time Complexity : O(m + n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p.length() > s.length()){
            return result;
        } 
        HashMap<Character, Integer> map = new HashMap<>();
        // iterate over each character
        for(int i=0; i< p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        // window
        int match = 0;
        for(int i=0; i< s.length(); i++){
            char in = s.charAt(i);
            
            // incoming
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                map.put(in, cnt);
                if(cnt == 0) match++;
            }
            
            // outgoing char
            if(i >= p.length() ){
                 char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out, cnt);
                    if(cnt == 1) match--;
                }
            }
            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}