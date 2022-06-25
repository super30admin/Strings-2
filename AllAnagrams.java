// Time Complexity : O(n + m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
       if(p.length() > s.length()) return result;
       HashMap<Character, Integer> map = new HashMap<>();
       for(char ch : p.toCharArray()){
           if(!map.containsKey(ch)) map.put(ch, 0);
            map.put(ch, map.get(ch) + 1);
       }
       int match = 0;
       for(int i = 0; i < s.length(); i++){
           char in = s.charAt(i);
           if(map.containsKey(in)){
               int count = map.get(in);
               count--;
               map.put(in, count);
               if(count == 0) match++;
           }
           if( i >= p.length()){
               char out = s.charAt(i - p.length());
               if(map.containsKey(out)){
                   int count = map.get(out);
                   count++;
                   map.put(out, count);
                   if(count == 1) match--;
               }
           }
           if(match == map.size()) result.add(i - p.length() + 1);
       }
       return result;
}
}
