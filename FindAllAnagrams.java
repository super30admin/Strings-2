// https://leetcode.com/problems/find-all-anagrams-in-a-string/

// Time Complexity: O(p + s)
// Space Complexity: O(s)

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(Character pp : p.toCharArray()) {
            if(map.containsKey(pp)) {
                map.put(pp, map.get(pp)+1);
            } else {
                map.put(pp, 1);
            }
        }

        int matchCount = 0;

        for(int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            //incoming
            if(map.containsKey(in)) {
                int cnt = map.get(s.charAt(i));
                cnt--;
                if(cnt == 0) matchCount++;
                map.put(in, cnt);
            }

            //outgoing
            if(i >= p.length()) {
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)) {
                    int cnt =  map.get(out);
                    cnt++;
                    if(cnt == 1) matchCount--;
                    map.put(out, cnt);
                }
            }

            if(matchCount == map.size()) result.add(i - p.length() +1);
        }

        return result;
    }
}