class Solution {
    
    /*
        Time : O(N)  | N - length of the string s
        Space : O(1) | Hashmap will have max 26 entries
        Leetcode : YES
    */
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || p == null) return result;
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i < p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0)+1);
        }
        
        int match = 0;
        
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                cnt--;
                if(cnt == 0)
                    match++;
                map.put(c, cnt);
            }
            
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1) match--;
                    map.put(out,cnt);
                }
            }
            
            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        
            
        }
        return result;
        
    }
}
