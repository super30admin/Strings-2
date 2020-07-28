//Time Complexity : O(n);
//Space : O(1) since hashmap can only have max 26 letters
//Leetcode : worked

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int match =0;int count = 0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            //incoming
            if(map.containsKey(c)){
                map.put(c,map.get(c) -1);
                if(map.get(c) == 0) match ++;
            }
            
            //outgoing
            if(i>=p.length()){
                char o = s.charAt(i-p.length());
                if(map.containsKey(o)){
                    map.put(o,map.get(o) +1);
                    if(map.get(o) == 1) match --;
                }
            }
            
            
            if(match == map.size()){
                result.add(i-p.length()+1);
            }
        }
        
        return result;
        
    }
}