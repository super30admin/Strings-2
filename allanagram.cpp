class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = p.length();
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<m;i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int match = 0;

        for(int i=0;i<s.length();i++){

                char in = s.charAt(i);
                if(map.containsKey(in)){
                    int cnt = map.get(in)-1;
                    map.put(in,cnt);

                    if(cnt == 0){
                        match = match+1;

                    }
                }


                if(i>=p.length()){
                char out = s.charAt(i-m);
                if(map.containsKey(out)){
                    int cnt = map.get(out)+1;
                    map.put(out,cnt);


                    if(cnt == 1){
                        match = match -1;
                    }
                }
                }
        if(map.size() == match){
            result.add(i-m+1);
        }
        }

        


        return result;
    }
}