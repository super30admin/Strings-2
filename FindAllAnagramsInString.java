// Leetcode : 438
// Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return res;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int start = 0;
        int end = 0;
        int match = 0;
        
        while(end < s.length()){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                
                if(map.get(ch) == 0){
                    match++;
                }
                
            }
            
            if(end - start + 1 > p.length()){
                char st = s.charAt(start);
                if(map.containsKey(st)){
                    map.put(st, map.get(st) + 1);
                    if(map.get(st) == 1){
                        match--;
                    }
                }
                start++;
            }
            
            if(match == map.size()){
                res.add(start);
            }
            end++;
        }
        return res;
    }
}