// Time Complexity : O(n)
// Space COmplexity : O
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p.length() > s.length()) return new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int count;
        int match = 0;
        int slow;
        ArrayList<Integer> result = new ArrayList<>();

        // maintain a hashmap for p
        for (int i=0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // start with the iteration for s
        for (int i=0; i < s.length(); i++) {
            // find character
            char c = s.charAt(i);

            // incoming character
            if (map.containsKey(c)) {
                count = map.get(c);
                count--;
                if (count == 0) {
                    match++;
                }
                map.put(c, count);
            }
            // outgoing character
            if(i >= p.length()) {
                slow = i - p.length();

                char slowChar = s.charAt(slow);
                if (map.containsKey(slowChar)) {
                    count = map.get(slowChar);
                    count++;
                    if (count == 1) {
                        match--;
                    }
                    map.put(slowChar, count);
                }
            }
            if (match == map.size()) {
                int index = i - p.length() + 1;
                result.add(index);
            }
        }
        return result;

    }
}

