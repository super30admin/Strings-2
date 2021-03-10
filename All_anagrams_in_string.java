// Time: O(slen + plen)
// Space O(plen)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      
      int slen = s.length();
        int plen = p.length();
      // if(slen < plen){
      //   return null;
      // }
      
      HashMap<Character,Integer> map = new HashMap<>();
      List<Integer> out = new ArrayList<>();
      int match = 0;
      
      int start = 0;
      int end = 0;
       for(char ch:p.toCharArray()){
        map.put(ch,map.getOrDefault(ch,0)+ 1);
       }
      
      
      while(end < s.length()){
        //incoming window is absorbing element
        char incoming = s.charAt(end);
        if(map.containsKey(incoming)){
          map.put(incoming, map.get(incoming) -1);
           if(map.get(incoming) == 0){ // found the element
            match++;
          }
        }
       
        
        //outgoing window is releasing an element
        if(end-start+1 > plen){
          char outgoing;
          outgoing = s.charAt(start);
          if(map.containsKey(outgoing)){
             map.put(outgoing, map.get(outgoing) +1);
             if(map.get(outgoing) == 1){ // found the element
              match--;
            }
             
          }
         
          start += 1;
        }
        if(match == map.size()){
              out.add(start);
        }
        end += 1;
      }
      return out;
    }
}
