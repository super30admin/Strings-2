// Time Complexity : O(n) 
// Space Complexity :O(1) 




public class Solution {
    HashMap<Character, Integer> pMap;
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> li = new ArrayList<>();
        if(p.length() > s.length()){
            return li;
        }
        this.pMap = new HashMap<>();
        for(int i =0; i< p.length(); i++){
            pMap.put(p.charAt(i) ,pMap.getOrDefault(p.charAt(i), 0)+1);
        }
        int match = 0;
        for(int i = 0; i< s.length(); i++){
            Character c = s.charAt(i);
            //in
            if(pMap.containsKey(c)){
                int count = pMap.get(c)-1;
                pMap.put(c, count);
                if(count == 0){
                    match++;
                }
            }
            if(i >= p.length()){
                //out
                Character o = s.charAt(i-p.length());
                if(pMap.containsKey(o)){
                    int count = pMap.get(o)+1;
                    pMap.put(o, count);
                    if(count == 1){
                        match--;
                    }
                }
            }
            if(match == pMap.size()){
                li.add(i-p.length() +1);
            }
        }
        return li;
    }
}