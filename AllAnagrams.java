//Time complexity=O(m *n) length of the strings
//Space complexity=O(n) length of the smaller string 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result  = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i);
            //proccessing the incoming Character
            if(map.containsKey(in)){
                int cnt = map.get(in) - 1;
                map.put(in, cnt);
                if(cnt == 0) match++;
            }
            
            //Outgoing Process
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out) + 1;
                    map.put(out, cnt);
                    if(cnt == 1) match--;
                }
            }
            if(match == map.size()) result.add(i - p.length() + 1);
        }
        return result;
    }
}