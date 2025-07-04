// TC: O(m + n)
// SC: O(1)
// Runs on LeetCode: Yes
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            Character ch = p.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }
        int matchCount = 0;

        for (int i = 0; i < s.length(); i++) {
            // incoming
            Character incoming = s.charAt(i);
            if (map.containsKey(incoming)) {
                int count = map.get(incoming);
                count--;
                if (count == 0) {
                    matchCount++;
                }
                map.put(incoming, count);
            }

            // outgoing
            if (i - p.length() >= 0) {
                Character outgoing = s.charAt(i - p.length());
                if (map.containsKey(outgoing)) {
                    int count = map.get(outgoing);
                    count++;
                    map.put(outgoing, count);
                    if (count == 1) {
                        matchCount--;
                    }
                }
            }

            if (matchCount == map.size()) {
                result.add(i - p.length() + 1);
            }

        }
        return result;
    }
}