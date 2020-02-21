//TC : O(m+n) where m and n are length of strings
//SC : O(n) where n is the length of the pattern
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if(s.length() == 0 || p.length() == 0 || s.length() < p.length())
            return result;

        HashMap<Character,Integer> map= new HashMap<>();
        //Create a hashmap of the pattern
        for(int i=0;i<p.length();i++){
            Character c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int match = 0;
        
        
        for(int i=0;i<s.length();i++){
            
            //Incoming Character
            Character incoming = s.charAt(i);
            if(map.containsKey(incoming)){
                map.put(incoming,map.get(incoming)-1);
                if(map.get(incoming) == 0)
                    match++;
            }
            //We start getting outgoing character only from this point
            if(i >= p.length()){
                Character outgoing = s.charAt(i-p.length());
                if(map.containsKey(outgoing)){
                    map.put(outgoing,map.get(outgoing)+1);
                    if(map.get(outgoing) == 1)
                        match--;
                }
            }
            
            if(match == map.size()){
                result.add(i-p.length()+1);
            }
        }

        return result;
        
    }
}