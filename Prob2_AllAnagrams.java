// Time Complexity : O(m + n) ===== O(m) // m -> Length of Source string and n -> Length of Pattern String
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int x = 0; x< p.length(); x++){ // STORED Charactrers of Pattern in HashMap
            map.put(p.charAt(x), map.getOrDefault(p.charAt(x), 0) + 1 );
        }
            
        int i = 0;
        int m = s.length();
        int len = p.length();
        int matched = 0;
        while(i < m){ // Iterating on Source String
            
            char chIn = s.charAt(i);
            
            if(map.containsKey(chIn)){ // For Incoming character, decrease its count from map by 1
                int count = map.get(chIn) - 1;
                map.put(chIn, count);
                if(count == 0){ // If count becomes 0, increment match by 1
                    matched++;
                }
            }
            
            if(i >= len){
                char chOut = s.charAt(i - len);
                
                if(map.containsKey(chOut)){// For Outgoing character, increase its count in map by 1
                int count = map.get(chOut) + 1;
                map.put(chOut, count);
                if(count == 1){ // If count becomes 1, decrement match by 1 
                    matched--;
                    }
                }
            }
            
            if(map.size() == matched){
                result.add(i - len + 1);
            }
            
            i++;
        }
        return result;
    }
}