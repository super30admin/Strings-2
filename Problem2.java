// Time: O(s length)
// Space O(p length)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        int size = p.length();
        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int front =0 , back = 0;
        int toBeMatched = map.size();
        while(front < s.length()){
            char cur = s.charAt(front);
            if(map.containsKey(cur)){ 
                int freq = map.get(cur);
                if(freq == 1){
                    toBeMatched--;
                }
                map.put(cur, freq-1);
            }
            front++;
            if(front- back >p.length()){
                
            }

        }
        

        return res;
    }
}