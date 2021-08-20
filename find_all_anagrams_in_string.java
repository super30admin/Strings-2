// Find All Anagrams in a String - https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Time Complexity :  O(M + N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0)
            return result;
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                map.put(in, cnt);
                if(cnt == 0)
                    match++;
            }

            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out, cnt);
                    if(cnt == 1)
                        match--;
                }
            }

            if(match == map.size())
                result.add(i - p.length() + 1);
        }

        return result;
    }
}