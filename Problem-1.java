//Time complexity :O(n+m)
//Space complexity :O(m)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        
        if(p==null || p.length() == 0) return output;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch : p.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            int start =0;
            int end =0;
            int match=0;
            
            while(end<s.length()){
                //incoming
                char ch = s.charAt(end);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch)-1);
                    
                    if(map.get(ch) == 0){
                        match++;
                    }
                }
                
                //outgoing
                if(end-start+1 > p.length()){
                    char out = s.charAt(start);
                   if(map.containsKey(out)){
                    map.put(out, map.get(out)+1);
                    
                    if(map.get(out) == 1){
                        match--;
                    }
                } 
                    start++;
                }
                if(match == map.size()){
                    output.add(start);
                }
                end++;
            }
            return output;
        
    }
}