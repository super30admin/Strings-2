class FindAllAnagramsinaString{
    
    // Approac 1 - using hashmap
    // Time complexity - O(n+m)
    // Space complexity - O(1)
    // Tested in leetcode
    
    // This method match string p into string s and return arrays of matching indexes
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int match = 0;
        
        // store p into the hashmap
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c,0) +1);
        }
        
        // for each char of string s check into hashmap
        // if match value is equal to the length of the p then save this index into the result array.
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            // when character is found then decrease the count of the character and increase the value of match
            if(map.containsKey(s.charAt(i))){
                map.put(c, map.get(c) -1);
                if(map.get(c) == 0)
                    match++;
            }
            
            // when iterating the string s at position greater than the length of the p
            // decrese the count of match value if found in the map and decrease the match value
            if(i >= p.length()){
                c = s.charAt(i-p.length());
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) == 1)
                        match--;
                }
            }
            
            // add index into the result if all character of p is matched to s 
            if(match == map.size() )
                result.add(i-p.length()+1);
        }
        return result;
    }
}