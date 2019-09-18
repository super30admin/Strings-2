class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> list = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        
        int match=0;
        
        
        for ( char c : p.toCharArray()){
            
            
            if(!map.containsKey(c))
                map.put(c,1);
            else
                map.put(c, map.get(c)+1);
            

        }
        
        
        
        for(int i=0;i<s.length();i++){
            
            char c= s.charAt(i);
            
            //in operation 
            
            if(map.containsKey(c)){
                
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)match++;
                    
                    
                
            }
            
            //out operation
            
            if(i >= p.length()){
                
                c = s.charAt(i-p.length());
                
                if(map.containsKey(c)){
                    
                    map.put(c,map.get(c)+1);
                    if(map.get(c)==1)match--;
                }
                    
                
            }
            
            //match
            if(match == map.size()) list.add(i-p.length()+1);
                    
            
            
        }
        
        return list;
        
    }
}