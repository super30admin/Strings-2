/**
 * Finds all start indices of anagrams of string p in string s.
 * Uses sliding window with a frequency map to track character counts.
 * Returns a list of indices where valid anagrams begin.
 */
// Time Complexity: O(N), where N is the length of string s
// Space Complexity: O(1), since the hashmap size is bounded by 26 characters
class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        Map<Character, Integer> map = new HashMap();
        int sLength = s.length();
        int pLength = p.length();
        int match = 0;

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < sLength; i++) {
            char currentChar = s.charAt(i);

            if (map.containsKey(currentChar)) {
                int freq = map.get(currentChar);
                freq--;
                map.put(currentChar, freq);

                if (freq == 0) {
                    match++;
                }
            }

            if (i >= pLength) {
                char out = s.charAt(i - pLength);
                if (map.containsKey(out)) {
                    int putbackFreq = map.get(out);
                    putbackFreq++;
                    map.put(out,putbackFreq);
                    if (putbackFreq == 1)
                        match--;
                }
            }

            if (match == map.size()) {
                result.add(i - pLength + 1);
            }
        }
        return result;
    }
}