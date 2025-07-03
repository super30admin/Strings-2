//Time Complexity: O(n + m) where n = traverse s.chararray & m = traverse p.chararray
// Space Complexity: O(k) k = hashmap size of max. 26 characters , so O(1)

class FindAnagrams_LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length(), sLen = s.length();

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();

        // Build a reference hashmap using string p
        for (char ch : p.toCharArray()) 
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        
        List<Integer> result = new ArrayList<>();

        // The sliding window on the string s
        for (int i = 0; i < sLen; ++i) {
            // Add 1 more char on the right side of the window
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            // Remove 1 char from the left side of the window
            if (i >= pLen) {
                ch = s.charAt(i - pLen);
                if (sMap.get(ch) == 1)
                    sMap.remove(ch);
                else
                    sMap.put(ch, sMap.get(ch) - 1);
            }

            // compare both hashmap's in the sliding window
            if (pMap.equals(sMap))
                result.add(i - pLen + 1);
        
        }
        
        return result;
    }
}