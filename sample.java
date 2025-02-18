class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int match=0;
        int count=0;
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> m = new HashMap<>();
        for (int i=0;i<p.length();i++) {
            m.put(p.charAt(i), m.getOrDefault(p.charAt(i), 0)+1);
        }
        System.out.println(m);
        for (int i=0;i<s.length();i++) {
            if (m.containsKey(s.charAt(i))) {
                count = m.get(s.charAt(i));
                count--;
                m.put(s.charAt(i), count);
                if (count == 0) {
                    match++;
                }
            }
            if(i >= p.length()) {
                char outgoing = s.charAt(i - p.length());
                if (m.containsKey(outgoing)) {
                    count = m.get(outgoing);
                    count++;
                    m.put(outgoing, count);
                    if(count == 1) {
                        match--;
                    }
                }
            }
            if (match == m.size()) {
                result.add(i - p.length()+1);
            }
        }
        return result;

    }
}
