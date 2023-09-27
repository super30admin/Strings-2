// tc = O(n)
// sc = O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character , Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i =0 ; i < p.length() ; i++){
            char ch = p.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) +1);
        }
        int match = 0;
        for (int i = 0 ; i < s.length() ; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
               if(cnt == 0) match++;
                map.put(in , cnt);
            }
        
        if(i >= p.length()){
              char out = s.charAt(i - p.length());
            if(map.containsKey(out)){
                int cnt = map.get(out);
                cnt++;
               if(cnt ==1) match--;
                map.put(out, cnt);
            }
        }
        if(map.size() == match) result.add((i-p.length()) +1);   
    }
    return result;
}
}