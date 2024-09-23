// time complexity:O(n+m)
//space complexity:O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class anagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() == 0 || p.length() > s.length()) return result;
       HashMap<Character, Integer> map = new HashMap<>();

        for(char c: p.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } 
            else {
                map.put(c,1);
            }
        }
        int match = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) match++;
            }
            if (i >= p.length()) {
                c = s.charAt(i - p.length());
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 1) {
                        match--;
                    }
                }
            }
            if(match == map.size()) result.add(i-p.length()+1);
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> res= new ArrayList<>();
        anagram a= new anagram();
        String s = "cbaebabacd";
        String p = "abc";
        res=a.findAnagrams(s, p);
        System.err.println(res);
    }
}  
