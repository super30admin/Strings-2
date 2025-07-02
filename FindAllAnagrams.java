// Time -> O(n)
// Space -> O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length();
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0;
        int high = 0;

        for(int i = 0; i < m; i++){
            char curr = p.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        int match = 0;
        for(int i = 0; i < n; i++){
            // in
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr) - 1);
                if(map.get(curr) == 0) match++;
            }
            // out
            if(i >= m){
                char out = s.charAt(i - m);
                if(map.containsKey(out)){
                    map.put(out, map.get(out) + 1);
                    if(map.get(out) == 1) match--;
                }
            }
            if(match == map.size()) result.add(i - m + 1);
        }

        return result;
    }
}
