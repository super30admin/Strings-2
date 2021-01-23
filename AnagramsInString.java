//Time Complexity - O(n)
//Space complexity - O(1)

//Sliding window with HashMap

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p == null || p.length() == 0){
            return result;
        }
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            hmap.put(c, hmap.getOrDefault(c, 0)+ 1);
        }
        
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            //Incoming
            char c = s.charAt(i);
            if(hmap.containsKey(c)){
                int count = hmap.get(c);
                count--;
                if(count == 0){
                    match++;
                }
                hmap.put(c , count);      
            }
            
            //outgoing    
            if(i >= p.length()){
                char c1 = s.charAt(i - p.length());
                if(hmap.containsKey(c1)){
                    int count = hmap.get(c1);
                    count++;
                    if(count == 1){
                        match--;
                    }
                    hmap.put(c1 , count);      
                }
            }
            if(match == hmap.size()){
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
}