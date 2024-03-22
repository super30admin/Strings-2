class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hm = new HashMap<>();
        List<Integer> r = new ArrayList<>();
        for(char c : p.toCharArray()){
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)+1);
            }
            else{
                hm.put(c,1);
            }
        }

        int l = 0;
        int h = 0;
        int match = 0;

        while(h < s.length()){
            char in = s.charAt(h);
            if(hm.containsKey(in)){
                hm.put(in, hm.get(in) - 1);
                if(hm.get(in) == 0){
                    match++;
                }
            }
            h++;

            if(h - l == p.length()){
                if(match == hm.size()){
                    r.add(l);
                }

                char out = s.charAt(l);
                if(hm.containsKey(out)){
                    if(hm.get(out) == 0){
                        match--;
                    }
                    hm.put(out, hm.get(out) + 1);
                }
                l++;
            }
        }

        return r;
    }

   
}
