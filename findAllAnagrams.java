// Time - O(m+n) || Space - O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p == null || p.length() == 0) return result;
        HashMap<Character, Integer> map = new HashMap<>();  // Store char with its counts                              
        for(int i = 0; i < p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1); // store shorter string
        }
        int match = 0;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){ // char is present in map and it is incoming char
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0)  match++; 
            }
            if(j >= p.length()){
                char chr = s.charAt(j-p.length());                                         
                if(map.containsKey(chr)){ // outgoing char in map
                    map.put(chr, map.get(chr)+1); // reset its count
                    if(map.get(chr) == 1) match--;  // no longer match                                                         
                }
            }
            if(map.size() == match) {
                result.add(j-p.length()+1); // add starting index to result
            }  
        }
        return result;
    }
}