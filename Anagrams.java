// Time Complexity : O(m + n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null || s.length() == 0 || p.length() == 0){
            return new ArrayList<>();
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        int match=0;
        for(int i=0;i<s.length();i++){
            char in = s.charAt(i);
            if(hm.containsKey(in)){
                int cnt = hm.get(in);
                cnt-- ;
                if(cnt == 0){
                    match++;
                }
                hm.put(in,cnt);
            }
            if(i>=p.length()){
                char out = s.charAt(i-p.length());
                if(hm.containsKey(out)){
                    int cnt = hm.get(out);
                    cnt++;
                    if(cnt == 1){
                        match--;
                    }
                hm.put(out,cnt);
                }
            }
            if(match == hm.size()){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
}