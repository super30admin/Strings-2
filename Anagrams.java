/**Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
* TC O(S+P) SC O(1) - Hashmap is of constant size since it contains only 26 alphabets
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anag = new ArrayList<>();
        if (s == null || s.length() == 0)
            return anag;
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i< p.length(); i ++) {
            char c = p.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Incoming
            if (count.containsKey(c)) {
                int val = count.get(c);
                val --;
                if (val == 0){
                    match ++;
                }
                count.put(c, val);
            }
            // Outgoing
            if (i >= p.length()){
                char out = s.charAt(i-p.length());
                if (count.containsKey(out)) {
                    int val = count.get(out);
                    val ++;
                    if (val == 1) {
                        match --;
                    }
                    count.put(out, val);
                }
            }
            if (match == count.size()) {
                anag.add(i-p.length()+1);
            }
        }
        return anag;
    }
    
}
