// Time Complexity :O(m+n);
//Space Complexity :O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char inChar = s.charAt(i);
            if (map.containsKey(inChar)) {
                map.put(inChar, map.get(inChar) - 1);
                if (map.get(inChar) == 0) match++;
            }

            if (i >= p.length()) {
                char outChar = s.charAt(i - p.length());
                if (map.containsKey(outChar)) {
                    if (map.get(outChar) == 0) match--;
                    map.put(outChar, map.get(outChar) + 1);
                }
            }

            if (match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
