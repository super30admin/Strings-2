// Time Complexity : O(m + n), m -> Length of p, n -> Length of s
// Space Complexity : O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p.length() > s.length()) 
            return result;
        Map<Character, Integer> pMap = new HashMap<>();
        for(char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0)+1);
        }
        
        int n = p.length();
        int match = 0;
        for(int i=0; i<s.length(); i++) {
            //in
            char in = s.charAt(i);
            if(pMap.containsKey(in)) {
                pMap.put(in, pMap.get(in)-1);                
                if(pMap.get(in) == 0) match++;
            }
            //out
            if(i>=p.length()) {
                char out = s.charAt(i-n);
                if(pMap.containsKey(out)) {
                    pMap.put(out, pMap.get(out)+1);
                    if(pMap.get(out) == 1) match--;
                }
            }
            
            if(match == pMap.size()) {
                result.add(i-n+1);
            }
        }
        return result;
    }
}