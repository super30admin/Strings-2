class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(); int n = p.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        
        List<Integer> result = new ArrayList<>();
        int match = 0;
        for(int i=0;i<m;i++){
            // incoming
            if(map.containsKey(s.charAt(i))){
                int cnt = map.get(s.charAt(i)) - 1;
                map.put(s.charAt(i),cnt);
                if(cnt == 0){
                    match++;
                }
            }
            // outgoing
            if(i>=n){
                if(map.containsKey(s.charAt(i-n))){
                    int cnt = map.get(s.charAt(i-n)) + 1;
                    // cnt++;
                    map.put(s.charAt(i-n),cnt);
                    if(cnt==1){
                        match--;
                    }
                }
            }
            if(match == map.size()){
                result.add(i-n+1);
            }
        }
        return result;
    }
}