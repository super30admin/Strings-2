/* Time Complexity : O(m) 
*   m - length of source string - s */
/* Space Complexity : O(26) ~ O(1) 
*   size of the hashmap */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        //If patterns len is greater than source string len result empty list.
        if(n > m) return result;
        int match = 0;
        //freq map of pattern p
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //traverse through source str. s
        for(int i = 0; i < m; i++){
            //in char
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int freq = map.get(in) - 1;
                if(freq == 0){
                    match++;
                }
                map.put(in, freq);
            }
            //After window of len p is formed
            if(i >= n){
                //out char
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int freq = map.get(out) + 1;
                    if(freq == 1){
                        match--;
                    }
                    map.put(out, freq);
                }
            }
            if(match == map.size()){
                result.add(i - n + 1);
            }
        }
        return result;
    }
}