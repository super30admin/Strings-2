//time o(m) + o(n), m - string s length, n - string p length
//space o(n)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int i=0;
        int match=0;
        while(i<s.length()) {
            //incoming character
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                count--;
                if(count == 0) {
                    match++;
                }
                map.put(ch, count);
            }
            //outgoing character
            if(i>=p.length()) {
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    if(count == 1) {
                        match--;
                    }
                    map.put(out, count);
                }
            }
            if(match == map.size()) {
                res.add(i-p.length()+1);
            }
            i++;
        }
        return res;
    }
}