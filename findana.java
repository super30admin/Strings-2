class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if(s.length()<p.length()) return res;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int fast =0;
        int slow=0;
        int match=0;

        while(fast<s.length()){
            char in = s.charAt(fast);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                if(count==0){
                    match++;
                }
                map.put(in,count);
            }

            if(fast>=p.length()){
                char out=s.charAt(slow);
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    if(count==1){
                        match--;
                    }
                    map.put(out,count);
                }
                slow++;
            }
            if(match==map.size()){
                res.add(slow);
            }
            fast++;
        }
        return res;
    }
}
