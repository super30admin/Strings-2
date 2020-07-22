// Time complexity - O(m+n)
// Space complexity - O(1)

// Sliding window + hashmap

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() == 0 || p.length() > s.length()) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c,1);
            }
        }
        int match = 0;
        
        for(int i = 0 ; i < s.length(); i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in) - 1;
                map.put(in,cnt);
                if(cnt == 0) match++;
            }
            
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    map.put(out, map.get(out)+1);
                    if(map.get(out) == 1) match--;
                }
            }
            
            if(match == map.size()){
                 result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
