//Time : O(nmlogm)
//Space : O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] pc = p.toCharArray();
        Arrays.sort(pc);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + p.length(); j++) {
                sb.append(s.charAt(j));
            }
            String ns = sb.toString();
            char[] ps = ns.toCharArray();
            Arrays.sort(ps);
            String pss = new String(ps);
            String pcc = new String(pc);
            // System.out.println(pc);
            // System.out.println(ps);
            if (pcc.equals(pss)) {
                result.add(i);
            }
        }
        return result;
    }
}

// Time : O(n)
// Space : O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            // in
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int cnt = map.get(in);
                cnt--;
                if (cnt == 0) {
                    match++;
                }
                map.put(in, cnt);
            }

            if (i >= p.length()) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    int cnt = map.get(out);
                    cnt++;
                    if (cnt == 1) {
                        match--;
                    }
                    map.put(out, cnt);
                }
            }
            if (match == map.size())
                result.add(i - p.length() + 1);
        }

        return result;
    }
}
