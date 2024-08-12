// Time Complexity : O(m + n) - where m is length of String s and n is length of string p
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        //Store characters of p in a hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) +1);
        }

        // Iterating over String s
        int matchCount = 0;
        for(int i = 0; i < s.length(); i++) {
            // processing incoming element
            char inChar = s.charAt(i);
            if(map.containsKey(inChar)) {
                int count = map.get(inChar) - 1;
                map.put(inChar, count);
                if(count == 0) {
                    matchCount++;
                }
            }
            // processing outgoing element
            if( i >= p.length()){
                char outChar = s.charAt(i - p.length());
                if(map.containsKey(outChar)) {
                    int count = map.get(outChar) + 1;
                    map.put(outChar, count);
                    if(count == 1) {
                        matchCount--;
                    }
                }
            }

            if(map.size() == matchCount) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}