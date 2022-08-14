// Time Complexity: O(m + n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if( s == null || s.length() == 0 || p.length() > s.length()){
            return new ArrayList<>();
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt --;
                if(cnt == 0){
                     match++;
                }
                map.put(in, cnt);    
            }
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1){
                        match--;
                    }
                    map.put(out, cnt);
                }
            }
            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}