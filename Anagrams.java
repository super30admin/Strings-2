class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count++;
                }
            }
            
            if (i >= p.length() - 1) {
                int leftIndex = i - (p.length() - 1);
                
                if (count == map.size()) {
                    res.add(leftIndex);
                }
                
                ch = s.charAt(leftIndex);
                
                if (map.containsKey(ch)) {
                    if (map.get(ch) == 0) {
                        count--;
                    }
                    map.put(ch, map.get(ch) + 1);
                }
            }
        }
        
        return res;
    }
}
