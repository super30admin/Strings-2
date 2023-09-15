// Time Complexity: O(m) + O(n)
// Space Complexity: O(n)


class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sl = s.length();
        int pl = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < pl; i++) {
            char c = p.charAt(i);
            if( !map.containsKey(c) ) {
                map.put(c, 0);
            }
            int cnt = map.get(c);
            map.put(c, cnt+1);
        }
        int match = 0;
        int i = 0;
        int j = 0;
        while( j < sl) {
            // in
            char in = s.charAt(j);
            if( map.containsKey(in) ) {
                int cnt = map.get(in);
                cnt--;
                map.put(in, cnt);
                if(cnt == 0) {
                    match++;
                }
            }
            // out
            if( (j-i) == pl) {
                char out = s.charAt(i);
                if( map.containsKey(out)) {
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out, cnt);
                    if( cnt == 1) {
                        match--;
                    }
                }

                j++;
                i++;
            } else {
                j++;
            }
            if( match == map.size()) {
                result.add(i);
            }
        }
        return result;
    }
}