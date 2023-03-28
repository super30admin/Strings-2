class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() < p.length()) {
            return result;
        }
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for(int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if(pMap.containsKey(in)) {
                int count = pMap.get(in);
                count--;
                if(count == 0) {
                    match++;
                }
                pMap.put(in, count);
            }
            if(i >= p.length()) {
                char out = s.charAt(i - p.length());
                if(pMap.containsKey(out)) {
                    int count = pMap.get(out);
                    count++;
                    if(count == 1) {
                        match--;
                    }
                    pMap.put(out, count);
                }
            }
            if(match == pMap.size()) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}