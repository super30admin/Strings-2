// Time Complexity : O(m + n), m, n are lengths of the strings
// Space Complexity : O(1) as map may contain 26 letters at max.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to first maintain a map for string p along with their frequencies. Now, we need to iteratively
traverse through string s and check if incoming character is present in the map, inner meaning, if we find the
common characters with string p. If so, we update the map for that letter by decrementing its frequency.At any
point, if the freq becomes 0, we increment the match count.Now, we dont want to traverse entire string at once as we are only
interested in observing p's length, so we have a sliding window and at any time, if the window exceeds n, we push out
the char at start and expand the window.Pushing out a char means, we also need to update its freq in mpa by incrementing.At
any time, if it becomes 1, we reduce the match count. This way, whenever match value becomes equal to the map size, we
got the required anagram, so we append the index to the result.
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(Character ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int match = 0;
        int m = s.length();
        int n = p.length();

        for(int i = 0 ; i < m ; i++) {
            char inChar = s.charAt(i);
            if(map.containsKey(inChar)) {
                int frq = map.get(inChar);
                frq--;
                map.put(inChar, frq);

                if(frq == 0)
                    match++;
            }

            if(i >= n) {
                char outChar = s.charAt(i - n);
                if(map.containsKey(outChar)) {
                    int frq = map.get(outChar);
                    frq++;
                    map.put(outChar, frq);

                    if(frq == 1)
                        match--;
                }
            }

            if(match == map.size())
                result.add(i - n + 1);
        }
        return result;
    }
}