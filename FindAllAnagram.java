class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        for(int i=0;i< p.length();i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int match = 0;
        for(int j=0;j<m;j++){
            char in = s.charAt(j);
            //in char
            if(map.containsKey(in)){
                int cnt = map.get(in)-1;
                map.put(in,cnt );
                if(cnt == 0){
                    match++;
                }

            }
            //out
            if(j >= p.length()){
                char out = s.charAt(j-p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out) +1;
                    map.put(out, cnt);
                    if(cnt == 1){
                        match --;
                    }
                }
            }

            if(match == map.size()){
                result.add(j - p.length() +1);
            }

        }

        return result;
    }
}