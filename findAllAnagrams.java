/*
TC --> O(n+m)
SC --> O(1)
 */

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> mp = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            mp.put(p.charAt(i), mp.getOrDefault(p.charAt(i), 0) + 1);
        }

        int matches = 0;
        int m = s.length();
        int n = p.length();

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i); // incoming character

            if (mp.containsKey(c)) {
                int val = mp.get(c);
                val--;
                mp.put(c, val);
                if (val == 0) {
                    matches++;
                }
            }

            if (i >= n) {
                char c1 = s.charAt(i - n); // outgoing character
                if (mp.containsKey(c1)) {
                    int val = mp.get(c1);
                    if (val == 0) {
                        matches--;
                    }
                    val++;
                    mp.put(c1, val);
                }
            }

            if (matches == mp.size()) {
                res.add(i - n + 1);
            }
        }

        return res;
    }
}
