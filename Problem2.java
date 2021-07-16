// Time - O(M+N)

// Space - O(1)


class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || s.length() < p.length()) return result;


        // storing character and their cnt's
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < p.length(); i++) {

            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);

        }

        int match = 0;

        for( int i = 0; i < s.length(); i++) {

            char in = s.charAt(i);
            // in
            if(map.containsKey(in)) { // fast pointer

                int cnt = map.get(in);
                cnt--;
                if(cnt == 0) match++; // if incoming char found decrement cnt and increment match
                map.put(in,cnt);
            }
            // out
            if(i >= p.length()) {

                char out = s.charAt(i - p.length());  //slow pointer
                if(map.containsKey(out)) {

                    int cnt = map.get(out); // if outgoing char then increment cnt and decrement match
                    cnt++;
                    if(cnt == 1) match--;
                    map.put(out,cnt);

                }


            }

            if(match == map.size()) result.add(i - p.length() + 1); // add the address of the slow pointer which is the starting char in the result

        }

        return result;

    }
}