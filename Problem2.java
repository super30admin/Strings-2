// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int m = s.length(); int n = p.length();
        for(int i = 0; i < n; i++){
            char ch = p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int match = 0;
        for(int i = 0; i < m; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in)-1;
                if(cnt == 0)
                    match++;
                map.put(in,cnt);
            }
            if(i >= n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int cnt = map.get(out)+1;
                    if(cnt == 1)
                        match--;
                    map.put(out,cnt);
                }
            }
            if(match == map.size())
                ans.add(i-n+1);
        }
        return ans;
    }
}