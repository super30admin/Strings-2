class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        //base case check
        if(p.length() > s.length()) return result;
      
        //freq map for p
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //sliding window of length p
        //iterate on s 
        int match = 0;
       
        
        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i);
            //incoming character in
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                map.put(in, count);
                if(count == 0) match++;
            }
            
            //outgoing
            if(i >= p.length()){
                char out = s.charAt(i -  p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    map.put(out, count);
                    if(count == 1) match--;
                }
            } 
            if(match == map.size()) result.add(i - p.length() + 1);
        }
        return result;
    }
}
