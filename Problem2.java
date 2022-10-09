//Time complexity : max(O(M+N)) = O(N) , M and N are length of s and p strings
//Space Complexity : O(1)

class Problem2 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if(p.length() > s.length()) return result;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i =0; i<p.length(); i++){
            char c= p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int match =0;
        for(int i=0; i<s.length(); i++){

            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                map.put(in , cnt);

                if(cnt ==0) match++;
            }

            if(i>=p.length()){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out,cnt);
                    if(cnt ==1 ) match--;
                }
            }


            if(match == map.size()) result.add(i-p.length() +1);
        }
        return result;
    }
}