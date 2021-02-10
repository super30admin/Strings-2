// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Time complexity : O(n+m)
// Space complexity : O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        int m = p.length();
        while (right < n) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                int freq = map.get(c);
                freq = freq - 1;
                if (freq >= 0)
                    count++;

                map.put(c, freq);
            }

            if ((right - left) == m) {
                char t = s.charAt(left++);
                if (map.containsKey(t)) {
                    int freq = map.get(t);
                    freq = freq + 1;
                    if (freq > 0)
                        count--;
                    map.put(t, freq);
                }
            }

            if (count == m) {
                res.add(left);
            }

            right++;
        }
        return res;
    }
}
