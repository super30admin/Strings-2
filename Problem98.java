//Time Complexity: O(n + m)
//Space Complexity: O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        int m = s.length();
        int n = p.length();
        int match = 0;
        List<Integer> result = new ArrayList<>();
 
        for(char ch: p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i = 0; i < m; i++) {
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                int frq = map.get(in);
                frq--;
                map.put(in, frq);
                if(frq == 0) match++;
                else if(frq < 0) match--;
            }

            if(i >= n) {
                char out = s.charAt(i-n);
                if(map.containsKey(out)) {
                    int frq = map.get(out);
                    frq++;
                    map.put(out, frq);
                    if(frq == 1) match--;
                    else if(frq <= 0) match++;
                }
            }

            if(match == map.size()){
                result.add(i-n+1);
            }
        }

        return result;
    }
}