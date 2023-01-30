// Time: O(m+n)
// Space: O(n) where n = needle Str length

import java.util.*;

public class FindAllAnagram {
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character,Integer> map = new HashMap<>();
            for (char ch : p.toCharArray()){
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
            int k = p.length();
            List<Integer> res = new ArrayList<>();
            int match = 0;
            for (int i = 0;i < s.length();i++){
                char inc = s.charAt(i);
                // Incoming char
                if (map.containsKey(inc)){
                    int cnt = map.get(inc)-1;
                    map.put(inc, cnt);
                    if (cnt == 0) match++;
                } 
                //outgoing char
                if (i >= k){
                    char out = s.charAt(i-k);
                    if (map.containsKey(out)){
                        int cnt = map.get(out)+1;
                        map.put(out, cnt);
                        if (cnt == 1) match--;
                    }
    
                }
                if (match == map.size()){
                    res.add(i-k+1);
                }
            }
            return res;
        }
    }