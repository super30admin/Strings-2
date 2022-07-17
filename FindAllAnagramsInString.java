/* Time Complexity: O(n) -> O(m+n), we don't consider m here
 * Space Complexity: O(1) -> O(m), m is the size of map and map will be of 
 * 					 size 26 at max as there are 26 characters at max.
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            //incoming character
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0) match++;
                map.put(in, cnt);
            }      
            if(i >= p.length()){
                //outgoing character
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1) match--;
                    map.put(out, cnt);
                } 
            }
            if(match == map.size()) result.add(i - p.length() + 1);
        }
        return result;
    }
}