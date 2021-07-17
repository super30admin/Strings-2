// Time Complexity : O(m)   m-> s.length()
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int lenS = s.length(); int lenP = p.length();
        if(s == null || lenS == 0 || lenP > lenS ) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        int match=0;
        for(int i=0; i<lenP; i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i=0; i<lenS; i++){
            char in = s.charAt(i);
            //in
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0) match++;
                map.put(in,cnt);
            }
            //out
            if(i>=lenP){
                char out = s.charAt(i-lenP);
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1) match--;
                    map.put(out,cnt);
                }
            }
            if(match==map.size()) result.add(i-lenP+1);
        }
        return result;
    }
}