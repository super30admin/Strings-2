// Time complexity: O(n+m) ≈ O(m) -> p.length()
// Space complexity: O(n) -> s.length()
// Run on leetcode: Yes
// Issues faced: len = map.size() and not p.length()

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int n = p.length();
        int m = s.length();
        int len = map.size();
        
        for(int i=0; i<m; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int t = map.get(c);
                t = t-1;
                map.put(c, t);
                if(t == 0)
                    len--;
            }
            
            if(i >= n){
                char ch = s.charAt(i-n);
                if(map.containsKey(ch)){
                    int t = map.get(ch);
                    t = t+1;
                    map.put(ch, t);
                    if(t == 1)
                        len++;
                }
            }
            
            if(len == 0)
                res.add(i-n+1);
        }
        
        return res;
    }
}
