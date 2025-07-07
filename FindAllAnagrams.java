//Time Complexity : O(m+n)
//Space Complexity : O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s==null || p ==null || s.length()==0 || p.length()==0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int m = p.length();
        int n = s.length();

        for(int i = 0; i < m; i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        int match = 0;
        for(int i=0; i < n;i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt --;
                map.put(in, cnt);
                if(cnt == 0) match++;
            }
            if(i >= m){
                char out = s.charAt(i-m);
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out,cnt);
                    if(cnt == 1) match--;
                }
            }
            if(match == map.size()){
                result.add(i-m+1);
            }
        }
        return result;
    }
}
