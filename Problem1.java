// Time Complexity : O(m) + O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Store the frequency of each character into the hash map. 
 * Use the sliding window approach. For any incoming character, check if its present in the map, if yes, decrement count and increment match  when count is 0.
 * For any outgoing character, which is the i - length of the pattern, check if present in map, if yes, increment count and decrement match if cnt = 1. 
 */

class Problem1 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0; 
        int m = s.length();
        int n = p.length();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < p.length();i++){
            Character ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < s.length();i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0)
                    match++;
                map.put(in, cnt);
            }
            if(i >= n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                if(cnt == 1)
                    match--;
                map.put(out,cnt);
                }
            }
            if(map.size()==match){
                result.add(i-n+1);
            }
        }
        return result;
    }
}