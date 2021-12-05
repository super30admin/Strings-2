// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }
        
        int match=0;
        List<Integer> result=new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                
                if(map.get(c)==0){
                    match++;
                }
                    
            }
              if(i>=p.length()){
                char o=s.charAt(i-p.length());
                  if(map.containsKey(o)){
                    map.put(o,map.get(o)+1);
                    if(map.get(o)==1) match--;
                  }
              }
            
             if(match==map.size()){
                    result.add(i-p.length()+1);
             }
            
        }
        
        return result;
    }
}