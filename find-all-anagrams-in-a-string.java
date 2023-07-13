class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap <Character, Integer> map= new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int m = p.length(); 
        int n = s.length();
        int st = 0;
        if(m>n) return result;
        //adding all the characters of p in the map
        for(int i=0; i<m; i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int match = 0;
        for(int i = 0; i <n; i++){
            char in = s.charAt(i);
            //checking the in character
            if(map.containsKey(in)){
                int cnt = map.get(in)-1;
                map.put(in,cnt);
                if(cnt == 0){
                    match++;
                }
            }
            //checking the out character
            if(i >= m){
                char out= s.charAt(i-m);
                if(map.containsKey(out)){
                    int cnt = map.get(out)+1;
                    map.put(out,cnt);
                    if(cnt==1){
                        match--;
                    }
                }
            }
            if(match == map.size()){
                result.add(i-m+1);
            }
        }
        return result;
    }
}