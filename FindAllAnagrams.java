// Time Complexity : O(m + n)
// Space Complexity : O(min(m, n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch: p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int match = 0;
        List<Integer> result = new ArrayList<>();
        
        while(right < s.length()) {
            
            char rightChar = s.charAt(right);
            
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                
                if(map.get(rightChar) == 0) {
                    match++;
                }
            }
            right++;
            if(right - left  > p.length()) {
                
                char leftChar = s.charAt(left);
                
                if(map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    
                    if(map.get(leftChar) == 1) {
                        match--;
                    }
                }
                left++;
            }
                        
            if(match == map.size()) {
                result.add(left);
            }
        }
        
        return result;
    }
}