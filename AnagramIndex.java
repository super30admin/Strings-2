// This solution uses a sliding window approach with a hashmap to evaluate the anagrams
// We store the frequency map for string that needs to taken as anagram
// We slide along the other string and keep adding the characters into the freqMap. If character encountered is in freq map that means we need to decrement otherwise do nothing
// We also need to have a macth count. If at all the match count that is incremented everytime a character reaches zero equals with the size of map, then basically it means the window we have is the anagram and we add the slow pointer into list
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> frequencyMap = new HashMap();
        for(char c:p.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }

        int match = 0, n = p.length();
        List<Integer> response = new ArrayList();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(frequencyMap.containsKey(c)) {
                c = s.charAt(i);
                int val = frequencyMap.get(c);
                val--;
                frequencyMap.put(c, val);
                if(val==0) {
                    match++;
                }
            }

            if(i>=n) {
                char outChar = s.charAt(i-n);
                if(frequencyMap.containsKey(outChar)) {
                    int val = frequencyMap.get(outChar);
                    val++;
                    frequencyMap.put(outChar, val);
                    if(val == 1) {
                        match--;
                    }
                }
            }

            if(match==frequencyMap.size()) {
                response.add(i-n+1);
            }
        }
        return response;
    }
}
