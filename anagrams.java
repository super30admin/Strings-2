//Time Complexity: O(m + n) — build freq map for p in O(n) and slide a window over s once with O(1)-average map updates.
//Space Complexity: O(k) where k is the number of distinct chars in p (constant O(1) if only lowercase a–z).

//Count frequencies of characters in p in a map.
//Slide a window of length n over s; for each entering char, decrement its count and increment a match counter when a count hits zero; when the window exceeds n, restore the outgoing char’s count and decrement match if its count becomes positive.
//Whenever match == map.size(), record the window’s start index as an anagram position.


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int match = 0;
        for(int i = 0; i < m; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int frq = map.get(in);
                frq--;
                map.put(in, frq);
                if(frq == 0) match++;
                else if(frq < 0) match--;
            }

            if(i >= n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int frq = map.get(out);
                    frq++;
                    map.put(out, frq);
                    if(frq == 1) match--;
                    else if(frq <= 0) match++;
                }
            }

            if(match == map.size()){
                result.add(i-n+1);
            }
        }

        return result;
    }
}
