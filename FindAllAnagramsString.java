//TC: O(m+n), asymptotic: O(m), where m is length of s, n is length of p
//SC: O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(); int n = p.length();
        List<Integer> result = new ArrayList();
        if(n>m) return result;
        Map<Character, Integer> map = new HashMap();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i);
            
            //incoming
            if(map.containsKey(in)){
                map.put(in, map.get(in)-1);
                if(map.get(in) == 0){
                    match++;
                }
            }
            
            //outgoing
            if(i >= n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    map.put(out, map.get(out)+1);
                    if(map.get(out) == 1) match--;
                }
            }
            if(match == map.size()) result.add(i-n+1);
        }
        return result;
    }
}
