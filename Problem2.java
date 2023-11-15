//Time Complexity : O(n)
//Space Complexity :O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = p.length();
        int m = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n;i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) +1);
        }
        int match=0;
        for(int i=0;i<m;i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in)-1;
                if(cnt==0){
                    match++;
                }
                map.put(in,cnt);
            }
            if(i >= n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int cnt = map.get(out)+1;
                    if(cnt == 1){
                        match--;
                    }
                    map.put(out,cnt);
                }
            }
            if(match==map.size()){
                result.add(i-n+1);
            }
        }
        return result;
    }
}
