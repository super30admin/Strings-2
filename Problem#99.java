// Find All Anagrams in a String

// Time Complexity : O(n)
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int k = p.length();
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(int i = 0; i < k; i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int n = s.length();
        int match = 0;
        for(int i = 0; i < n; i++){
            char in = s.charAt(i);
            if(pMap.containsKey(in)){
                int count = pMap.get(in) - 1;
                pMap.put(in, count);
                if(count == 0){
                    match++;
                }
            }
            if(i >= k){
                char out = s.charAt(i - k);
                if(pMap.containsKey(out)){
                    int count = pMap.get(out) + 1;
                    pMap.put(out, count);
                    if(count == 1){
                        match --;
                    }
                }
            }
            if(match == pMap.size()){
                result.add(i - k + 1);
            }
        }
        return result;
    }
}