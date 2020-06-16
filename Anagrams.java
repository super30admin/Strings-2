class Anagrams {
    /**
     * Time Complexity : O(N) where N is length of s
     * Space Complexity : O(M) M is length of p 
     * 
     * Approach:
     * Sliding window:
     * 1. For every incoming character, decrease its count of occurrence from the pattern (map).
     * 2. For every out going chracter, increase its count of occurrence from the pattern (map).
     * 3. For the window, where all the pattern's characters' counts are 0, it means the pattern's anagram is 
     * found in the window.
     */
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        if(s == null || p == null || s.length() < p.length()) {
            return result;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0, j = 0;
        
        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                
                if(map.get(c) == 0){
                    match++;
                }
            }
            
            if(i >= p.length()) {
                c = s.charAt(i - p.length());
                
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                    
                    if(map.get(c) == 1){
                        match--;
                    }
                }

            }
            
            if(match == map.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}