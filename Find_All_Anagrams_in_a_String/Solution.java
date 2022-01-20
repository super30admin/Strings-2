// Time Complexity : O(n + m) where n = length of s and m = length of p
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * First we iterate over p and make an entry in hashmap against each char and its count in p
 * Now we will iterate over s. and use two pointers to keep a sliding window os length p.length()
 * We use a match variable to keep a track of how many char we are yet to match (equal to size of hashmap)
 * In each interation one char will come into window and one will go out. 
 * For incoming char we increment its count in hashmap if present by 1 
 * For each outgoing char we decrement its count in hashmap if present by 1
 * If count goes to zero we decrement match variable. If match == 0, we got an anagram so we add starting index of window to result
 * if count of any char goes to +1 or -1 we increment match variable
*/


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() < p.length())return result;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length();i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int start = 0;
        int right = 0;
        int match = map.keySet().size();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1); 
                if(map.get(ch) == 0){
                   match--;
                 }
                 if(map.get(ch) == -1){
                   match++;
                 }
            }
            
            if(i < p.length()){
                if(match == 0){
                    result.add(start);
                }
                continue;
            }
            
            char prev = s.charAt(start);
            start++;
            if(map.containsKey(prev)){
               map.put(prev, map.get(prev) + 1);
            if(map.get(prev) == 0){
                match--;
            }
            if(map.get(prev) == 1){
                match++;
            }
            }
            if(match == 0){
                result.add(start);
            } 
        }
        
        return result;
    }
}