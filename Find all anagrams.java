// Time complexity - 0(m+n)
// space complexity - 0(n)
// code successfully executed in leetcode


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() < p.length()) return result;
       
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
         int match = 0;
        for(int i=0;i<s.length();i++){
            // Incoming character
            char in = s.charAt(i);
            if(map.containsKey(in)){
            map.put(in,map.get(in)-1);
            if(map.get(in) == 0) match++;
        }
         //Out going character
        if(i >= p.length()){
            char out = s.charAt(i-p.length());
            if(map.containsKey(out)){
                map.put(out,map.get(out)+1);
                if(map.get(out)== 1) match--;
            }
            
        }
        if(match == map.size()) result.add(i-p.length()+1);
        } 
        return result;
    }
}