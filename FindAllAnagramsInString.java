// Time Complexity : O(N) = O(s.Lenth) + O(p.length)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class FindAllAnagramsInString {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            int len1 = s.length();
            int len2 = p.length();
            Map<Character, Integer> pCount = new HashMap<>();
            Map<Character, Integer> sCount = new HashMap<>();

            for(Character c : p.toCharArray()) {
                pCount.put(c, pCount.getOrDefault(c,0) + 1);
            }
            List<Integer> result = new ArrayList<>();
            for(int i =0; i< len1; i++) {
                char c = s.charAt(i);
                sCount.put(c, sCount.getOrDefault(c,0) + 1);

                if(i >= len2) {
                    c = s.charAt(i - len2);
                    if(sCount.get(c) == 1) {
                        sCount.remove(c);
                    } else {
                        sCount.put(c, sCount.getOrDefault(c,0) - 1);
                    }
                }

                if(pCount.equals(sCount)) {
                    result.add(i - len2 +1);
                }
            }

            return result;
        }
    }
}
