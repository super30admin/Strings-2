//leetcode 438 : Find all anagrams in a string
// Time - O(n)
// Space - O(n)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < p.length(); i++){
            
            char ch = p.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch) + 1);
            }
        }
        
        int match = 0;
        List<Integer> result = new ArrayList();
        for(int i = 0; i < s.length(); i ++){
            
            char c = s.charAt(i);
            //incoming
            if(map.containsKey(c)){
                
                map.put(c, map.get(c) - 1);
                
                if (map.get(c) == 0){
                    match++;
                }
            }
            //outgoing
            if (i - p.length() >= 0){
                char outGoing = s.charAt(i - p.length()) ;
                if(map.containsKey(outGoing)){
                    map.put(outGoing, map.get(outGoing) + 1);
                if(map.get(outGoing) == 1){
                        match--;
                    }
                }
                

            }
            
            if(match == map.size()){
                result.add(i - p.length() + 1);
            }

        }
        return result;
    }
}