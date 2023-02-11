// Time Complexity = O(m+n)
// Space Complexity = O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List <Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int m = p.length();
        int n = s.length();
        for(int i = 0; i < p.length(); i ++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int match =0;
        
        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i);
            //in
            if(map.containsKey(in)){
                int cnt = map.get(in) -1;
                if(cnt == 0) match++;
                map.put(in, cnt);
            }
            //out
            if(i >= m ){
                char out = s.charAt(i-m);
                if(map.containsKey(out)){
                    int cnt = map.get(out) +1;
                    if(cnt == 1) match--; // 
                    map.put(out, cnt);
                }
            }
            if(match == map.size()){
                result.add(i-m+1);
            }
        }
        return result;
    }
}