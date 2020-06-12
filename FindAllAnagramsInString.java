package s30Coding;
import java.util.*;
//Time Complexity :- O(n + m) m is length of string p and n is the length of string s
//Space Complexity :- O(1) max 26 characters in the hashmap

public class FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
       
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        
       for(int i =0 ; i < s.length();i++){
           Character in = s.charAt(i);
           if(map.containsKey(in)){
               int cnt = map.get(in) - 1;
               if(cnt == 0) match++;
               map.put(in, cnt);
           }
           if(i >= p.length()){
               Character out = s.charAt(i - p.length());
               if(map.containsKey(out)){
                   int outNewCnt = map.get(out) + 1;
                   if(outNewCnt == 1) match--;
                   map.put(out, outNewCnt);
               }
           }
           if(match == map.size()){
               result.add(i - p.length()+1);
           }
       }
        return result;
    }
}
