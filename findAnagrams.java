//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() == 0 || s== null || p.length() == 0 || p == null) {
            return new ArrayList<>();
        }

        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        int match = 0;
        int count;
        for(int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int in = 0; in < s.length(); in++) {
            char c = s.charAt(in);

            if(map.containsKey(c)) {
                count = map.get(c);

                count--;

                if(count == 0) {
                    match++;
                }
                map.put(c, count);
            }

            if(in >= p.length()) {
               char out = s.charAt(in - p.length());
               if(map.containsKey(out)) {
                   count = map.get(out);
                   count++;
                   
                   if(count==1) {
                       match--;
                   }

                   map.put(out, count);
               }
            }

            if(match == map.size()) {
                ls.add(in- p.length() + 1);
            }
        }

        return ls;
    }
}