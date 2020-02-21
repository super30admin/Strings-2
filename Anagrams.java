/*
 * Leetcode link : https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
 * Time complexity : O(n+m)
 * Space complexity : O(1)
 * 
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        if(s == null || s.length() == 0){
            return result;
        }
        
        int slow = 0;
        int fast = 0;
        
        
        //Create the hashMap
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int count = 0;
        while(fast < s.length()){
            
            //Incoming character 
            char in = s.charAt(fast);
            if(map.containsKey(in)){
                
                map.put(in, map.get(in)-1);
                if(map.get(in) == 0){
                    count++;
                }
            }
            
            //Outgoing character
            if(fast >= p.length()){
                
                char out = s.charAt(slow);
                if(map.containsKey(out)){
                    map.put(out, map.get(out)+1);
                    
                    if(map.get(out) == 1){
                        count--;
                    }
                }
                slow++;
                
            }
            
            if(count == map.size()){
                result.add(fast - p.length() + 1);   
            }
            
            fast++;
            
        }
        
        return result;
    }
}