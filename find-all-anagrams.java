// Time - O(M+N)
// Space - O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        
        for(int i=0;i<p.length();i++) {
            char ch = p.charAt(i);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int match = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)) {
                int cnt = map.get(ch);
                cnt--;
                if(cnt == 0) {
                    match++;
                }
                map.put(ch, cnt);
            }
            
            if(i>= p.length()) {
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)) {
                    int cnt = map.get(outgoing);
                    cnt++;
                    if(cnt == 1) {
                        match--;
                    }
                    map.put(outgoing, cnt);
                }
            }
            
            if(match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
}
