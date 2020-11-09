import java.util.*;

/*
TC: O(S+P) : length of S, length of P
SC: O(1) hashmap can have at max 26 entries.

1. Keep a hashmap with char count of string p.
2. Move sliding window along the string s.
    Recompute count at each step by adding one letter at right and remove one at left
    Add index s if e - s == length of p.

*/

public class AllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        
        if(s == null || s.length() == 0 || p.length() > s.length()) return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c , 0) + 1);
        }
        
        int count = map.size();
        
        int st = 0, e = 0;
        
        while(e < s.length()){
            char c = s.charAt(e);
            
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count--;
            }
             e++;
            
            while(count == 0){
                if((e - st) == p.length()){
                    list.add(st);
                }
                char ch = s.charAt(st);
                
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) +1);
                    if(map.get(ch) > 0) count++;
                }
                st++;
            }
        }
        
        return list;
    }

    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";

        AllAnagrams anagrams = new AllAnagrams();
        System.out.println(anagrams.findAnagrams(s, p));

    }
}
