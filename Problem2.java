// Time Complexity : O(s+p) where s is the length of string 's' and p is the length of string 'p'
// Space Complexity : O(p)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;

        for(int i=0;i<p.length(); i++){
            if(!map.containsKey(p.charAt(i))){
                map.put(p.charAt(i), 0);
            }
            map.put(p.charAt(i) , map.get(p.charAt(i)) + 1);
        }

        int matching = 0;

        int idx = 0;
        while(idx < s.length() ){

            if( idx - start +1 > p.length()){
                if(map.containsKey(s.charAt(start)) ){
                    
                    map.put(s.charAt(start) , map.get(s.charAt(start)) + 1);    
                    int count = map.get(s.charAt(start));
                    if(count == 1){ 
                        matching--;
                    }
                }
                start++;
                continue;
            }

            if(map.containsKey(s.charAt(idx)))
            {
                map.put(s.charAt(idx) , map.get(s.charAt(idx)) - 1);
                int count = map.get(s.charAt(idx));
                if(count==0){
                    matching++;
                }
            } 

            if(matching == map.size()){
                result.add(idx - p.length() +1);
            }
            idx++;

        }
        
        return result;
        
    }
}