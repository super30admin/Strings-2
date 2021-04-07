class FindAllAnagramsInAString {
    
    // Time Complexity: O(n + m)    (where n -> length of s)
    // Space Compexity: O(m)    (where m -> length of p)
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0)
            return result;
        
        int n = s.length();
        int m = p.length();
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        
        int start = 0;
        int end = 0;
        int match = 0;
        
        while(end < n){
            // Incoming characters
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                
                if(map.get(c) == 0)
                    match++;
            }
            
            // Outgoing Character
            if(end - start + 1 > m){
                char out = s.charAt(start);
                if(map.containsKey(out)){
                    map.put(out, map.get(out) + 1);
                    
                    if(map.get(out) == 1)
                        match--;
                }
                start++;
            }
            
            if(match == map.size())
                result.add(start);
            
            end++;
        }
        return result;
    }
}