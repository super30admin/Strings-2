class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>output = new ArrayList<>();
        if(s.length() < p.length()){
            return output;
        }
        //hashmap for character's freq in string p
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i = 0 ; i < p.length() ; i++){
            char ch = p.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else{
                map.put(ch , map.get(ch)+1);
            }
        }

        int match = 0;
        for(int i = 0 ; i < s.length();i++){
            //incoming char
            char in = s.charAt(i);
            if(map.containsKey(in)){
                map.put(in , map.get(in) - 1);
                if(map.get(in) == 0){
                    match++;
                }
            }
            //outgoing char
            if(i>=p.length()){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    map.put(out , map.get(out)+1);
                    if(map.get(out) == 1){
                        match--;
                    }
                }

            }
            if(match == map.size()){
                output.add(i-p.length()+1);
            }
        }
        return output;

        
    }
}