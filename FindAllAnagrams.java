/**
TC - O(m+n)
SC - O(m+n)
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        int m = s.length();
        List<Integer> res = new ArrayList<>();
        if(n>m) return res;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int match =0;
        for(int i=0;i<m;i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                map.put(in, cnt);
                if(cnt ==0) match++;
            }
            if(i>=n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                int cnt = map.get(out);
                cnt++;
                map.put(out, cnt);
                if(cnt == 1) match--;
            }

            }
            if(match == map.size()) res.add(i-n+1);
        }
        
        
        return res;
    }
}
