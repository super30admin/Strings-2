// Time Complexity : O(M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(m), SC = O(1)               m          n 
    public List<Integer> findAnagrams(String s, String p) {
        // base
        if(s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length())
        return new ArrayList<>();
        int match = 0;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) { // storing p's frequency
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++) { // traversing over s
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)) {
                int count = map.get(incoming);
                count--; // 1 char found
                map.put(incoming, count);
                if(count == 0) match++; // fulfilled frequency of p in s's substring
            }
            if(i >= p.length()) {
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)) {
                    int count = map.get(outgoing);
                    count++; // 1 char removed
                    map.put(outgoing, count);
                    if(count == 1) match--; // count changes from 0 to 1, deficit of the char
                }
            }
            if(match == map.size()) { // matches map & not p's size as duplicates, p = "aab"
                res.add(i - p.length() + 1);
            } 
        }
        return res;
    }
}            