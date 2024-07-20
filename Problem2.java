/*
    LC - 438. Find All Anagrams in a String
    TC - O(m + n)
        Bcz any of the string can be larger , so need both include in time complexity.
    SC - O(1)
    Approach - 
        Using HashMap to store the frequency of the string p.
        Traverse the string s.
        check if the incoming char contains in map, then reduce the count. 
        if count == 0, then increment the match.
        if the i (traversal length) goes beyond the p length. then
         it indicates outgoing character. get the char, increment the count
          if count == 1 then decrement the match

        check if the match == map.size()
        then add the index (i - p.length + 1) to the result list
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0 || p.length() > s.length()) {
            return new ArrayList<>();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int match = 0;
        for(int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i=0; i<s.length(); i++) {
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)) {
                int cnt = map.get(incoming);
                cnt--;
                if(cnt == 0) {
                    match++;
                }
                map.put(incoming, cnt);
            }
            if( i >= p.length()) {
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)) {
                    int cnt = map.get(outgoing);
                    cnt++;
                    if(cnt == 1) { 
                        match--;
                    }
                    map.put(outgoing, cnt);
                }
            }
            if(map.size() == match) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}