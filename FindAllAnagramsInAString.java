// TC: O(m + n)
// SC: O(m)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() < p.length()) {
            return res;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for(int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                int count = map.get(in);
                count--;
                if(count == 0) {
                    match++;
                }
                map.put(in, count);
            }
            if(i >= p.length()) {
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    if(count == 1) {
                        match--;
                    }
                    map.put(out, count);
                }
            }
            if(match == map.size()) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}