// Time Complexity : O(m+n)
// Space Complexity : O(26) -> O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int i=0;
        int m = s.length();
        int n = p.length();
        int match = 0;

        while(i<m) {
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                int freq = map.get(in);
                freq--;
                if(freq == 0)
                    match++;
                map.put(in, freq);
            }

            if(i>=n) {
                char out = s.charAt(i-n);
                if(map.containsKey(out)) {
                    int  freq = map.get(out);
                    freq++;
                    if(freq == 1)
                        match--;
                    map.put(out, freq);
                }
            }

            if(match == map.size())
                result.add(i-n+1);
            i++;
        }

        return result;
    }
}