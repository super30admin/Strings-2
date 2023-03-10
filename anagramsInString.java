// Time Complexity : O(m), m is the length of s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * we put all the chars of the p string in the hashmap. 
 * check the incoming and outgoing chararacters, if the incoming char is present in the map then we decrement its count in the map. If the count is 0 then there is a match, we increment match count
 * we put the updated count to the map. 
 * For outgoing char count, we check if it is in the map,
 * we increment the count and if it is 1 then we decrement the match and update the count value in map.
 * The start of the window where the match count is equal to the size of the map, we get index of the anagram.
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int n = p.length();
        int match = 0;
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            // incoming Character
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int count = map.get(in) - 1;
                map.put(in, count);
                if (count == 0)
                    match++;
            }
            // outgoing Character
            if (i >= n) {
                char out = s.charAt(i - n);
                if (map.containsKey(out)) {
                    int count = map.get(out) + 1;
                    map.put(out, count);
                    if (count == 1)
                        match--;
                }
            }

            if (map.size() == match) {
                result.add(i - n + 1);
            }
        }

        return result;
    }
}
