// Time Complexity = O(n + m), where n = s.length(), m = p.length()
// Space Complexity = O(m)
import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || p == null ||p.length() == 0)
            return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for(int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            // incoming element
            if(map.containsKey(in)) {
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0) match++;
                map.put(in, cnt);
            }   
            // outgoing element
            if(i >= p.length()) {
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)) {
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1) match--;
                    map.put(out, cnt);
                }
            }
            if(match == map.size()) result.add(i - p.length() + 1);
        }
        return result;
    }
}