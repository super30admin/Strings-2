// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int match = 0;
        for(int i = 0; i < m; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int frq = map.get(in);
                frq--;
                map.put(in, frq);
                if(frq == 0) match++;
            }

            if(i >= n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int frq = map.get(out);
                    frq++;
                    map.put(out, frq);
                    if(frq == 1) match--;
                }
            }

            if(match == map.size()){
                result.add(i-n+1);
            }
        }

        return result;
    }
}
