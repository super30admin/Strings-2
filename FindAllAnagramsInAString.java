// Time Complexity : O(ns+np) ns = length of the string s np = length of the string p
// Space Complexity : O(1) - hashset stores 26 chars and its frequency
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Using sliding window approach
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        int ns = s.length();
        int np = p.length();

        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        int i=0;

        while(i < ns) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                int freq = map.get(c);
                freq--;
                map.put(c, freq);
                if(freq == 0) {
                    match++;
                }

            }

            //out
            if(i >= np){
                char outc = s.charAt(i-np);
                if(map.containsKey(outc)) {
                    int freq = map.get(outc);
                    freq++;
                    map.put(outc, freq);
                    if(freq == 1){
                        match--;
                    }
                }


            }

            if(match == map.size()) {
                result.add(i-np+1);
            }
            i++;
        }

        return result;
    }
}